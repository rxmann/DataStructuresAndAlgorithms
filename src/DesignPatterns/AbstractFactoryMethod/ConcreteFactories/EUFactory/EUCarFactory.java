package DesignPatterns.AbstractFactoryMethod.ConcreteFactories.EUFactory;

import DesignPatterns.AbstractFactoryMethod.AbstractClass.Car;
import DesignPatterns.AbstractFactoryMethod.AbstractFactory.CarFactory;
import DesignPatterns.AbstractFactoryMethod.ConcreteImpl.EUCar.BydEU;
import DesignPatterns.AbstractFactoryMethod.ConcreteImpl.EUCar.TeslaEU;

public class EUCarFactory extends CarFactory {
    @Override
    public Car createCar(String brand) {
        brand = brand.toLowerCase();
        return switch (brand) {
            case "byd" -> new BydEU();
            case "tesla" -> new TeslaEU();
            default -> null;
        };
    }
}
