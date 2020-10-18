package com.adidas.product.creation.client;

import org.springframework.web.bind.annotation.RequestMapping;

public interface GreetingsController {

	@RequestMapping("/greeting")
	String greeting();
	
	@RequestMapping("/less-connections")
	String lessConnections();
}
