package DesignPatterns.AbstractFactoryMethod.ConcreteImpl.EUCar;

import DesignPatterns.AbstractFactoryMethod.AbstractClass.Car;

public class BydEU extends Car {
    @Override
    public void assembleAt() {
        System.out.println("BYD assembled at EU factory.");
    }
}
