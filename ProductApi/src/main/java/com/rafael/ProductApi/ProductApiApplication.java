package com.rafael.ProductApi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ProductApiApplication {

	public static void main(String[] args) {SpringApplication.run(ProductApiApplication.class, args);}

}
