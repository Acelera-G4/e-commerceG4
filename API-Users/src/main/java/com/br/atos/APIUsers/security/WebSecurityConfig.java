//package com.br.atos.APIUsers.security;
//
//import org.springframework.context.annotation.Configuration;
//
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
//
//@Configuration
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//
//
//    @Override
//    protected void configure(HttpSecurity httpSecurity) throws Exception {
////        httpSecurity.csrf().disable();
//        httpSecurity
//                .authorizeRequests()
//                .antMatchers("DELETE", "/**")
//                .hasAnyRole()
//                .antMatchers("GET", "/**")
//                .permitAll()
//                .hasAnyRole();
//
//
//
//    }
//}
