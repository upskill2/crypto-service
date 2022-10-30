package com.cryptoservice.service;

import com.cryptoservice.controller.PricesCoinController;
import com.cryptoservice.domain.AssetParams;
import com.cryptoservice.dao.AssetRepository;
import com.cryptoservice.dao.entity.Asset;
import com.cryptoservice.domain.SpecificCryptoInfo;
import com.cryptoservice.domain.SupportedCryptoCurrencies;
import com.fasterxml.jackson.databind.ObjectMapper;
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
    public  List<SupportedCryptoCurrencies> getAllCrypto() {
        return pricesCoinController.getAvailableAssets();
    }

    @Override
    public SpecificCryptoInfo getCryptoById(String ticker) {

        SpecificCryptoInfo assetParams = pricesCoinController.getAvailableAssetsById(ticker);


    //    saveCryptoById(assetParams[0]);

        return assetParams;
    }

    @Override
    public void saveAllCrypto(List<Asset> assets) {

        assetRepository.saveAll(assets);

    }

    @Override
    public void saveCryptoById(AssetParams assetParams) {

        ObjectMapper objectMapper = new ObjectMapper();
        Asset asset = objectMapper.convertValue(assetParams, Asset.class);

        assetRepository.save(asset);
    }

    @Override
    public Iterable<Asset> getAllFromRepo() {
        return assetRepository.findAll();
    }


}
