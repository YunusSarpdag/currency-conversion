package com.yunus.microservice.currencyconversion.controller;

import com.yunus.microservice.currencyconversion.CurrencyExchangeProxy;
import com.yunus.microservice.currencyconversion.bean.CurrencyConversion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@RestController
public class CurrencyConversionController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    CurrencyExchangeProxy proxy;

    @GetMapping("/currency-conversion/from/{from}/to/{to}/value/{value}")
    public CurrencyConversion calculateCurrencyConversion(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal value){
        Map<String , String> variableMap = new HashMap<>();
        variableMap.put("from" , from);
        variableMap.put("to" , to);
        ResponseEntity<CurrencyConversion> responseEntity = restTemplate.getForEntity("http://localhost:8000/currency-exchange/from/{from}/to/{to}"
                ,CurrencyConversion.class ,variableMap);
        CurrencyConversion currencyConversion = responseEntity.getBody();
        return new CurrencyConversion(currencyConversion.getId() , from,to,value,currencyConversion.getCurrencyRate()
                ,currencyConversion.getCurrencyRate().multiply(value) ,currencyConversion.getEnvironment());
    }


    @GetMapping("/currency-conversion-feign/from/{from}/to/{to}/value/{value}")
    public CurrencyConversion calculateCurrencyConversionFeign(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal value){

        CurrencyConversion currencyConversion = proxy.retrieveExchangeValue(from,to);
        return new CurrencyConversion(currencyConversion.getId() , from,to,value,currencyConversion.getCurrencyRate()
                ,currencyConversion.getCurrencyRate().multiply(value) ,currencyConversion.getEnvironment());
    }
}
