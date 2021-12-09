package com.example.currency_exchange.handler;

import com.example.currency_exchange.dto.AvailableCodesResponse;
import com.example.currency_exchange.dto.CurrencyHistoryResponse;
import com.example.currency_exchange.dto.CurrentPairRateResponse;
import com.example.currency_exchange.dto.CurrentRateResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.net.HttpURLConnection;
import java.net.URL;

@Component
public class CurrencyHandler {

    private String url = "https://v6.exchangerate-api.com/v6/afe9fc8b99430f25356ed975/";

    public Object getCurrentRatesForCurrency(String currency) {
        String customUrl = url + "latest/" + currency;
        CurrentRateResponse currentRateResponse = new CurrentRateResponse();
        ObjectMapper mapper = new ObjectMapper();

        try {
            URL urlForRequest = new URL(customUrl);
            HttpURLConnection connection = (HttpURLConnection) urlForRequest.openConnection();
            connection.setRequestMethod("GET");

            if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                currentRateResponse = mapper.readValue(urlForRequest, CurrentRateResponse.class);
            } else {
                return HttpStatus.BAD_REQUEST;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return currentRateResponse;
    }

    public Object getAvailableCodes() {
        String customUrl = url + "codes";
        ObjectMapper mapper = new ObjectMapper();
        AvailableCodesResponse availableCodes = new AvailableCodesResponse();
        try {
            URL urlForRequest = new URL(customUrl);
            HttpURLConnection connection = (HttpURLConnection) urlForRequest.openConnection();
            connection.setRequestMethod("GET");

            if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                availableCodes = mapper.readValue(urlForRequest, AvailableCodesResponse.class);
            } else {
                return HttpStatus.BAD_REQUEST;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return availableCodes;
    }

    public Object getCurrencyPairRate(String currencyFrom, String currencyTo) {
        String customUrl = url + "pair/" + currencyFrom + "/" + currencyTo;
        CurrentPairRateResponse rateResponse = new CurrentPairRateResponse();
        ObjectMapper mapper = new ObjectMapper();

        try {
            URL urlForRequest = new URL(customUrl);
            HttpURLConnection connection = (HttpURLConnection) urlForRequest.openConnection();
            connection.setRequestMethod("GET");

            if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                rateResponse = mapper.readValue(urlForRequest, CurrentPairRateResponse.class);
            } else {
                return HttpStatus.BAD_REQUEST;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rateResponse;
    }

    public Object getCurrencyHistory(String currency, String year, String month, String day) {
        String customUrl = url + "history/" + currency + "/" + year + "/" + month + "/" + day;
        CurrencyHistoryResponse historyResponse = new CurrencyHistoryResponse();
        ObjectMapper mapper = new ObjectMapper();

        try {
            URL urlForRequest = new URL(customUrl);
            HttpURLConnection connection = (HttpURLConnection) urlForRequest.openConnection();
            connection.setRequestMethod("GET");

            if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                historyResponse = mapper.readValue(urlForRequest, CurrencyHistoryResponse.class);
            } else {
                return HttpStatus.BAD_REQUEST;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return historyResponse;
    }
}
