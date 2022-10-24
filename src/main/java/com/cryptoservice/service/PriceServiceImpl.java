package com.cryptoservice.service;

import com.cryptoservice.controller.PricesCoinController;
import com.cryptoservice.controller.PricesRestClient;
import com.cryptoservice.dao.AssetParams;
import com.cryptoservice.dao.AssetRepository;
import com.cryptoservice.dao.entity.Asset;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PriceServiceImpl implements PriceService {

    @Autowired
    PricesRestClient pricesRestClient;

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
    public List<AssetParams> getAllCrypto() {
        return pricesRestClient.getCryptoInformation();
    }

    @Override
    public Optional<AssetParams> getCryptoById(String ticker) {

        return pricesCoinController.getAvailableAssetsById(ticker).getBody();
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
