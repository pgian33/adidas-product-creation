package com.adidas.product.creation.client.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.adidas.product.creation.client.entity.City;
import com.adidas.product.creation.client.repository.CityRepository;

@Component
@RestController
@RequestMapping(value = "/")
public class RouteController {

	private static final Logger LOGGER = LoggerFactory.getLogger(RouteController.class);

	@Autowired
	private CityRepository cityRepository;

	@RequestMapping(value = "/connections-shortest-path")
	public List<City> getConnectionsShortestPath(@RequestParam(value="departureCity", required=true) String departureCity, @RequestParam(value="destinationCity", required=true) String destinationCity) {
		List<City> connectionsShortestPathList = new ArrayList<>(); 
		try {
			connectionsShortestPathList = cityRepository.getConnetionShortestPath(departureCity, destinationCity);
		}catch (Throwable e) {
			LOGGER.error("error!!" , e);
		}
		return connectionsShortestPathList;
	}
	
	@RequestMapping(value = "/time-shortest-path")
	public List<City> getTimeShortestPath(@RequestParam(value="departureCity", required=true) String departureCity, @RequestParam(value="destinationCity", required=true) String destinationCity) {
		List<City> timeShortestPathList = new ArrayList<>(); 
		try {
			timeShortestPathList = cityRepository.getTimeShortestPath(departureCity, destinationCity);
		}catch (Throwable e) {
			LOGGER.error("error!!" , e);
		}
		return timeShortestPathList;
	}
}
