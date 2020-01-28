package nate;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Util {

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

    public static void saveOrders(ArrayList<CookieOrder> orders) {
        try {
            FileOutputStream fileStream = new FileOutputStream("orders.ser");
            ObjectOutputStream os = new ObjectOutputStream(fileStream);
            os.writeObject(orders);
            os.close();
        } catch (IOException ex) {
            System.out.println("Failed to save orders.");
        }
    }

}