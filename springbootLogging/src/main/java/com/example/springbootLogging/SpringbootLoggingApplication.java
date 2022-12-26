package com.example.springbootLogging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringbootLoggingApplication {

	Logger log = LoggerFactory.getLogger(SpringbootLoggingApplication.class);

	@GetMapping("/test/{name}")
	public String greeting(@PathVariable String name) {
		log.debug("Request " +name);
		if(name.equalsIgnoreCase("test")){
			throw new RuntimeException("Opps exception raised..... Sanjay what you doing");
		}
		String response = "Hi "+name+" wellcome";
		log.debug("Response " +response);
		return response;
	}
	public static void main(String[] args) {
		SpringApplication.run(SpringbootLoggingApplication.class, args);
	}

}
