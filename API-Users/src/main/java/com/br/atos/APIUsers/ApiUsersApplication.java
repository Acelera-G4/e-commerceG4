package com.br.atos.APIUsers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@SpringBootApplication
@EnableEurekaClient
public class ApiUsersApplication {

	public static void main(String[] args) {SpringApplication.run(ApiUsersApplication.class, args);	}

}
