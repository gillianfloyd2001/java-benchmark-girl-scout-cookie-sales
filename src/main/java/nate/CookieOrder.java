package nate;

import java.io.Serializable;
import java.util.HashMap;

public class CookieOrder implements Serializable {
    private static final long serialVersionUID = 1L;
    String lastName;
    String address;
    String phoneOrEmail;
    HashMap<CookieType, Integer> quantities;
    Boolean paid = false;

    public CookieOrder(String lastName, String address, String phoneOrEmail) {
        this.lastName = lastName;
        this.address = address;
        this.phoneOrEmail = phoneOrEmail;
        this.quantities = new HashMap<>();
    }

    public Integer calculateTotal() {
        Integer boxes = 0;
        for (Integer count : quantities.values()) {
            boxes += count;
        }
        return boxes * 5;
    }
}