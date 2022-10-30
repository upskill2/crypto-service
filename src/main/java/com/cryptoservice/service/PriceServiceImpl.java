package com.cryptoservice.service;

import com.cryptoservice.controller.PricesCoinController;
import com.cryptoservice.domain.AssetParams;
import com.cryptoservice.dao.AssetRepository;
import com.cryptoservice.dao.entity.Asset;
import com.cryptoservice.domain.SpecificCryptoWrapper;
import com.cryptoservice.domain.SupportedCryptoCurrenciesWrapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PriceServiceImpl implements PriceService {

    @Autowired
    PricesCoinController pricesCoinController;

    @Autowired
    AssetRepository assetRepository;

    public PriceServiceImpl() {
    }


    private void alertUser(double alertPrice, String id) {
        System.out.println("New price of " + id + " is " + alertPrice);

    }

    @Override
    public  List<SupportedCryptoCurrenciesWrapper> getAllCrypto() {
        return pricesCoinController.getAvailableAssets();
    }

    @Override
    public SpecificCryptoWrapper getCryptoById(String ticker) {

        return pricesCoinController.getAvailableAssetsById(ticker);
    }

    @Override
    public void saveAllCrypto() {

        pricesCoinController.updateAllAssetsInTheDB();

    }

    @Override
    public void saveCryptoById(String id) {

        pricesCoinController.updateSpecificCryptoInTheDb(id);
    }

    @Override
    public Iterable<Asset> getAllFromRepo() {
        return assetRepository.findAll();
    }


}
