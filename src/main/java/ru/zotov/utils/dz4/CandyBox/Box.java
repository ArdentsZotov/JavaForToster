package ru.zotov.utils.dz4.CandyBox;

public interface Box {

    Double getSummaryWeight();

    Double getFullPrice();

    boolean put(Product product);

    void showAllProducts();

    void clear();
}
