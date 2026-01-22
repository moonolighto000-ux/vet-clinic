package model;

import exception.InvalidInputException;

public class Dog extends Animal {

    public Dog(String name, int age, double weight) throws InvalidInputException {
        super(name, age, weight);
    }

    @Override
    public void treat() {
        System.out.println("Dog vaccinated");
    }

    @Override
    public void makeSound() {
        System.out.println("Woof! Woof!");
    }
}
