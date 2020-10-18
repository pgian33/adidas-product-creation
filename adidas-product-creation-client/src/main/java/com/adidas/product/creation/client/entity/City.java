package com.adidas.product.creation.client.entity;

import java.util.ArrayList;
import java.util.List;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

@NodeEntity
public class City {

	@Id
	@GeneratedValue
	private Long id;
	private String name;
	
//    @Relationship(type = "GO_TO", direction=Relationship.OUTGOING)
//    private List<CityNode> goTo = new ArrayList<>();
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private City() {
		// Empty constructor required as of Neo4j API 2.0.5
	};

	public City(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "City [id=" + id + ", name=" + name + "]";
	}
}