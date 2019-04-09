package com.company;

import java.util.Scanner;

public class MainHandler implements UserInterface, Employee {

    private Scanner scanner = new Scanner(System.in);
    private Shop shop;

    public MainHandler() {
        this.shop = new Shop("");
    }

    @Override
    public void showProducts() {
        System.out.println("Products: ");
        shop.showProducts();
    }

    @Override
    public Item butProduct() {

        Item item;
        System.out.println("Name of Product: ");
        String productName = scanner.next();
        scanner.nextLine();
        item = shop.findProductByName(productName);

        if (item != null) {
            System.out.println("Amount: ");
            int amount = scanner.nextInt();

            if (shop.buyProduct(productName, amount)) {
                return item;
            }
            return item;
        }
        System.out.println("Product does not exist!");
        return item;
    }

    @Override
    public void changePrice(String name, double price) {
        shop.changePrice(name, price);
    }

    public Shop getShop() {
        return shop;
    }

    @Override
    public Item addNewItem(Item newItem) {
        shop.addNewItem(newItem);
        return null;
    }

    @Override
    public void addProducts(String name, int quantity) {
        shop.addProducts(name, quantity);
    }
}
