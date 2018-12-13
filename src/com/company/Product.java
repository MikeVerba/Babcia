package com.company;


import java.util.Objects;

public class Product implements Comparable {
    private String name;
    private int amount;
    private double cost;

    public Product(String name, int amount, double cost) {
        this.name = name;
        this.amount = amount;
        this.cost = cost;

    }

    public String getName() {
        return name;
    }

    public int getAmount() {
        return amount;
    }

    public double getCost() {
        return cost;
    }

    public double getTotalCost() {
        return cost * amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return amount == product.amount &&
                Double.compare(product.cost, cost) == 0 &&
                Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, amount, cost);
    }

    @Override
    public String toString() {
        return "****" + getName() + "****\n" +
                "Ilość: " + getAmount() + "\n" +
                "Cena: " + getCost();
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }


}
