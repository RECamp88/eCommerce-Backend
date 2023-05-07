package com.rachelcampbell.ecommerce;

import com.rachelcampbell.ecommerce.Model.Product;
import com.rachelcampbell.ecommerce.Repository.ProductRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EcommerceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcommerceApplication.class, args);
	}

	@Bean
	public CommandLineRunner cmd (ProductRepo productRepo) {
		return args -> {
			Product p = new Product(1, "Solitary Life", 75.00, "https://photos.google.com/album/AF1QipPMdrLz6syHCmUSn7xlGL35QKnskqm0twzsN17y/photo/AF1QipNXIfdqHTaCyk_LfJIp1LaGHFPmypjuqwXP27F0");
			productRepo.save(p);
			p = new Product(2, "Cypress Beauty", 75.00, "https://photos.google.com/album/AF1QipPMdrLz6syHCmUSn7xlGL35QKnskqm0twzsN17y/photo/AF1QipNXIfdqHTaCyk_LfJIp1LaGHFPmypjuqwXP27F0");
			productRepo.save(p);
			p = new Product(3, "Solitary", 75.00, "https://photos.google.com/album/AF1QipPMdrLz6syHCmUSn7xlGL35QKnskqm0twzsN17y/photo/AF1QipNXIfdqHTaCyk_LfJIp1LaGHFPmypjuqwXP27F0");
			productRepo.save(p);
			p = new Product(4, "Beachy Days", 75.00, "https://photos.google.com/album/AF1QipPMdrLz6syHCmUSn7xlGL35QKnskqm0twzsN17y/photo/AF1QipNXIfdqHTaCyk_LfJIp1LaGHFPmypjuqwXP27F0");
			productRepo.save(p);
			p = new Product(5, "Footsteps", 75.00, "https://photos.google.com/album/AF1QipPMdrLz6syHCmUSn7xlGL35QKnskqm0twzsN17y/photo/AF1QipNXIfdqHTaCyk_LfJIp1LaGHFPmypjuqwXP27F0");
			productRepo.save(p);
			p = new Product(6, "The Harbot", 75.00, "https://photos.google.com/album/AF1QipPMdrLz6syHCmUSn7xlGL35QKnskqm0twzsN17y/photo/AF1QipNXIfdqHTaCyk_LfJIp1LaGHFPmypjuqwXP27F0");
			productRepo.save(p);
			p = new Product(7, "Mezmorize", 75.00, "https://photos.google.com/album/AF1QipPMdrLz6syHCmUSn7xlGL35QKnskqm0twzsN17y/photo/AF1QipNXIfdqHTaCyk_LfJIp1LaGHFPmypjuqwXP27F0");
			productRepo.save(p);
			p = new Product(8, "Autumn Walk", 75.00, "https://photos.google.com/album/AF1QipPMdrLz6syHCmUSn7xlGL35QKnskqm0twzsN17y/photo/AF1QipNXIfdqHTaCyk_LfJIp1LaGHFPmypjuqwXP27F0");
			productRepo.save(p);
		};
	}

}
