package com.cos731.bellisimo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.rest.RepositoryRestMvcAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@Configuration
@ComponentScan
@EnableJpaRepositories
@Import(RepositoryRestMvcAutoConfiguration.class)
@EnableAutoConfiguration


public class BellisimoApplication {

	public static void main(String[] args) {
		SpringApplication.run(BellisimoApplication.class, args);
	}
}
