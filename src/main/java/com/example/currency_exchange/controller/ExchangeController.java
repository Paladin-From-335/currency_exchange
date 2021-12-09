package com.example.currency_exchange.controller;

import com.example.currency_exchange.dto.CriteriaParamsDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("currency-operations")
public interface ExchangeController {

    @GetMapping("/rates/{currency}")
    String getCurrencyRates(@PathVariable String currency);

    @GetMapping("/rates/pair/{currencyFrom}&{currencyTo}")
    String getCurrencyPairRate(@PathVariable String currencyFrom, @PathVariable String currencyTo);

    @GetMapping("/available-codes")
    String getAvailableCurrencyCodes();

    @PostMapping("/rates/history/criteria-params")
    List<String> getExchangeRatesHistory(@RequestBody CriteriaParamsDto criteriaParamsDto);

    @GetMapping("/rates/best-rate/{firstCurrency}&{secondCurrency}")
    String getBestRates(@PathVariable String firstCurrency, @PathVariable String secondCurrency);

}
