package com.yunus.microservice.currencyconversion.controller;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.naming.Name;

@RestController
public class CircuitBreakerController {
    @GetMapping("/sample-api")
    //@Retry(name ="sample-api" ,fallbackMethod = "fallBackMethod")
    //@CircuitBreaker(name ="default" ,fallbackMethod = "fallBackMethod")
    @RateLimiter(name = "default")
    public String sampleApi(){
        ResponseEntity<String> entity = new RestTemplate().getForEntity("http://localhost/dummy-fail" , String.class);
        return entity.getBody();
    }

    private String fallBackMethod(Exception ex){
        return "Sample Apı";
    }
}
