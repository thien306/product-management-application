package com.codegym.model;

import com.sun.org.apache.bcel.internal.generic.PUSH;

public class Product {

    private long id;

    private String name;

    private double price;

    private String information;

    private String priceFormatted;

    public Product() {

    }

    public Product(long id, String name, double price, String information, String priceFormatted) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.information = information;
        this.priceFormatted = priceFormatted;
    }

    public Product(long id, String name, double price, String information ) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.information = information;

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public String getPriceFormatted() {
        return priceFormatted;
    }

    public void setPriceFormatted(String priceFormatted) {
        this.priceFormatted = priceFormatted;
    }
}
