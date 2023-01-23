package scb.backend.entity;

import jakarta.persistence.Embeddable;

@Embeddable
public class Order {

    private String product;
    private double price;

    public Order(String product, double price) {
        this.product = product;
        this.price = price;
    }

    public Order() {
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
