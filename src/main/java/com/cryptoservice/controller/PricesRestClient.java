package com.cryptoservice.controller;

import com.cryptoservice.dao.AssetParams;
import com.cryptoservice.utils.PricesCryptoOutput;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.client.RestTemplate;

import java.net.http.HttpHeaders;
import java.util.List;

@Component
public class PricesRestClient {


    @Autowired
    RestTemplate restTemplate;

    public List<AssetParams> getCryptoInformation() {

        System.out.println("API CoinMarketCap");

        return restTemplate.getForObject("https://rest-sandbox.coinapi.io", List.class);


    }

    public ResponseEntity<AssetParams> getCryptoInformationById(@PathVariable String id) {
        System.out.println("API CoinMarketCap");
        return restTemplate.getForEntity("https://rest-sandbox.coinapi.io", AssetParams.class);
    }

    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

}
