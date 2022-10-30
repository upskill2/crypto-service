package com.cryptoservice.service;

import com.cryptoservice.domain.AssetParams;
import com.cryptoservice.dao.entity.Asset;
import com.cryptoservice.domain.SupportedCryptoCurrenciesWrapper;
import org.json.JSONObject;

import java.util.List;

public interface PriceService {

   List<SupportedCryptoCurrenciesWrapper> getAllCrypto();

    SupportedCryptoCurrenciesWrapper getCryptoById(String ticker);

    void saveAllCrypto();

    void saveCryptoById(String id);

    Iterable<Asset> getAllFromRepo();

}
