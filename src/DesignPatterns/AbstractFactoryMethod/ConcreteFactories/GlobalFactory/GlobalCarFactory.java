package DesignPatterns.AbstractFactoryMethod.ConcreteFactories.GlobalFactory;

import DesignPatterns.AbstractFactoryMethod.AbstractClass.Car;
import DesignPatterns.AbstractFactoryMethod.AbstractFactory.CarFactory;
import DesignPatterns.AbstractFactoryMethod.ConcreteImpl.GlobalCar.BydGlobal;
import DesignPatterns.AbstractFactoryMethod.ConcreteImpl.GlobalCar.TeslaGlobal;

public class GlobalCarFactory extends CarFactory {
    @Override
    public Car createCar(String brand) {
        switch (brand.toLowerCase()) {
            case "byd" -> new BydGlobal();
            case "tesla" -> new TeslaGlobal();
        }
        return null;
    }

}
