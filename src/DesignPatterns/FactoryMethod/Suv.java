package DesignPatterns.FactoryMethod;

public class Suv extends Car {
    @Override
    void drive() {
        System.out.println("Driving SUV!");
    }

    @Override
    void assemble() {
        System.out.println("Assembling SUV!");
    }
}
