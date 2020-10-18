package com.adidas.product.creation.rest.helper;

import java.util.List;
import java.util.TreeMap;

import com.adidas.product.creation.client.entity.City;
import com.adidas.product.creation.rest.bean.ShortestPathResponse;

public class ProductCreationHelper {

	private static TreeMap<Integer, String> getMapFromJson(List<City> citiesList) {
		TreeMap<Integer, String> treeMap = new TreeMap<>();
		for(int i = 0; i<citiesList.size(); i++) {
			City aCity = citiesList.get(i);
			treeMap.put(i+1, aCity.getName());
		}
		return treeMap;
	}

	private static String getRepresentationFromJson(List<City> citiesList) {
		String representation = "";
		for(int i = 0; i<citiesList.size(); i++) {
			City aCity = citiesList.get(i);
			if(i != citiesList.size()-1) {
				representation = representation + aCity.getName() + "->";
			} else {
				representation = representation + aCity.getName();
			}
		}
		return representation;
	}

	public static ShortestPathResponse getShortestPathFromJson(List<City> citiesList) {
		TreeMap<Integer, String> treeMapCities = getMapFromJson(citiesList);
		String representation = getRepresentationFromJson(citiesList);

		ShortestPathResponse shortestPathResponse = new ShortestPathResponse();
		shortestPathResponse.setShortestPathCitiesMap(treeMapCities);
		shortestPathResponse.setShortesPathRepresentation(representation);

		return shortestPathResponse;
	}
}
