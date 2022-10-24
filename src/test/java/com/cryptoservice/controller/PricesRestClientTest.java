package com.cryptoservice.controller;

import com.cryptoservice.dao.AssetParams;
import com.cryptoservice.service.PriceService;
import com.cryptoservice.service.PriceServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
class PricesRestClientTest {

    @Autowired
    PricesCoinController pricesCoinController;

    @Autowired
    PriceServiceImpl priceServiceImpl;

    @Autowired
    PricesRestClient pricesRestClient;

    @Autowired
    PriceService priceService;

    @Autowired
    RestTemplate restTemplate;


    @Test
    void getCryptoInformation() throws IOException {

/*        HttpUriRequest request = new HttpGet( "https://rest-sandbox.coinapi.io/v1/assets" );
        // When
        HttpResponse httpResponse = HttpClientBuilder.create().build().execute( request );*/



      //  ResponseEntity<AssetParams> response = restTemplate.getForEntity("v1/assets", AssetParams.class);


      AssetParams res = priceService.getCryptoById("USD");

        String s;

    }

    @Test
    void setRestTemplate() {


    }

}