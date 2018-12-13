package com.company;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ProductManager {
    private List<Product> products;
    File file;

    public ProductManager() {
        file = new File("/Users/michalwierba/Desktop/FolderDoKlasyFileTask/babcia.txt");
        products = new ArrayList<>();
    }

    public List<Product> getProducts() {
        return products;
    }

    public void extractProductListFromAFile() {
        String fileContent = "";

        try {
            List<String> fileContentList;
            fileContentList = Files.readAllLines(file.toPath());
            fileContent = fileContentList.get(0);
        } catch (IOException e) {
            e.printStackTrace();
        }


        String[] productsAsString = fileContent.split("/");

        for (int i = 0; i < productsAsString.length; i++) {
            String[] productFieldsAsString = productsAsString[i].split(":");
            Product product = new Product(productFieldsAsString[0], Integer.valueOf(productFieldsAsString[1]), Double.valueOf(productFieldsAsString[2]));
            products.add(product);
        }

    }

    public double getTotalSum() {
        double totalSum = 0;

        for (Product product : products) {
            totalSum += product.getTotalCost();
        }
        return totalSum;

    }

    public Product getMostExpensiveProduct() {

        CostCompare costCompare = new CostCompare();
        Collections.sort(products, costCompare);

        return products.get(products.size() - 1);

    }

    public Product getCheapestProduct() {
        CostCompare costCompare = new CostCompare();
        Collections.sort(products, costCompare);

        return products.get(0);

    }

    public Product getMostViewedProduct() {
        AmountCompare amountCompare = new AmountCompare();
        Collections.sort(products, amountCompare);

        return products.get(products.size() - 1);

    }

    public class CostCompare implements Comparator<Product> {

        @Override
        public int compare(Product o1, Product o2) {
            return (int) (o1.getCost() - o2.getCost());
        }
    }

    public class AmountCompare implements Comparator<Product> {

        @Override
        public int compare(Product o1, Product o2) {
            return o1.getAmount() - o2.getAmount();
        }
    }

}
