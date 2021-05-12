package com.product.catalogue.search.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.product.catalogue.search.model.Product;

@Transactional
public interface ProductCatalogueSearchRepository extends JpaRepository<Product, String> {

	List<Product> findByType(String type);

	Product findByProductId(Long id);

}