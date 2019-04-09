package com.company;

import java.util.ArrayList;
import java.util.List;

public class Shop {

    private String shopName;
    private List<Item> items;
    private double bill;

    public Shop(String shopName) {
        this.shopName = shopName;
        items = new ArrayList<>();
    }

    public List<Item> getItems() {
        return items;
    }

    public boolean addNewItem(Item newItem) {

        if (newItem != null) {
            return items.add(newItem);
        }
        return false;
    }

    public void showProducts() {

        for (Item description: items) {
            System.out.println(description.toString());
        }
    }

    public Item findProductByName(String name) {

        for (Item item: items){
            if (item.getNameOfProduct().equals(name)){
               return item;
            }
        }
        return null;
    }

    public boolean removeItem(String name) {

        for (Item item: items) {
            if (item.getNameOfProduct().equals(name)){
                return items.remove(item);
            }
        }
        return false;
    }

    public int addProducts(String productName, int amount) {

        Item newProduct = findProductByName(productName);
        if (newProduct != null && amount > 0) {
            newProduct.addAmount(amount);
            return amount;
        }
        return -1;
    }

    public double changePrice(String productName, double newPrice) {

        for (Item item: items){

            if (item.getNameOfProduct().equals(productName)) {
                item.setPrice(newPrice);
                return newPrice;
            }
        }
        return -1;
    }

    public boolean buyProduct(String productName, int amount) {

        Item product = findProductByName(productName);

        if (product.getQuantity() >= amount) {
            product.sellItem(amount);
            this.bill += product.getPrice() * amount;
            System.out.println("Shop -> buyProduct() - Sold!");
            return true;
        }
        System.out.println("Product not Sold!\n Amount: " + product.getQuantity());
        return false;
    }

    public double getBill() {
        return bill;
    }
}