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
            String choice = getCookieChoice();
            if (choice == null) {
                break;
            }
            Integer quantity = getQuantityChoice();

            updateOrder(order, choice, quantity);
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

        if (order.numberDonated > 0) {
            System.out.println(" - Donated: " + order.numberDonated);
        }
        if (order.numberThanksALot > 0) {
            System.out.println(" - Thanks-A-Lot: " + order.numberThanksALot);
        }
        if (order.numberSmores > 0) {
            System.out.println(" - Girl Scout S'Mores: " + order.numberSmores);
        }
        if (order.numberLemonades > 0) {
            System.out.println(" - Lemonades: " + order.numberLemonades);
        }
        if (order.numberShortbreads > 0) {
            System.out.println(" - Shortbread: " + order.numberShortbreads);
        }
        if (order.numberThinMints > 0) {
            System.out.println(" - Thin Mints: " + order.numberThinMints);
        }
        if (order.numberPeanutButterPatties > 0) {
            System.out.println(" - Peanut Butter Patties: " + order.numberPeanutButterPatties);
        }
        if (order.numberCaramelDeLites > 0) {
            System.out.println(" - Caramel deLites: " + order.numberCaramelDeLites);
        }
        if (order.numberPeanutButterSandwich > 0) {
            System.out.println(" - Peanut Butter Sandwiches: " + order.numberPeanutButterSandwich);
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

    private static void updateOrder(CookieOrder order, String choice, Integer quantity) {
        if (choice.equals("1")) {
            order.numberDonated += quantity;
        } else if (choice.equals("2")) {
            order.numberThanksALot += quantity;
        } else if (choice.equals("3")) {
            order.numberSmores += quantity;
        } else if (choice.equals("4")) {
            order.numberLemonades += quantity;
        } else if (choice.equals("5")) {
            order.numberShortbreads += quantity;
        } else if (choice.equals("6")) {
            order.numberThinMints += quantity;
        } else if (choice.equals("7")) {
            order.numberPeanutButterPatties += quantity;
        } else if (choice.equals("8")) {
            order.numberCaramelDeLites += quantity;
        } else if (choice.equals("9")) {
            order.numberPeanutButterSandwich += quantity;
        } else {
            System.out.println("Swing and a miss. That isn't a choice.");
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

    private static String getCookieChoice() {
        while (true) {
            System.out.println(" 1. Donate a box (costs you 5 bucks, and no cookies) how nice");
            System.out.println(" 2. Thanks-A-Lot");
            System.out.println(" 3. Girl-Scout S'mores");
            System.out.println(" 4. Lemonades");
            System.out.println(" 5. Shortbread");
            System.out.println(" 6. Thin Mints");
            System.out.println(" 7. Peanut Butter Patties");
            System.out.println(" 8. Caramel deLites");
            System.out.println(" 9. Peanut Butter Sandwich");
            System.out.println(" Q. quit");
            System.out.print(">>> ");
            String choice = in.nextLine();
            if (choice.equalsIgnoreCase("q")) {
                return null;
            } else if (choice.equals("1") || choice.equals("2") || choice.equals("3") || choice.equals("4")
                    || choice.equals("5") || choice.equals("6") || choice.equals("7") || choice.equals("8")
                    || choice.equals("9")) {
                return choice;
            } else {
                System.out.println("Invalid choice");
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
