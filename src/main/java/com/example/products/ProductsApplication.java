package com.example.products;

import com.example.products.Entities.Product;
import com.example.products.Repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class ProductsApplication implements CommandLineRunner {
	@Autowired
	private ProductRepository repository;
	public static void main(String[] args) {
		SpringApplication.run(ProductsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//repository.save(new Product(null,"computer",3,1333));
		//repository.save(new Product(null,"mouse",2,23));
		//repository.save(new Product(null,"phone",1,350));
		List<Product> products = repository.findAll();
		products.forEach(p->{
			System.out.println(p.toString());
		});
		Product product= repository.findById(Math.toIntExact(Long.valueOf(1))).get();
		System.out.println(product.toString());
		System.out.println("**************************");

		List<Product> c = repository.findByNameContains("m");
		c.forEach(p->{
			System.out.println(p.toString());
		});
		System.out.println("**************************");
		List<Product> cs = repository.findByNameContains("m");
		cs.forEach(p->{
			System.out.println(p.toString());
		});

		System.out.println("-------------price greater---------------- ");
		List<Product> gt = repository.searchByPrice(20);
		gt.forEach(p->{
			System.out.println(p.toString());
		});
	}
}
