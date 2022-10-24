package com.cryptoservice.utils;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.persistence.AttributeConverter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class HashMapConverter implements AttributeConverter<Map<String, Object>, String> {

    private Object customerAttributeJSON;
    private Object customerAttributes;

    public void serializeCustomerAttributes() throws JsonProcessingException {
        this.customerAttributeJSON = objectMapper.writeValueAsString(customerAttributes);
    }

    public void deserializeCustomerAttributes() throws IOException {
        this.customerAttributes = objectMapper.readValue((JsonParser) customerAttributeJSON, HashMap.class);
    }

    ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public String convertToDatabaseColumn(Map<String, Object> customerInfo) {

        String customerInfoJson = null;
        try {
            customerInfoJson = objectMapper.writeValueAsString(customerInfo);
        } catch (final JsonProcessingException e) {
    //        logger.error("JSON writing error", e);
        }

        return customerInfoJson;
    }

    @Override
    public Map<String, Object> convertToEntityAttribute(String customerInfoJSON) {

        Map<String, Object> customerInfo = null;
        try {
            customerInfo = objectMapper.readValue(customerInfoJSON, Map.class);
        } catch (final IOException e) {
     //       logger.error("JSON reading error", e);
        }

        return customerInfo;
    }

}
