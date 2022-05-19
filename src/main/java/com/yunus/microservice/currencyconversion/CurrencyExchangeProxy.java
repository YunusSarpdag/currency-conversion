package com.yunus.microservice.currencyconversion;

import com.yunus.microservice.currencyconversion.bean.CurrencyConversion;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(name = "currency-exchange-service" ,url = "localhost:8000")
@FeignClient(name = "currency-exchange-service") // for load balance
public interface CurrencyExchangeProxy {
    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public CurrencyConversion retrieveExchangeValue(@PathVariable String from , @PathVariable String to);
}
