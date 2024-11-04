package DesignPatterns.AbstractFactoryMethod.ConcreteImpl.GlobalCar;

import DesignPatterns.AbstractFactoryMethod.AbstractClass.Car;

public class BydGlobal extends Car {

    @Override
    public void assembleAt() {
        System.out.println("BYD assembled at global factory.");
    }

}
