package com.adidas.product.creation.rest.client;
import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.adidas.product.creation.client.entity.City;

@FeignClient("adidas-product-creation-client")
public interface ProductCreationClient {
	
	@RequestMapping("/connections-shortest-path")
	List<City> getConnectionsShortestPath(@RequestParam("departureCity") String departureCity, @RequestParam("destinationCity") String destinationCity);

	@RequestMapping("/time-shortest-path")
	List<City> getTimeShortestPath(@RequestParam("departureCity") String departureCity, @RequestParam("destinationCity") String destinationCity);

}