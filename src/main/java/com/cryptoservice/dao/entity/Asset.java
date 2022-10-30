package com.cryptoservice.dao.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import java.time.Instant;
import java.time.LocalDate;

@Entity
@Table(name = "asset")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Asset {

/*    @Convert(converter = HashMapConverter.class)
    private Map<String, Object> customerAttributes;*/

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private int id;

    @Column(name = "asset_id")
    private String assetId; //"asset_id": "BTC",

    @Column(name = "name")
    private String name;// "name": "Bitcoin",

    @Column(name = "type_is_crypto")
    private int typeIsCrypto;    //    "type_is_crypto":1,

    @Column(name = "data_start")
    private LocalDate dataStart;//  "data_start":"2010-07-17",

    @Column(name = "data_end")
    private LocalDate dataEnd;//        "data_end":"2019-11-03",

    @Column(name = "data_quote_start")
    @JsonFormat(pattern = "yyyy-MM-ddTHH:mm:ss.SSSSSSSZ", locale = "America/New_York")
    private Instant dataQuoteStart;//       "data_quote_start":"2014-02-24T17:43:05.0000000Z",

    @Column(name = "data_quote_end")
    @JsonFormat(pattern = "yyyy-MM-ddTHH:mm:ss.SSSSSSSZ", locale = "America/New_York")
    private Instant dataQuoteEnd;//     "data_quote_end":"2019-11-03T17:55:07.6724523Z",

    @Column(name = "data_orderbook_start")
    @JsonFormat(pattern = "yyyy-MM-ddTHH:mm:ss.SSSSSSSZ", locale = "America/New_York")
    private Instant dataOrderBook;//     "data_orderbook_start":"2014-02-24T17:43:05.0000000Z",

    @Column(name = "data_orderbook_end")
    @JsonFormat(pattern = "yyyy-MM-ddTHH:mm:ss.SSSSSSSZ", locale = "America/New_York")
    private Instant dataOrderBookEnd; //       "data_orderbook_end":"2019-11-03T17:55:17.8592413Z",

    @Column(name = "data_trade_start")
    @JsonFormat(pattern = "yyyy-MM-ddTHH:mm:ss.SSSSSSSZ", locale = "America/New_York")
    private Instant dataTradeStart;//        "data_trade_start":"2010-07-17T23:09:17.0000000Z",

    @Column(name = "data_trade_end")
    @JsonFormat(pattern = "yyyy-MM-ddTHH:mm:ss.SSSSSSSZ", locale = "America/New_York")
    private Instant dataTradeEnd;   //"data_trade_end": "2019-11-03T17:55:11.8220000Z",

    @Column(name = "data_symbols_count")
    private int DataSymbolsCount;//        "data_symbols_count":22711,

    @Column(name = "volume_1hrs_usd")
    private double volume1hrsUsd;//        "volume_1hrs_usd":102894431436.49,

    @Column(name = "volume_1day_usd")
    private double volume1dayUsd; //        "volume_1day_usd":2086392323256.16,

    @Column(name = "volume_1mth_usd")
    private double volume1mthUsd; //"volume_1mth_usd":57929168359984.54,

    @Column(name = "price_usd")
    private double priceUsd; // "price_usd":9166.207274778093436220194944

}
