package com.company;

public interface Employee {

    Item addNewItem(Item newItem);
    void addProducts(String name, int quantity);
    void changePrice(String name, double price);
}
