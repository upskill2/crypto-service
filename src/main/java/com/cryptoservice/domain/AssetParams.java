package com.cryptoservice.domain;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.Instant;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AssetParams {

//    int id;

    String asset_id; //"asset_id": "BTC",

    String name;// "name": "Bitcoin",

    int type_is_crypto;    //    "type_is_crypto":1,

    LocalDate data_start;//  "data_start":"2010-07-17",

    LocalDate data_end;//        "data_end":"2019-11-03",

    Instant data_quote_start;//       "data_quote_start":"2014-02-24T17:43:05.0000000Z",

    Instant data_quote_end;//     "data_quote_end":"2019-11-03T17:55:07.6724523Z",

    Instant data_orderbook_start;//     "data_orderbook_start":"2014-02-24T17:43:05.0000000Z",

    Instant data_orderbook_end; //       "data_orderbook_end":"2019-11-03T17:55:17.8592413Z",

    Instant data_trade_start;//        "data_trade_start":"2010-07-17T23:09:17.0000000Z",

    Instant data_trade_end;   //"data_trade_end": "2019-11-03T17:55:11.8220000Z",

    int data_symbols_count;//        "data_symbols_count":22711,

    double volume_1hrs_usd;//        "volume_1hrs_usd":102894431436.49,

    double volume_1day_usd; //        "volume_1day_usd":2086392323256.16,

    double volume_1mth_usd; //"volume_1mth_usd":57929168359984.54,

    double price_usd; //

    Instant last_updated_time = Instant.now();


}
