package com.company;

import java.util.Scanner;

public class Test {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        showMenu();
    }

    private static void showMenu() {

        MainHandler mainHandler = new MainHandler();
        System.out.println("1. Client\n" +
                "2. Employee\n" +
                "0. Exit");
        String choice = scanner.next();

        while (!"0".equals(choice)) {

            switch (choice) {

                case "1":
                    while (!"0".equals(choice)) {
                        System.out.println("1. Buy Product\n" +
                                "2. See Products");
                        choice = scanner.next();
                        scanner.nextLine();

                        switch (choice) {
                            case "1":
                                mainHandler.butProduct();
                                break;

                            case "2":
                                mainHandler.showProducts();
                                break;

                            default:
                                System.out.println("Wrong option");
                                break;
                        }
                        System.out.println("To pay: " + mainHandler.getShop().getBill() + " $");
                        System.out.println("Menu choose again:");
                        choice = scanner.next();
                        scanner.nextLine();
                    }

                case "2":
                    while (!"0".equals(choice)) {
                        System.out.println("Employee choose option:\n" +
                                           "1. Add new Item\n" +
                                           "2. Add Products\n" +
                                           "3. Change Price\n" +
                                           "4. See All products");
                        choice = scanner.next();
                        scanner.nextLine();

                        switch (choice) {
                            case "1":
                                System.out.println("Name of New Product:");
                                String nameProduct = scanner.next();
                                scanner.nextLine();

                                System.out.println("Add Price:");
                                double price = Double.valueOf(scanner.next());

                                System.out.println("Add Quantity:");
                                int quantity = scanner.nextInt();
                                scanner.nextLine();

                                Item item = new Item(nameProduct, price, quantity);
                                mainHandler.addNewItem(item);
                                break;

                            case "2":
                                System.out.println("Name of Products:");
                                nameProduct = scanner.next();
                                scanner.nextLine();

                                System.out.println("How much add ?:");
                                quantity = scanner.nextInt();
                                scanner.nextLine();

                                mainHandler.addProducts(nameProduct, quantity);
                                break;

                            case "3":
                                System.out.println("Name of Product");
                                nameProduct = scanner.next();
                                scanner.nextLine();

                                System.out.println("New Price:");
                                price = Double.valueOf(scanner.next());
                                scanner.nextLine();
                                mainHandler.changePrice(nameProduct, price);
                                break;

                            case "4":
                                mainHandler.showProducts();

                                default:
                                    System.out.println("Wrong Option:");
                                    break;
                        }
                    }
                    System.out.println("Exit!");
            }
        }
    }
}
