package com.xebia.shoppingcart.cartservice.representation;

public class ProductResponse {
    private int id;
    private String name;
    private double price;
    private String picture;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getPicture() {
        return picture;
    }

    @Override
    public String toString() {
        return "ProductResponse{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", picture='" + picture + '\'' +
                '}';
    }
}
