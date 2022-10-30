package com.cryptoservice.controller;

import com.cryptoservice.dao.AssetRepository;
import com.cryptoservice.dao.entity.Asset;
import com.cryptoservice.domain.AssetParams;
import com.cryptoservice.domain.SpecificCryptoWrapper;
import com.cryptoservice.domain.SupportedCryptoCurrenciesWrapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.io.IOException;
import java.util.*;

import static com.cryptoservice.dao.AssetDTO.wrapAssetParamsToAsset;



@RestController
@RequestMapping("/assets")
public class PricesCoinController {

    private static final String apiKey = "18BC8366-2892-4CBB-92AB-34F573C7C8E8";

    @Autowired
    AssetRepository assetRepository;

    @Autowired
    RestTemplate restTemplate;

/*    @Autowired
    ObjectMapper objectMapper;*/

    @GetMapping(value = "/supportedCurrencies", produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<SupportedCryptoCurrenciesWrapper> getAvailableAssets() {

        List<SupportedCryptoCurrenciesWrapper> cryptoList = new ArrayList<>();

        Optional<AssetParams[]> responseEntity = getAllAssetsFromApi();

        for (AssetParams asset : Objects.requireNonNull(responseEntity.get())
        ) {
            SupportedCryptoCurrenciesWrapper supported = new SupportedCryptoCurrenciesWrapper();
            supported.setCryptoName(asset.getName());
            cryptoList.add(supported);
        }

        return cryptoList;

    }

    private Optional<AssetParams[]> getAllAssetsFromApi() {

        HttpHeaders header = new HttpHeaders();
        header.set("X-CoinAPI-Key", apiKey);
        HttpEntity<String> entity = new HttpEntity<String>(header);

        return Optional.ofNullable(restTemplate
                .exchange("https://rest-sandbox.coinapi.io/v1/assets/", HttpMethod.GET, entity, AssetParams[].class).getBody());

    }

    public void updateAllAssetsInTheDB() {

        Optional<AssetParams[]> assetParams = getAllAssetsFromApi();

        if (assetParams.isPresent()) {
            for (AssetParams assetResponse : assetParams.get()
            ) {
                Asset asset = wrapAssetParamsToAsset(assetResponse);
                assetRepository.save(asset);
            }
        }

    }

    @GetMapping(value = "/price/{crypto_id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public SpecificCryptoWrapper getAvailableAssetsById(@PathVariable String crypto_id) {

        SpecificCryptoWrapper specificCryptoWrapper = new SpecificCryptoWrapper();

        Optional<AssetParams[]> responseEntity = getAvailableAssetsByIdFromApi(crypto_id);

        for (AssetParams asset : Objects.requireNonNull(responseEntity.get())) {
            specificCryptoWrapper.setCryptoName(asset.getName());
            specificCryptoWrapper.setPriceUsd(asset.getPrice_usd());
            specificCryptoWrapper.setLastUpdatedTime(asset.getLast_updated_time());
        }

        return specificCryptoWrapper;

    }


    private Optional<AssetParams[]> getAvailableAssetsByIdFromApi(String assetId) {

        HttpHeaders header = new HttpHeaders();
        header.set("X-CoinAPI-Key", apiKey);

        HttpEntity<String> entity = new HttpEntity<String>(header);

        return Optional.ofNullable(restTemplate
                .exchange("https://rest-sandbox.coinapi.io/v1/assets/" + assetId, HttpMethod.GET, entity, AssetParams[].class).getBody());

    }

    public void updateSpecificCryptoInTheDb(String id) {

        ObjectMapper objectMapper = JsonMapper.builder()
                .addModule(new JavaTimeModule())
                .build();

        Asset asset = null;

/*        Optional<AssetParams[]> assetParams = getAvailableAssetsByIdFromApi(id);
        AssetParams as = assetParams.get()[0];*/
        // asset = objectMapper.convertValue(as, Asset.class);

        File file = new File("src/main/resources/ETH.json");
        Asset assetP = null;

        try {
            assetP  = objectMapper.readValue(file, Asset.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        assetRepository.save(asset);


    }

}
