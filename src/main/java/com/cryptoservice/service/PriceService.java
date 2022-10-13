package com.cryptoservice.service;

import com.cryptoservice.CryptoServiceApplication;
import com.cryptoservice.controller.PricesRestClient;
import com.cryptoservice.dao.AssetParams;
import com.cryptoservice.utils.EnableDisableAlertOutput;
import com.cryptoservice.utils.PricesCryptoOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
public class PriceService {

    @Autowired
    private PricesRestClient pricesRestClient;

    @Autowired
    private PricesRepository pricesRepository;

    public PriceService() {
    }

    private CryptoServiceApplication getCryptoServiceApplication(){
        return CryptoServiceApplication.contextProvider()
                .getApplicationContext()
                .getBean(CryptoServiceApplication.class);
    }

    public ResponseEntity<AssetParams> getInformation() {
        return pricesRestClient.getCryptoInformation();
    }

    public ResponseEntity<AssetParams> getInformation(String id) {
        return pricesRestClient.getCryptoInformationById(id);
    }

    public String enableDisableAlert(String id, double alertPrice, boolean enableDisable) {
        pricesRepository.enableDisableAlert(enableDisable);
        if(enableDisable)
            initMonitoringOfPrice(alertPrice, id);
        return new EnableDisableAlertOutput(enableDisable, new Date()).toString();
    }

    public String initMonitoringOfPrice(double alertPrice, String id) {
        System.out.println("===> Monitoring price <===");
        List<AssetParams> info = Arrays.asList(pricesRestClient.getCryptoInformation().getBody());
        info.forEach(item->{
            if(item.getPriceUsd() > alertPrice) {
                alertUser(item.getPriceUsd(), id);
            }
        });
        return info.toString();
    }

    private void alertUser(double alertPrice, String id) {
        System.out.println("New price of "+id+" is "+alertPrice);

    }
}
