package com.cryptoservice.controller;

import com.cryptoservice.dao.AssetParams;
import com.cryptoservice.utils.PricesCryptoOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class PricesRestClient {

    @Autowired
    private RestTemplate restTemplate;

    public ResponseEntity<AssetParams> getCryptoInformation() {
        System.out.println("API CoinMarketCap");
        return restTemplate.getForEntity("https://rest-sandbox.coinapi.io", AssetParams.class);
    }

    public ResponseEntity<AssetParams> getCryptoInformationById(String id) {
        System.out.println("API CoinMarketCap");
        return restTemplate.getForEntity("https://rest-sandbox.coinapi.io" , AssetParams.class);
    }

    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

}
