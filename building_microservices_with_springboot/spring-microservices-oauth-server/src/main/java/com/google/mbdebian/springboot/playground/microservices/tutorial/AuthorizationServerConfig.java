package com.google.mbdebian.springboot.playground.microservices.tutorial;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;

/**
 * Project: spring-microservices-oauth-server
 * Package: com.google.mbdebian.springboot.playground.microservices.tutorial
 * Timestamp: 2017-03-31 16:34
 * ---
 * © 2017 Manuel Bernal Llinares <mbdebian@gmail.com>
 * All rights reserved.
 */
@Configuration
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

    // We are going to be doing a password grant, and that's not enabled by default within Spring Cloud support for
    // oAuth, so we need to autowire an authentication manager
    @Autowired
    private AuthenticationManager authManager;

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.authenticationManager(authManager);
    }

    // This method will allow us to set up the oAuth clients that we would like to make available within our application
    // or within the authorization server
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory().withClient("webapp").secret("websecret").authorizedGrantTypes("password").scopes("read,write,trust");
    }
}
