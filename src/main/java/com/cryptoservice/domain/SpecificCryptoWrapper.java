package com.cryptoservice.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SpecificCryptoWrapper extends SupportedCryptoCurrenciesWrapper {

    private double priceUsd;

    private Instant lastUpdatedTime;

}
