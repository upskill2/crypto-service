package com.cryptoservice.controller;

import com.cryptoservice.dao.AssetParams;
import com.cryptoservice.dao.entity.Asset;
import com.cryptoservice.service.PriceService;
import com.cryptoservice.service.PriceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("/v1")
public class PricesCoinController {

    static final String apiKey = "18BC8366-2892-4CBB-92AB-34F573C7C8E8";

    @Autowired
    PriceService priceService;

    @GetMapping(value = "/assets", produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<AssetParams> getAvailableAssets() { //@PageableDefault(1) Pageable pageable
        HttpHeaders header = new HttpHeaders();
        header.set("X-CoinAPI-Key", apiKey);

        return priceService.getAllCrypto();

    }

    @GetMapping(value = "/{asset_id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<AssetParams> getAvailableAssetsById(@PathVariable String id) {

        Optional<AssetParams> assetParams = priceService.getCryptoById(id);

        if (assetParams.isPresent()) {
            return new ResponseEntity<>(assetParams.get(), HttpStatus.OK);
        } else {
            throw new NoSuchElementException();
        }
 /*       ResponseEntity<AssetParams> response = ResponseEntity.ok(priceService.getCryptoById(id));
        priceService.saveCryptoById(response.getBody());*/

    }


}
