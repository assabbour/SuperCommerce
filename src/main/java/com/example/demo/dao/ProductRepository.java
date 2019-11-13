package com.example.demo.dao;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.entities.Product;

@CrossOrigin("*")
@RepositoryRestResource
public interface ProductRepository extends JpaRepository<Product, Integer>{
	
	@RestResource(path="/selectedProducts")
	public List<Product> findBySelectedIsTrue();
	
	@RestResource(path="/productsByKeyword")
	public List<Product> findByNameContains(@Param("mc") String mc);

	@RestResource(path="/promoProducts")
	public List<Product> findByPromotionIsTrue();
	
	@RestResource(path="/dispoProducts")
	public List<Product> findByAvailableIsTrue();
	
	

	/**   je suis arriver  6 eme epesode  */
}
