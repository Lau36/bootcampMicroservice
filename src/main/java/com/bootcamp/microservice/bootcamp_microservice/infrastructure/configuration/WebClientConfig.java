package com.bootcamp.microservice.bootcamp_microservice.infrastructure.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

import static com.bootcamp.microservice.bootcamp_microservice.infrastructure.utils.constans.InfraConstans.CAPACITY_MICROSERVICE_URL;

@Configuration
public class WebClientConfig {

    @Bean
    public WebClient webClient() {
        return WebClient.builder().baseUrl(CAPACITY_MICROSERVICE_URL).build();
    }
}
