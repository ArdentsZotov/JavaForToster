package ru.zotov.utils.dz4.CandyBox;

import lombok.Getter;

public class ProductImpl implements Product {

    @Getter
    private String name;

    @Getter
    private double price, weight;

    public ProductImpl(String name, double price, double weight) {
        this.name=name;
        this.price=price;
        this.weight=weight;
    }
}
