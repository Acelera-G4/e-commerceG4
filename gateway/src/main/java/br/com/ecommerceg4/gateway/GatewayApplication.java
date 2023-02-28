package br.com.ecommerceg4.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
public class GatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
	}

	@Bean
	public RouteLocator gatewayRoutes(RouteLocatorBuilder builder){
		return builder.routes()
				.route(r -> r.path("/user/**").uri("http://localhost:8095/"))
				.route(r -> r.path("/address/**").uri("http://localhost:8095/"))
				.route(r -> r.path("/product/**").uri("http://localhost:8091/"))
				.route(r -> r.path("/category/**").uri("http://localhost:8091/"))
				.route(r -> r.path("/order/**").uri("http://localhost:8099/"))
				.route(r -> r.path("/card/**").uri("http://localhost:8099/"))
				.build();
	}

}
