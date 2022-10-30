package com.cryptoservice.dao;

import com.cryptoservice.dao.entity.Asset;
import com.cryptoservice.domain.AssetParams;

public class AssetDTO {

    public static Asset wrapAssetParamsToAsset(AssetParams assetParams) {

        Asset asset = new Asset();
        asset.setAssetId(assetParams.getAsset_id());
        asset.setName(assetParams.getName());
        asset.setTypeIsCrypto(asset.getTypeIsCrypto());
        asset.setDataStart(assetParams.getData_start());
        asset.setDataEnd(assetParams.getData_end());
/*        asset.setDataQuoteStart(assetParams.getData_quote_start());
        asset.setDataQuoteEnd(assetParams.getData_quote_end());
        asset.setDataQuoteEnd(assetParams.getData_orderbook_end());
        asset.setDataQuoteStart(assetParams.getData_orderbook_start());*/
        asset.setPriceUsd(assetParams.getPrice_usd());

        return asset;
    }

}
