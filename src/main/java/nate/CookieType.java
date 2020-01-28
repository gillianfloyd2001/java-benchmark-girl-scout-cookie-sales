package nate;

import java.io.Serializable;

public enum CookieType implements Serializable {
    DONATION, THANKS_A_LOT, SMORES, LEMONADES, SHORTBREADS, THIN_MINTS, PEANUT_BUTTER_PATTIES, CARAMEL_DELITES,
    PEANUT_BUTTER_SANDWICHES;

    @Override
    public String toString() {
        switch (this) {
        case DONATION:
            return "Donation";
        case THANKS_A_LOT:
            return "Thanks-A-Lot";
        case SMORES:
            return "Girl Scout S'mores";
        case LEMONADES:
            return "Lemonades";
        case SHORTBREADS:
            return "Shortbreads";
        case THIN_MINTS:
            return "Thin Mints";
        case PEANUT_BUTTER_PATTIES:
            return "Peanut Butter Patties";
        case CARAMEL_DELITES:
            return "Caramel deLites";
        case PEANUT_BUTTER_SANDWICHES:
            return "Peanut Butter Sandwiches";
        default:
            throw new RuntimeException("Unhandled CookieType");
        }
    }
}