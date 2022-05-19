package com.yunus.microservice.currencyconversion.bean;

import java.math.BigDecimal;

public class CurrencyConversion {
    private Long id;
    private String from;
    private String to;
    private BigDecimal value;
    private BigDecimal currencyRate;
    private BigDecimal result;
    private String environment;

    public CurrencyConversion(){

    }

    public CurrencyConversion(Long id, String from, String to, BigDecimal value, BigDecimal currencyRate,BigDecimal result, String environment) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.value = value;
        this.currencyRate = currencyRate;
        this.environment = environment;
        this.result = result;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public BigDecimal getCurrencyRate() {
        return currencyRate;
    }

    public void setCurrencyRate(BigDecimal currencyRate) {
        this.currencyRate = currencyRate;
    }

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    public BigDecimal getResult() {
        return result;
    }

    public void setResult(BigDecimal result) {
        this.result = result;
    }
}
