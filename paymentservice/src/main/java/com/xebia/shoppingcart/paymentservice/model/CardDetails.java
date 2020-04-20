package com.xebia.shoppingcart.paymentservice.model;

import java.time.Month;
import java.time.Year;

public class CardDetails {
    private long creditCardNumber;
    private Month month;
    private Year year;
    private int cvv;

    public long getCreditCardNumber() {
        return creditCardNumber;
    }

    public Month getMonth() {
        return month;
    }

    public Year getYear() {
        return year;
    }

    public int getCvv() {
        return cvv;
    }




}
