package DesignPatterns.AbstractFactoryMethod.AbstractFactory;

import DesignPatterns.AbstractFactoryMethod.AbstractClass.Car;

public abstract class CarFactory {
    public abstract Car createCar (String region);
}
