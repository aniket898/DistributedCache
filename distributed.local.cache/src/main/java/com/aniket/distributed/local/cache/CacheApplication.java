package com.aniket.distributed.local.cache;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan
@ImportResource(value = { "classpath:application-config.xml"})
public class CacheApplication {

	private static final Logger logger = LoggerFactory.getLogger(CacheApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(CacheApplication.class, args);
	}

}
