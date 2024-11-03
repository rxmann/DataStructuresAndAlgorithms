package DesignPatterns.FactoryMethod;

import java.util.Locale;

public class CarFactory {

    public Car getCar (String carType) {
        if (carType == null) {
            return null;
        }
        return switch (carType.toLowerCase(Locale.ROOT)) {
            case "sedan" -> new Sedan();
            case "suv" -> new Suv();
            case "truck" -> new Truck();
            default -> null;
        };
    }

}
