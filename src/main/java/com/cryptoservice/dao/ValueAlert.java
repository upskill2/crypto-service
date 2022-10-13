package com.cryptoservice.dao;

public class ValueAlert {

    boolean status;
    String id;
    double price;

    public ValueAlert() {
    }

    public ValueAlert(boolean status, String id, double price) {
        this.status = status;
        this.id = id;
        this.price = price;
    }

    // getters and/or setters...

    @Override
    public String toString() {
        return "ValueAlert [status=" + status + ", id=" + id + ", price=" + price + "]";
    }

}
