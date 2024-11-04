package DesignPatterns.AbstractFactoryMethod.FactoryGenerator;

import DesignPatterns.AbstractFactoryMethod.AbstractFactory.CarFactory;
import DesignPatterns.AbstractFactoryMethod.ConcreteFactories.EUFactory.EUCarFactory;
import DesignPatterns.AbstractFactoryMethod.ConcreteFactories.GlobalFactory.GlobalCarFactory;

public class FactoryGenerator {
    public static CarFactory getCarFactory(String region) {
        if (region.equalsIgnoreCase("eu")) {
            return new EUCarFactory();
        }
        else if (region.equalsIgnoreCase("global")) {
            return new GlobalCarFactory();
        }
        return null;
    }
}
