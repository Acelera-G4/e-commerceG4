package com.br.atos.APIUsers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.DispatcherServletAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.DispatcherServletPath;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//@EnableWebSecurity
@SpringBootApplication
@EnableEurekaClient
public class ApiUsersApplication {

	public static void main(String[] args) {SpringApplication.run(ApiUsersApplication.class, args);	}

}
