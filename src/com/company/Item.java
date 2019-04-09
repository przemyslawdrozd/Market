package com.company;

public class Item {

    private String nameOfProduct;
    private double price;
    private int quantity;

    public Item(String nameOfProduct, double price, int quantity) {
        this.nameOfProduct = nameOfProduct;
        this.price = price;
        this.quantity = quantity;
    }

    public String getNameOfProduct() {
        return nameOfProduct;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void addAmount(int amount) {
        this.quantity += amount;
    }

    public void sellItem(int amount) {
        this.quantity -= amount;
    }

    public void setNameOfProduct(String nameOfProduct) {
        this.nameOfProduct = nameOfProduct;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return  nameOfProduct + ":\n" +
                "\tprice = " + price + "\n" +
                "\tquantity = " + quantity + "\n";
    }
}
