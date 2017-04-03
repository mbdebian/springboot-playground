package com.google.mbdebian.springboot.playground.microservices.tutorial;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author Manuel Bernal Llinares
 *         Project: spring-microservices-oauth-client
 *         Package: com.google.mbdebian.springboot.playground.microservices.tutorial
 *         Timestamp: 2017-04-03 16:42
 *         ---
 *         © 2017 Manuel Bernal Llinares <mbdebian@gmail.com>
 *         All rights reserved.
 */
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().anyRequest().authenticated().and().formLogin().and().httpBasic();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("user1").password("password1").roles("USER")
                .and().withUser("admin").password("password2").roles("ADMIN");
        auth.eraseCredentials(false);
    }
}
