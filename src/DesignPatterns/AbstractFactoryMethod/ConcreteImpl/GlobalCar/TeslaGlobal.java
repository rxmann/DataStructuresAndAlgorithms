package DesignPatterns.AbstractFactoryMethod.ConcreteImpl.GlobalCar;

import DesignPatterns.AbstractFactoryMethod.AbstractClass.Car;

public class TeslaGlobal extends Car {

    @Override
    public void assembleAt() {
        System.out.println("Tesla assembled at global factory.");
    }

}
