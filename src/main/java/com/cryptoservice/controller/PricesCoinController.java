package com.cryptoservice.controller;

import com.cryptoservice.dao.AssetRepository;
import com.cryptoservice.dao.entity.Asset;
import com.cryptoservice.domain.AssetParams;
import com.cryptoservice.domain.SpecificCryptoInfo;
import com.cryptoservice.domain.SupportedCryptoCurrencies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@RestController
@RequestMapping("/v1")
public class PricesCoinController {

    private static final String apiKey = "18BC8366-2892-4CBB-92AB-34F573C7C8E8";

    private static final String ID_ENDPOINT = "/assets/{asset_id}";

    @Autowired
    AssetRepository assetRepository;

    @Autowired
    RestTemplate restTemplate;

    public List<SupportedCryptoCurrencies> getAvailableAssets() {

        List<SupportedCryptoCurrencies> cryptoList = new ArrayList<>();

        Optional<AssetParams[]> responseEntity = getAssetsFromApi();

        for (AssetParams asset : Objects.requireNonNull(responseEntity.get())
        ) {
            SupportedCryptoCurrencies supported = new SupportedCryptoCurrencies();
            supported.setCryptoName(asset.getName());
            cryptoList.add(supported);
        }

        return cryptoList;

    }

    @GetMapping(value = "/assets", produces = {MediaType.APPLICATION_JSON_VALUE})
    private Optional<AssetParams[]> getAssetsFromApi() {

        HttpHeaders header = new HttpHeaders();
        header.set("X-CoinAPI-Key", apiKey);
        HttpEntity<String> entity = new HttpEntity<String>(header);

        return Optional.ofNullable(restTemplate
                .exchange("https://rest-sandbox.coinapi.io/v1/assets/", HttpMethod.GET, entity, AssetParams[].class).getBody());

    }

    private void saveAllAssetsInTheDB(AssetParams[] response) {
        assetRepository.deleteAll();

        List<SupportedCryptoCurrencies> cryptoToSaveList = getAvailableAssets();


        for (AssetParams assetP : response
        ) {
            Asset asset = new Asset();
            asset.setAssetId(assetP.getAsset_id());
            asset.setName(assetP.getName());

            assetRepository.save(asset);
        }
    }


    @GetMapping(value = "/assets/{asset_id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public SpecificCryptoInfo getAvailableAssetsById(@PathVariable String asset_id) {

        SpecificCryptoInfo specificCryptoInfo = new SpecificCryptoInfo();

        //     Optional<AssetParams> assetParams = Optional.ofNullable(pricesRestClient.getCryptoInformationById(ID_ENDPOINT, asset_id).getBody()) ;

        HttpHeaders header = new HttpHeaders();
        header.set("X-CoinAPI-Key", apiKey);

        HttpEntity<String> entity = new HttpEntity<String>(header);

        Optional<ResponseEntity<AssetParams[]>> responseEntity = Optional.of(restTemplate
                .exchange("https://rest-sandbox.coinapi.io/v1/assets/" + asset_id, HttpMethod.GET, entity, AssetParams[].class));

        for (AssetParams asset : Objects.requireNonNull(responseEntity.get().getBody())) {
            specificCryptoInfo.setCryptoName(asset.getName());
            specificCryptoInfo.setPriceUsd(asset.getPrice_usd());
            specificCryptoInfo.setLastUpdatedTime(asset.getLast_updated_time());
        }

        return specificCryptoInfo;

    }


}
