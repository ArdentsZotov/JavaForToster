package ru.zotov.utils.dz4.CandyBox;

public class TestDZ4_2 {
    public static void main(String[] args) {

        Box box = new BoxCandy(5.5);

        Product p1 = new ProductImpl("Milk",40,1);
        Product p2 = new ProductImpl("Beard",25,0.7);
        Product p3 = new ProductImpl("Kolbasa",140,1.2);
        Product p4 = new ProductImpl("Apple",60,2);
        Product p5 = new ProductImpl("Krevetki",206,1);

        //debug
        System.out.println();


    }
}
