package com.rachelcampbell.ecommerce;

import com.rachelcampbell.ecommerce.Model.Product;
import com.rachelcampbell.ecommerce.Repository.ProductRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.CacheControl;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class EcommerceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcommerceApplication.class, args);
	}

	@Bean
	public CommandLineRunner cmd (ProductRepo productRepo) {
		return args -> {
			Product p = new Product(1, "Solitary Life", 75.00, "images/1.jpg");
			productRepo.save(p);
			p = new Product(2, "Cypress Beauty", 75.00, "images/2.jpg");
			productRepo.save(p);
			p = new Product(3, "Solitary", 75.00, "images/3.jpg");
			productRepo.save(p);
			p = new Product(4, "Beachy Days", 75.00, "images/4.jpg");
			productRepo.save(p);
			p = new Product(5, "Footsteps", 75.00, "images/5.jpg");
			productRepo.save(p);
			p = new Product(6, "The Harbor", 75.00, "images/6.jpg");
			productRepo.save(p);
			p = new Product(7, "Mezmorize", 75.00, "images/7.jpg");
			productRepo.save(p);
			p = new Product(8, "Autumn Walk", 75.00, "images/8.jpg");
			productRepo.save(p);
		};
	}

}
