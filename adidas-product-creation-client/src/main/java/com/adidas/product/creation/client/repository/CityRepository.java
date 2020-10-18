package com.adidas.product.creation.client.repository;

import java.util.List;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import com.adidas.product.creation.client.entity.City;

@Repository
public interface CityRepository extends Neo4jRepository<City, Long>  {

	City findByName(String name);
	
    @Query(""
    		+ "MATCH (c1:City {name: $name})-[:GO_TO*]->(destination:City)\n"
    		+ "RETURN destination, collect(destination)"
    	) 
    List<City> getAllMilanoConnections(String name);
        
    @Query(""
    		+ "MATCH (departureCity:City {name: $name1}),(destinationCity:City {name: $name2}), p = shortestPath((departureCity)-[GO_TO*]->(destinationCity))\n"
    		+ "RETURN p")
    List<City> getConnetionShortestPath(String name1, String name2);
    
    @Query(""
    		+ "MATCH p=(departureCity:City {name: $name1})-[r:GO_TO*]->(destinationCity:City{name: $name2})\n"
    		+ "RETURN p as shortestPath,\n"
    		+ "REDUCE(time=0, r in relationships(p) | time+(duration.between(r.departureTime, r.arrivalTime)).seconds) AS totalTime "
    		+ "ORDER BY totalTime ASC\n"
    		+ "LIMIT 1")
    List<City> getTimeShortestPath(String name1, String name2);
}
