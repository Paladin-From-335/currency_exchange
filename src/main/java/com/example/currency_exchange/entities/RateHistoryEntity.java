package com.example.currency_exchange.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "rate_history")
public class RateHistoryEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "YEAR")
    private String year;

    @Column(name = "MONTH")
    private String month;

    @Column(name = "DAY")
    private String day;

    @Column(name = "BASE_CODE")
    @JsonProperty("base_code")
    private String baseCode;

    @Column(name = "RATES")
    @JsonProperty("conversion_rates")
    @Lob
    private String rates;


}
