package com.adidas.product.creation.rest.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adidas.product.creation.client.entity.City;
import com.adidas.product.creation.rest.bean.ShortestPathRequest;
import com.adidas.product.creation.rest.bean.ShortestPathResponse;
import com.adidas.product.creation.rest.client.ProductCreationClient;
import com.adidas.product.creation.rest.helper.ProductCreationHelper;

@Component
@RestController
@RequestMapping(value = "/")
public class ShortestPathController {

	private static final Logger LOGGER = LoggerFactory.getLogger(ShortestPathController.class);

	@Autowired
	private ProductCreationClient productCreationClient;

	@PostMapping("/connections-shortest-path")
	public ResponseEntity<ShortestPathResponse> getConnectionsShortestPath(@RequestBody ShortestPathRequest shortestPathRequest) {
		List<City> citiesList = new ArrayList<>();
		try {
			citiesList = productCreationClient.getConnectionsShortestPath(shortestPathRequest.getDepartureCity(), shortestPathRequest.getDestinationCity());
		} catch (Throwable e) {
			e.printStackTrace();
			LOGGER.error("error", e);
		}

		ShortestPathResponse shortestPathResponse = ProductCreationHelper.getShortestPathFromJson(citiesList);
		return new ResponseEntity<>(shortestPathResponse, HttpStatus.OK);
	}
	
	@PostMapping("/time-shortest-path")
	public ResponseEntity<ShortestPathResponse> getTimeShortestPath(@RequestBody ShortestPathRequest shortestPathRequest) {
		List<City> citiesList = new ArrayList<>();
		try {
			citiesList = productCreationClient.getTimeShortestPath(shortestPathRequest.getDepartureCity(), shortestPathRequest.getDestinationCity());
		} catch (Throwable e) {
			e.printStackTrace();
			LOGGER.error("error", e);
		}

		ShortestPathResponse shortestPathResponse = ProductCreationHelper.getShortestPathFromJson(citiesList);
		return new ResponseEntity<>(shortestPathResponse, HttpStatus.OK);
	}

}
