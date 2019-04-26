package com.rt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class OaApplication {

	public static void main(String[] args) {
		SpringApplication.run(OaApplication.class, args);
	}

}
