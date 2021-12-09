package com.example.currency_exchange.controller;

import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/history/{currency}&{year}&{month}&{day}")
    String getExchangeRatesHistory(@PathVariable String currency, @PathVariable String year,
                                   @PathVariable String month, @PathVariable String day);

    @GetMapping("/rates/best-rate/{firstCurrency}&{secondCurrency}")
    String getBestRates(@PathVariable String firstCurrency, @PathVariable String secondCurrency);

}
