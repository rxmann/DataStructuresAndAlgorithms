package DesignPatterns.AbstractFactoryMethod.ConcreteImpl.EUCar;

import DesignPatterns.AbstractFactoryMethod.AbstractClass.Car;

public class TeslaEU extends Car {

    @Override
    public void assembleAt() {
        System.out.println("Tesla assembled at EU factory.");
    }

}
