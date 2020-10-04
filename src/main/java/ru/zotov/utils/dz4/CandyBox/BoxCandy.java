package ru.zotov.utils.dz4.CandyBox;

import lombok.Getter;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class BoxCandy implements Box {

    @Getter
    private double allowWeight;

    @Getter
    private List<Product> listProduct;

    public BoxCandy(double maxWeight) {
        this.allowWeight = maxWeight;
        listProduct = new ArrayList<>();
    }

    public BoxCandy() {
        this.allowWeight = 20;
        listProduct = new ArrayList<>();
    }

    @Override
    public boolean put(Product product) {

        try {
            if (product.getWeight() + getSummaryWeight() <= allowWeight) {
                listProduct.add(product);
                return true;
            }
            return false;
        } catch (NullPointerException exp) {
            return false;
            // throw exp;
        }
    }

    @Override
    public Double getSummaryWeight() {
        double summWeight = 0;
        for (Product a : listProduct)
            summWeight += a.getWeight();
        return summWeight;
    }

    @Override
    public Double getFullPrice() {
        double summPrice = 0;
        for (Product a : listProduct)
            summPrice += a.getPrice();
        return summPrice;
    }

    @Override
    public void showAllProducts() {
        for (Product a : listProduct) {
            System.out.println(a.getName() + " " + a.getPrice() + " " + a.getWeight() + ";");
        }
        System.out.println("All position: " + listProduct.size() + ";");
        System.out.println("Full price: " + this.getFullPrice() + ";");
        System.out.println("Summary weight: " + this.getSummaryWeight() + ".");
    }

    @Override
    public void clear() {
        listProduct.clear();
    }
}
