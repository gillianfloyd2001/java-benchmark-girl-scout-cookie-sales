package nate;

import java.io.Serializable;

public class CookieOrder implements Serializable {
    private static final long serialVersionUID = 1L;
    String lastName;
    String address;
    String phoneOrEmail;
    Integer numberDonated;
    Integer numberThanksALot;
    Integer numberSmores;
    Integer numberLemonades;
    Integer numberShortbreads;
    Integer numberThinMints;
    Integer numberPeanutButterPatties;
    Integer numberCaramelDeLites;
    Integer numberPeanutButterSandwich;

    public CookieOrder(String lastName, String address, String phoneOrEmail) {
        this.lastName = lastName;
        this.address = address;
        this.phoneOrEmail = phoneOrEmail;
        this.numberDonated = 0;
        this.numberThanksALot = 0;
        this.numberSmores = 0;
        this.numberLemonades = 0;
        this.numberShortbreads = 0;
        this.numberThinMints = 0;
        this.numberPeanutButterPatties = 0;
        this.numberCaramelDeLites = 0;
        this.numberPeanutButterSandwich = 0;
    }

    public CookieOrder(String lastName, String address, String phoneOrEmail, Integer numberDonated,
            Integer numberThanksALot, Integer numberSmores, Integer numberLemonades, Integer numberShortbreads,
            Integer numberThinMints, Integer numberPeanutButterPatties, Integer numberCaramelDeLites,
            Integer numberPeanutButterSandwich) {
        this.lastName = lastName;
        this.address = address;
        this.phoneOrEmail = phoneOrEmail;
        this.numberDonated = numberDonated;
        this.numberThanksALot = numberThanksALot;
        this.numberSmores = numberSmores;
        this.numberLemonades = numberLemonades;
        this.numberShortbreads = numberShortbreads;
        this.numberThinMints = numberThinMints;
        this.numberPeanutButterPatties = numberPeanutButterPatties;
        this.numberCaramelDeLites = numberCaramelDeLites;
        this.numberPeanutButterSandwich = numberPeanutButterSandwich;
    }

    public Integer calculateTotal() {
        return (numberDonated + numberThanksALot + numberSmores + numberLemonades + numberShortbreads + numberThinMints
                + numberPeanutButterPatties + numberCaramelDeLites + numberPeanutButterSandwich) * 5;
    }
}