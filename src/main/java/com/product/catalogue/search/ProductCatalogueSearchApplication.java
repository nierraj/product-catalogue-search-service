package com.product.catalogue.search;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@SpringBootApplication
public class ProductCatalogueSearchApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductCatalogueSearchApplication.class, args);
	}
}
