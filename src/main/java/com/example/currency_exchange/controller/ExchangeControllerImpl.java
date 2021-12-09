package com.example.currency_exchange.controller;

import com.example.currency_exchange.dto.CriteriaParamsDto;
import com.example.currency_exchange.service.CurrencyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ExchangeControllerImpl implements ExchangeController {

    private final CurrencyService service;

    //private final BestRateHandler bestRateHandler;

    @Override
    public String getCurrencyRates(String currency) {
        return service.getCurrentRatesForCurrency(currency);
    }

    @Override
    public String getCurrencyPairRate(String currencyFrom, String currencyTo) {
        return service.getCurrencyPairRate(currencyFrom, currencyTo);
    }

    @Override
    public String getAvailableCurrencyCodes() {
        return service.getAvailableCodes();
    }

    @Override
    public List<String> getExchangeRatesHistory(CriteriaParamsDto criteriaParamsDto) {
        //if param=null, next params (foreach)
        return null;
    }

    @Override
    public String getBestRates(String firstCurrency, String secondCurrency) {
        //bestRateHandler - if sellRate>sellRate2, return link sellRate, if buyRate>buyRate2 return link buyRate2
        return null;
    }
}
