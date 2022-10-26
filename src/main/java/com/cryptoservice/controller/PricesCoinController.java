package com.cryptoservice.controller;

import com.cryptoservice.dao.AssetParams;
import com.cryptoservice.dao.entity.Asset;
import com.cryptoservice.service.PriceService;
import com.cryptoservice.service.PriceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("/v1")
public class PricesCoinController {

    private static final String apiKey = "18BC8366-2892-4CBB-92AB-34F573C7C8E8";

    private static final String ID_ENDPOINT = "/assets/{asset_id}";

/*    @Autowired
    PriceService priceService;*/

    @Autowired
    PricesRestClient pricesRestClient;

    @Autowired
    RestTemplate restTemplate;

    @GetMapping(value = "/assets", produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<AssetParams> getAvailableAssets() {


        return pricesRestClient.getCryptoInformation();

    }

    @GetMapping(value = "/assets/{asset_id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<AssetParams[]> getAvailableAssetsById(@PathVariable String asset_id) {

   //     Optional<AssetParams> assetParams = Optional.ofNullable(pricesRestClient.getCryptoInformationById(ID_ENDPOINT, asset_id).getBody()) ;

        HttpHeaders header = new HttpHeaders();
        header.set("X-CoinAPI-Key", apiKey);

        HttpEntity<String> entity = new HttpEntity<String>(header);

        ResponseEntity<AssetParams[]> responseEntity = restTemplate
                .exchange("https://rest-sandbox.coinapi.io/v1/assets/"+asset_id, HttpMethod.GET, entity, AssetParams[].class);

        return responseEntity;

/*        if (assetParams.isPresent()) {
            return new ResponseEntity<>(assetParams.get(),header, HttpStatus.OK);
        } else {
            throw new NoSuchElementException();
        }*/


 /*       ResponseEntity<AssetParams> response = ResponseEntity.ok(priceService.getCryptoById(id));
        priceService.saveCryptoById(response.getBody());*/

    }


}
