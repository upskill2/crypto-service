package com.cryptoservice.controller;

import com.cryptoservice.dao.AssetParams;
import com.cryptoservice.dao.entity.Asset;
import com.cryptoservice.service.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/assets")
public class PricesCoinController {

    @Autowired
    private PriceService priceService;

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<AssetParams> getAvailableAssets() { //@PageableDefault(1) Pageable pageable
        return ResponseEntity.ok(priceService.getInformation().getBody());

    }

    @GetMapping(value = "/{asset_id}")
    public ResponseEntity<?> getAvailableAssetsById(@PathVariable String id) {
        return ResponseEntity.ok(priceService.getInformation(id).getBody());
    }


}
