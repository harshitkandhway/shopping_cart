package com.xebia.shoppingcart.paymentservice.model;

import java.time.Month;
import java.time.Year;

public class CardDetails {
    private long creditCardNumber;
    private int month;
    private int year;
    private int cvv;

    public long getCreditCardNumber() {
        return creditCardNumber;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public int getCvv() {
        return cvv;
    }




}
