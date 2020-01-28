package nate;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        ArrayList<CookieOrder> orders = loadOrders();

        CookieOrder order = startOrder();

        System.out.println("Hey You. Here are the cookies. ($5 a box)");
        while (true) {
            CookieType choice = getCookieChoice();
            if (choice == null) {
                break;
            }
            Integer quantity = getQuantityChoice();

            order.quantities.put(choice, quantity);
        }

        System.out.print("Total: $");
        System.out.println(order.calculateTotal());

        orders.add(order);

        displayReceipt(order);

        saveOrders(orders);
    }

    private static void displayReceipt(CookieOrder order) {
        System.out.println("--- Your Purchase ---");
        System.out.println("Total: $" + order.calculateTotal());
        System.out.println("Last Name: " + order.lastName);
        System.out.println("Address: " + order.address);
        System.out.println("Phone Or Email: " + order.phoneOrEmail);
        System.out.println("Boxes:");
        for (var entry : order.quantities.entrySet()) {
            if (entry.getValue() > 0) {
                System.out.println(" - " + entry.getKey() + ": " + entry.getValue());
            }
        }
    }

    private static void saveOrders(ArrayList<CookieOrder> orders) {
        try {
            FileOutputStream fileStream = new FileOutputStream("orders.ser");
            ObjectOutputStream os = new ObjectOutputStream(fileStream);
            os.writeObject(orders);
            os.close();
        } catch (IOException ex) {
            System.out.println("Failed to save orders.");
        }
    }

    private static Integer getQuantityChoice() {
        while (true) {
            System.out.print("How many boxes? ");
            try {
                Integer quantity = Integer.parseInt(in.nextLine());
                if (quantity > 0) {
                    return quantity;
                }
            } catch (NumberFormatException ex) {
            }
            System.out.println("Please provide a positive, whole number");
        }
    }

    private static CookieType getCookieChoice() {
        while (true) {
            for (int i = 0; i < CookieType.values().length; i++) {
                System.out.println(" " + (i + 1) + ". " + CookieType.values()[i]);
            }
            System.out.println(" Q. quit");
            System.out.print(">>> ");
            String choice = in.nextLine();
            if (choice.equalsIgnoreCase("q")) {
                return null;
            } else {
                try {
                    Integer index = Integer.parseInt(choice);
                    return CookieType.values()[index];
                } catch (NumberFormatException | IndexOutOfBoundsException e) {
                    System.out.println("Invalid choice");
                }
            }
        }
    }

    public static CookieOrder startOrder() {
        System.out.print("Last Name: ");
        String lastName = in.nextLine();
        System.out.print("Address: ");
        String address = in.nextLine();
        System.out.print("Phone or Email: ");
        String phoneOrEmail = in.nextLine();
        return new CookieOrder(lastName, address, phoneOrEmail);
    }

    public static ArrayList<CookieOrder> loadOrders() {
        try {
            FileInputStream fileStream = new FileInputStream("orders.ser");
            ObjectInputStream os = new ObjectInputStream(fileStream);
            ArrayList<CookieOrder> orders = (ArrayList<CookieOrder>) os.readObject();
            os.close();
            return orders;
        } catch (IOException | ClassNotFoundException ex) {
            return new ArrayList<CookieOrder>();
        }
    }
}
