package com.cryptoservice.service;

import com.cryptoservice.dao.AssetParams;
import com.cryptoservice.dao.entity.Asset;

import java.util.List;
import java.util.Optional;

public interface PriceService {

    List<AssetParams> getAllCrypto();

    void saveAllCrypto(List<Asset> assets);

    void saveCryptoById(AssetParams asset);

    Iterable<Asset> getAllFromRepo();

    AssetParams[] getCryptoById(String ticker);

}
