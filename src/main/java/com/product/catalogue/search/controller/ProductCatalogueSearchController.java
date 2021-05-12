package com.product.catalogue.search.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.product.catalogue.search.model.Product;
import com.product.catalogue.search.model.ServiceResponse;
import com.product.catalogue.search.service.ProductCatalogueService;

@RestController
@RequestMapping("/products/catalogue")
public class ProductCatalogueSearchController {
	
	@Autowired
	//@Qualifier("productCatalogueService")
	ProductCatalogueService productCatalogueService;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<Product>> getProducts(@RequestParam(value="type", required=false) String type){
		List<Product> products = productCatalogueService.getProducts(type);
		return new ResponseEntity<>(products, HttpStatus.OK);
	}
	
	@PostMapping("/create")
	public ResponseEntity<ServiceResponse> createProduct(@RequestBody Product product){
		ServiceResponse serviceResponse = productCatalogueService.addProduct(product);
		return new ResponseEntity<>(serviceResponse, HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Product> getProduct(@PathVariable Long id){
		Product product = productCatalogueService.getProduct(id);
		return new ResponseEntity<>(product, HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<ServiceResponse> updateProduct(@RequestBody Product product){
		ServiceResponse serviceResponse = productCatalogueService.updateProduct(product);
		return new ResponseEntity<>(serviceResponse, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<ServiceResponse> deleteProduct(@PathVariable Long id){
		ServiceResponse serviceResponse = productCatalogueService.deleteProduct(id);
		return new ResponseEntity<>(serviceResponse, HttpStatus.OK);
	}
	
}
