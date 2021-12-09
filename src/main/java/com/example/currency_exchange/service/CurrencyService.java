package com.example.currency_exchange.service;

import com.example.currency_exchange.dto.CurrencyHistoryResponse;
import com.example.currency_exchange.dto.CurrentPairRateResponse;
import com.example.currency_exchange.dto.CurrentRateResponse;
import com.example.currency_exchange.handler.CurrencyHandler;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CurrencyService {

    private final CurrencyHandler currencyHandler;

    public String getCurrentRatesForCurrency(String currency) {
        try {
            CurrentRateResponse response = (CurrentRateResponse) currencyHandler.getCurrentRatesForCurrency(currency);
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.writeValueAsString(response);
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public String getAvailableCodes() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.writeValueAsString(currencyHandler.getAvailableCodes());
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public String getCurrencyPairRate(String currencyFrom, String currencyTo) {
        try {
            CurrentPairRateResponse response = (CurrentPairRateResponse) currencyHandler.getCurrencyPairRate(currencyFrom, currencyTo);
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.writeValueAsString(response);
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public String getCurrencyHistory(String currency, String year, String month, String day) {
        try {
            CurrencyHistoryResponse response = (CurrencyHistoryResponse) currencyHandler.getCurrencyHistory(currency, year, month, day);
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.writeValueAsString(response);
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
