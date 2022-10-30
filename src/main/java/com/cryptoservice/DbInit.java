package com.cryptoservice;

import com.cryptoservice.dao.AssetRepository;
import com.cryptoservice.service.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;


@Component
public class DbInit {

    @Value("${required.assets.list}")
    private String listOfCrypto;

    @Autowired
    AssetRepository assetRepository;

    @Autowired
    PriceService priceService;

    @PostConstruct
    public void refreshDbWithUpdatedAssetsData() {

        priceService.saveAllCrypto();
    }

    @PreDestroy
    public void cleanUpTheDb() {

        assetRepository.deleteAll();
    }

}
