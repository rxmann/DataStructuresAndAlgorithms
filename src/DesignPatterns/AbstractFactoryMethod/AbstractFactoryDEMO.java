package DesignPatterns.AbstractFactoryMethod;

import DesignPatterns.AbstractFactoryMethod.AbstractClass.Car;
import DesignPatterns.AbstractFactoryMethod.AbstractFactory.CarFactory;
import DesignPatterns.AbstractFactoryMethod.FactoryGenerator.FactoryGenerator;

public class AbstractFactoryDEMO {
    public static void main(String[] args) {
        System.out.println("Abstract Factory Method Design");

        CarFactory carFactory = FactoryGenerator.getCarFactory("eU");

        if (carFactory == null) {
            System.out.println("Cannot access the desired car factory.");
            return;
        }

        Car car = carFactory.createCar("byD");

        if (car == null) {
            System.out.println("Cannot assemble the desired car.");
            return;
        }

        car.assembleAt();



    }
}
