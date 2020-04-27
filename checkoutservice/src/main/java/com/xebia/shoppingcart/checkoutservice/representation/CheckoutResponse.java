package com.xebia.shoppingcart.checkoutservice.representation;

public class CheckoutResponse {
    private String trackingId;
    private String shippingId;
    private double totalAmount;

    public CheckoutResponse(String trackingId, String shippingId, double totalAmount) {
        this.trackingId = trackingId;
        this.shippingId = shippingId;
        this.totalAmount = totalAmount;
    }

    public String getTrackingId() {
        return trackingId;
    }

    public void setTrackingId(String trackingId) {
        this.trackingId = trackingId;
    }

    public String getShippingId() {
        return shippingId;
    }

    public void setShippingId(String shippingId) {
        this.shippingId = shippingId;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }
}
