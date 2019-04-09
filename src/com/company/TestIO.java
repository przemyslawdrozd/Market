package com.company;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class TestIO {

    public static void main(String[] args) {

        List<Item> itemsWrite = createList();
        try (FileWriter fileWriter = new FileWriter("Items.txt")){
            for (Item i: itemsWrite) {
                fileWriter.write(i.getNameOfProduct() + "," + i.getPrice() + "," + i.getQuantity() + "\n");
            }
        }catch (IOException e) {
            e.printStackTrace();
        }


        List<Item> itemsRead = new ArrayList<>();
        Scanner scanner = null;
        try {
            scanner = new Scanner(new FileReader("Items.txt"));
            scanner.useDelimiter(",");

            while (scanner.hasNextLine()) {

                String name = scanner.next();
                scanner.skip(scanner.delimiter());

                double price = Double.valueOf(scanner.next());
                scanner.skip(scanner.delimiter());

                int quantity = Integer.valueOf(scanner.nextLine());
                itemsRead.add(new Item(name, price, quantity));
            }

            for (Item i: itemsRead) {
                System.out.println(i);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
    }


    private static List<Item> createList() {
        List<Item> items = new ArrayList<>();

        items.add(new Item("Banana", 12.32, 40));
        items.add(new Item("Apple", 1.24, 30));
        items.add(new Item("Beer", 5.37, 12));

        return items;
    }
}



















