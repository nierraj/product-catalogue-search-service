package com.product.catalogue.search.service;

import java.util.List;

import com.product.catalogue.search.model.Product;
import com.product.catalogue.search.model.ServiceResponse;

public interface ProductCatalogueService {

	List<Product> getProducts(String type);

	ServiceResponse addProduct(Product product);

	Product getProduct(Long id);

	ServiceResponse updateProduct(Product product);

	ServiceResponse deleteProduct(Long id);

}
