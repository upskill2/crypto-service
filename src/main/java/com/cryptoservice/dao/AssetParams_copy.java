package com.cryptoservice.dao;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.Instant;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AssetParams_copy {

    String assetId; //"asset_id": "BTC",

    String name;// "name": "Bitcoin",

    int typeIsCrypto;    //    "type_is_crypto":1,

    LocalDate dataStart;//  "data_start":"2010-07-17",

    LocalDate dataEnd;//        "data_end":"2019-11-03",

    Instant dataQuoteStart;//       "data_quote_start":"2014-02-24T17:43:05.0000000Z",

    Instant dataQuoteEnd;//     "data_quote_end":"2019-11-03T17:55:07.6724523Z",

    Instant dataOrderBook;//     "data_orderbook_start":"2014-02-24T17:43:05.0000000Z",

    Instant dataOrderBookEnd; //       "data_orderbook_end":"2019-11-03T17:55:17.8592413Z",

    Instant dataTradeStart;//        "data_trade_start":"2010-07-17T23:09:17.0000000Z",

    Instant dataTradeEnd;   //"data_trade_end": "2019-11-03T17:55:11.8220000Z",

    int DataSymbolsCount;//        "data_symbols_count":22711,

    double volume1hrsUsd;//        "volume_1hrs_usd":102894431436.49,

    double volume1dayUsd; //        "volume_1day_usd":2086392323256.16,

    double volume1mthUsd; //"volume_1mth_usd":57929168359984.54,

    double priceUsd; //

}
