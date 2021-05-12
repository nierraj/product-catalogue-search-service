package com.product.catalogue.search.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.catalogue.search.exception.ProductAlreadyPresentException;
import com.product.catalogue.search.exception.ProductNotFoundException;
import com.product.catalogue.search.model.Product;
import com.product.catalogue.search.model.ServiceResponse;
import com.product.catalogue.search.repository.ProductCatalogueSearchRepository;

@Service("productCatalogueService")
public class ProductCatalogueServiceImpl implements ProductCatalogueService {
	
	@Autowired
	ProductCatalogueSearchRepository catalogueSearchRepository;

	@Override
	public List<Product> getProducts(String type) {
		List<Product> products;
		if (type != null){
			products  = catalogueSearchRepository.findByType(type);
		}else{
			products = catalogueSearchRepository.findAll();
		}
		
		if(products == null || products.isEmpty())
			throw new ProductNotFoundException("No products found!");
		
		return products;
	}

	@Override
	public ServiceResponse addProduct(Product product) {
		if (null != catalogueSearchRepository.findByProductId(product.getProductId())) {
			throw new ProductAlreadyPresentException("Products already present!");
		} else {
			catalogueSearchRepository.save(product);
		}
		
		return new ServiceResponse("Successful","Product added successfully");
	}

	@Override
	public Product getProduct(Long id) {
		Product product  = catalogueSearchRepository.findByProductId(id);
		if(product == null)
			throw new ProductNotFoundException("Invalid product id!");

		return product;
	}

	@Override
	public ServiceResponse updateProduct(Product product) {
		catalogueSearchRepository.save(product);
		return new ServiceResponse("Successful","Product updated successfully");
	}

	@Override
	public ServiceResponse deleteProduct(Long id) {
		Product product  = catalogueSearchRepository.findByProductId(id);
		if(product != null)
			catalogueSearchRepository.delete(product);
		else
			throw new ProductNotFoundException("Invalid product id!");
		return new ServiceResponse("Successful","Product deleted successfully");
	}

}
