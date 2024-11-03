package DesignPatterns.FactoryMethod;

public class Sedan extends Car {
    @Override
    void drive() {
        System.out.println("Driving SEDAN!");
    }

    @Override
    void assemble() {
        System.out.println("Assembling SEDAN!");
    }
}
