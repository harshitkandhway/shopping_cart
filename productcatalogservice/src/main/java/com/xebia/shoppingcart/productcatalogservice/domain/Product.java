package com.xebia.shoppingcart.productcatalogservice.domain;
import com.xebia.shoppingcart.productcatalogservice.enumeration.Categories;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String description;
    private String picture;
    private double price;
    @Enumerated
    private Categories category;

    private Product(Builder builder) {
        name = builder.name;
        description = builder.description;
        picture = builder.picture;
        price = builder.price;
        category = builder.category;
    }

    public Product() {
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getPicture() {
        return picture;
    }

    public double getPrice() {
        return price;
    }

    public Categories getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", picture='" + picture + '\'' +
                ", price=" + price +
                ", category=" + category +
                '}';
    }

    public static final class Builder {
        private String name;
        private String description;
        private String picture;
        private double price;
        private Categories category;

        public Builder() {
        }

        public Builder withName(String val) {
            name = val;
            return this;
        }

        public Builder withDescription(String val) {
            description = val;
            return this;
        }

        public Builder withPicture(String val) {
            picture = val;
            return this;
        }

        public Builder withPrice(double val) {
            price = val;
            return this;
        }

        public Builder withCategory(Categories val) {
            category = val;
            return this;
        }

        public Product build() {
            return new Product(this);
        }

    }
}
