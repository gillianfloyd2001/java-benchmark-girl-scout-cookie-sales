package nate;

import java.util.ArrayList;
import java.util.Scanner;

public class AdminApp {
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        ArrayList<CookieOrder> orders = Util.loadOrders();

        for (int i = 0; i < orders.size(); i++) {
            CookieOrder order = orders.get(i);
            System.out.println("---");
            System.out.println("Order #" + i);
            System.out.println("Last Name: " + order.lastName);
            System.out.println("Address: " + order.address);
            System.out.println("Phone or Email: " + order.phoneOrEmail);
            System.out.println("Total: $" + order.calculateTotal());
            System.out.println("Paid: " + order.paid);
            System.out.println("---");
        }

        System.out.println("Provide an order number to mark paid (or q to quit)");
        while (true) {
            System.out.print(">>> ");
            String choice = in.nextLine();

            if (choice.equalsIgnoreCase("q")) {
                break;
            }

            try {
                Integer index = Integer.parseInt(choice);
                orders.get(index).paid = true;
                System.out.println("Order #" + index + " marked as paid.");
            } catch (NumberFormatException | IndexOutOfBoundsException ex) {
                System.out.println("Invalid Choice");
            }
        }

        Util.saveOrders(orders);
    }
}