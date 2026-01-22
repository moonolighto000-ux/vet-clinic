package model;

import exception.InvalidInputException;

public class Cat extends Animal {

    public Cat(String name, int age, double weight) throws InvalidInputException {
        super(name, age, weight);
    }

    @Override
    public void treat() {
        System.out.println("Cat given medicine");
    }

    public void meow() {
        System.out.println("Meow!");
    }
}
