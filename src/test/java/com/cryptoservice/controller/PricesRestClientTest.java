package com.cryptoservice.controller;

import com.cryptoservice.domain.AssetParams;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.URI;
import java.net.URISyntaxException;

@RunWith(SpringRunner.class)
@SpringBootTest
class ControllerTest {

    @Autowired
    TestRestTemplate restTemplate;

    @LocalServerPort
    int randomServerPort;


    private final String URI_USERS_ID = "/v1/assets/ETH";


    @Test
    void getCryptoInformation() throws URISyntaxException {

        final String baseUrl = "http://localhost:" + randomServerPort + URI_USERS_ID;
        URI uri = new URI(baseUrl);

    //    AssetParams assetParams = new AssetParams();



        HttpHeaders headers = new HttpHeaders();
        headers.set("X-CoinAPI-Key", "18BC8366-2892-4CBB-92AB-34F573C7C8E8");

        HttpEntity<String> entity = new HttpEntity<String>(headers);

        HttpEntity<AssetParams> request = new HttpEntity<>(headers);

        ResponseEntity<AssetParams[]> result = restTemplate.exchange(baseUrl, HttpMethod.GET, entity, AssetParams[].class);

        //Verify request succeed
        Assert.assertEquals(201, result.getStatusCodeValue());
    }

/*    @Test
    void setRestTemplate() {

        Map<String, String> params = new HashMap<String, String>();
        params.put("asset_id", "1");

//Parse the string after getting the response
        String userStr = restTemplate.getForObject(URI_USERS_ID, String.class, params);

    }*/

}