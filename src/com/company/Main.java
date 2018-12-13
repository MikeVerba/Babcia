package com.company;

public class Main {

    public static void main(String[] args) {

        ProductManager productManager = new ProductManager();
        productManager.extractProductListFromAFile();
        System.out.println("Lista zakupów: ");
        for (Product p : productManager.getProducts()) {
            System.out.println(p);
        }
        System.out.println("Najroższy produkt: ");
        System.out.println(productManager.getMostExpensiveProduct());
        System.out.println("Najtańszy produkt: ");
        System.out.println(productManager.getCheapestProduct());
        System.out.println("Najczęściej wyświetlany produkt: ");
        System.out.println(productManager.getMostViewedProduct());
        System.out.println("Całkowity koszt zakupów: ");
        System.out.println(productManager.getTotalSum());
    }
}
