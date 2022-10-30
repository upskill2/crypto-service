package com.cryptoservice.service;

import com.cryptoservice.domain.AssetParams;
import com.cryptoservice.dao.entity.Asset;
import com.cryptoservice.domain.SupportedCryptoCurrencies;

import java.util.List;

public interface PriceService {

   List<SupportedCryptoCurrencies> getAllCrypto();

    void saveAllCrypto(List<Asset> assets);

    void saveCryptoById(AssetParams asset);

    Iterable<Asset> getAllFromRepo();

    SupportedCryptoCurrencies getCryptoById(String ticker);

}
