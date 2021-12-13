package com.example.currency_exchange;

import com.example.currency_exchange.controller.ExchangeController;
import com.example.currency_exchange.service.CurrencyService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static com.example.currency_exchange.mock.MockData.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@WebMvcTest(ExchangeController.class)
class CurrencyExchangeControllerTests {


    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CurrencyService service;

    @Test
    public void getCurrentRatesForCurrencyTest() throws Exception {
        when(service.getCurrentRatesForCurrency("USD")).thenReturn(CURRENT_RATES_FOR_CURRENCY);
        this.mockMvc.perform(get("/currency-operations/rates/USD")
                .contentType("application/json")
                .content(""))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(CURRENT_RATES_FOR_CURRENCY));
    }

    @Test
    public void getCurrencyPairRateTest() throws Exception {
        when(service.getCurrencyPairRate("EUR", "USD")).thenReturn(PAIR_RATE);
        this.mockMvc.perform(get("/currency-operations/rates/pair/EUR&USD")
                .contentType("application/json")
                .content(""))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(PAIR_RATE));
    }

    @Test
    public void getAvailableCurrencyCodesTest() throws Exception {
        when(service.getAvailableCodes()).thenReturn(AVAILABLE_CODES);
        this.mockMvc.perform(get("/currency-operations/available-codes")
                .contentType("application/json")
                .content(""))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(AVAILABLE_CODES));
    }
    @Test
    public void getExchangeRatesHistoryTest() throws Exception {
        when(service.getCurrencyHistory("EUR", "2001", "10", "27")).thenReturn(CURRENCY_RATE_HISTORY);
        this.mockMvc.perform(get("/currency-operations/history/EUR&2001&10&27")
                .contentType("application/json")
                .content(""))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(CURRENCY_RATE_HISTORY));
    }

}
