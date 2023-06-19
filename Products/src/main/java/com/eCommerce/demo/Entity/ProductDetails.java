package com.eCommerce.demo.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "product_details")
public class ProductDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String product_name;
    private Integer quantity;
    private String color;
    private double price;

    public ProductDetails(Long id, String product_name, Integer quantity, String color, double price) {
        this.id = id;
        this.product_name = product_name;
        this.quantity = quantity;
        this.color = color;
        this.price = price;
    }

    public ProductDetails() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "ProductDetails{" +
                "id=" + id +
                ", product_name='" + product_name + '\'' +
                ", quantity=" + quantity +
                ", color='" + color + '\'' +
                ", price=" + price +
                '}';
    }
}
