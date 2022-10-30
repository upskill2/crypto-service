package com.cryptoservice.service;

import org.springframework.beans.factory.annotation.Autowired;

public class MonitoringService {

    @Autowired
    PriceService priceService;

    public void updateAssetsPrices() {


        priceService.getCryptoById("USD");

    }

}
