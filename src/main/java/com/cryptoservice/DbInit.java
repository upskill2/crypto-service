package com.cryptoservice;

import com.cryptoservice.dao.AssetRepository;
import com.cryptoservice.domain.AssetParams;
import com.cryptoservice.service.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;


@Component
public class DbInit {

    @Autowired
    AssetRepository assetRepository;

    @Autowired
    PriceService priceService;

    @PostConstruct
    public void refreshDbWithUpdatedAssetsData() {

        assetRepository.deleteAll();

        priceService.getAllCrypto();

    }


}
