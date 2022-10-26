package com.cryptoservice.controller;

import com.cryptoservice.dao.AssetParams;
import com.cryptoservice.utils.PricesCryptoOutput;
import lombok.NoArgsConstructor;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
@NoArgsConstructor
public class PricesRestClient {

    @Autowired
    RestTemplate restTemplate;

    public List<AssetParams> getCryptoInformation() {

        System.out.println("API CoinMarketCap");

        return restTemplate.getForObject("https://rest-sandbox.coinapi.io", List.class);
    }

    public ResponseEntity<AssetParams> getCryptoInformationById(String endpoint, String... idParam) {
        System.out.println("API CoinMarketCap");

        org.springframework.http.HttpHeaders headers = new HttpHeaders();
        headers.set("X-CoinAPI-Key", "18BC8366-2892-4CBB-92AB-34F573C7C8E8");

        HttpEntity<String> entity = new HttpEntity<String>(headers);


        return restTemplate.getForEntity("https://rest-sandbox.coinapi.io/v1/assets/USD",  AssetParams.class, idParam);
    }

}
