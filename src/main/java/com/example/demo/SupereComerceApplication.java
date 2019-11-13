package com.example.demo;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.example.demo.dao.CategoryRepository;
import com.example.demo.dao.ProductRepository;
import com.example.demo.entities.Category;
import com.example.demo.entities.Product;

import net.bytebuddy.utility.RandomString;

@SpringBootApplication
@ComponentScan("com.example.demo.dao")
@ComponentScan("com.example.demo.entities")
public class SupereComerceApplication implements CommandLineRunner{

	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(SupereComerceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		categoryRepository.save(new Category(null, "Games", null, null));
		categoryRepository.save(new Category(null, "computer", null, null));
		categoryRepository.save(new Category(null, "Printers", null, null));
		
		
		Random rnd = new Random();	
	    categoryRepository.findAll().forEach(c->{
			for(int i = 0; i <10; i++) {
				Product p = new Product();
				p.setName(RandomString.make(10));
				p.setCurrentPrice(100+rnd.nextInt(1000));
				p.setAvailable(rnd.nextBoolean());
				p.setPromotion(rnd.nextBoolean());
				p.setSelected(rnd.nextBoolean());
				p.setDescription(RandomString.make(40));
				p.setPhotoName("https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcRKFEiSieRxuQLwM0PbD_oaQJdvPAwVFkBgNqG_l3SjGDUQRtOV");
				p.setCategory(c);
				
				productRepository.save(p);
			}
	
		
		});
	}

}
