package com.example.currency_exchange.service;

import com.example.currency_exchange.dto.CurrencyHistoryResponse;
import com.example.currency_exchange.dto.CurrentPairRateResponse;
import com.example.currency_exchange.dto.CurrentRateResponse;
import com.example.currency_exchange.entities.RateHistoryEntity;
import com.example.currency_exchange.handler.CurrencyHandler;
import com.example.currency_exchange.repo.Repo;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CurrencyService {

    private final CurrencyHandler currencyHandler;

    private final Repo repo;

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
        RateHistoryEntity rateHistoryEntity = new RateHistoryEntity();
        try {
            CurrencyHistoryResponse response = (CurrencyHistoryResponse) currencyHandler.getCurrencyHistory(currency, year, month, day);
            rateHistoryEntity.setYear(response.getYear());
            rateHistoryEntity.setMonth(response.getMonth());
            rateHistoryEntity.setDay(response.getDay());
            rateHistoryEntity.setBaseCode(response.getBaseCode());
            rateHistoryEntity.setRates(response.getConversionRates().toString());
            repo.save(rateHistoryEntity);
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.writeValueAsString(response);
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }
}
