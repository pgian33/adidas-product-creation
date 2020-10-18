package com.adidas.product.creation.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Lazy;

import com.adidas.product.creation.client.repository.CityRepository;
import com.netflix.discovery.EurekaClient;

@SpringBootApplication
public class AdidasProductCreationClientApplication {
	
	@Autowired
	@Lazy
	private EurekaClient eurekaClient;

	@Autowired
	CityRepository cityRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(AdidasProductCreationClientApplication.class, args);
	}
}
