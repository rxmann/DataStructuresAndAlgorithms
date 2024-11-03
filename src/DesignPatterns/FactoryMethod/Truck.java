package DesignPatterns.FactoryMethod;

public class Truck extends Car {
    @Override
    void drive() {
        System.out.println("Driving TRUCK!");
    }

    @Override
    void assemble() {
        System.out.println("Assembling TRUCK!");
    }
}
