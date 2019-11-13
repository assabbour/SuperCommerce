package com.example.demo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.ProductRepository;
import com.example.demo.entities.Product;

@RestController
@CrossOrigin(origins="*")
public class IndexController {

	@Autowired
	private ProductRepository productRepository;
	
	@PostMapping("/register")
	public String register(@RequestBody Product product) {
		productRepository.save(product);
		return "hi" + product.getName()+ "your Registration process successfully completed";
	}
	
	@DeleteMapping("/cancel/{id}")
	public String cancelRegistration(@PathVariable Integer id) {
		productRepository.deleteById(id);
		return "your delete Registration process successfully completed";
	}
}
