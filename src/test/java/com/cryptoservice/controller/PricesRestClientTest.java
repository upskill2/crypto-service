package com.cryptoservice.controller;

import com.cryptoservice.dao.AssetParams;
import com.cryptoservice.service.PriceService;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

class PricesRestClientTest {

    @Autowired
    PricesCoinController pricesCoinController;

    @Autowired
    PriceService priceService;

    @Autowired
    PricesRestClient pricesRestClient;

    @Test
    void getCryptoInformation() {

        HttpUriRequest request = new HttpGet( "https://api.github.com/users/" );

        ResponseEntity<AssetParams> res = pricesRestClient.getCryptoInformation();

        String s;

    }

    @Test
    void setRestTemplate() {


    }

}