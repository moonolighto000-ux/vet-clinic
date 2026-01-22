package model;

import exception.InvalidInputException;

public class Animal {

    private String name;
    private int age;
    private double weight;

    public Animal(String name, int age, double weight) throws InvalidInputException {
        this.name = name;
        setAge(age);
        setWeight(weight);
    }

    public void setAge(int age) throws InvalidInputException {
        if (age < 0)
            throw new InvalidInputException("Age cannot be negative");
        this.age = age;
    }

    public void setWeight(double weight) throws InvalidInputException {
        if (weight <= 0)
            throw new InvalidInputException("Weight must be positive");
        this.weight = weight;
    }

    public void treat() {
        System.out.println("Animal treated");
    }

    @Override
    public String toString() {
        return name + " age=" + age + " weight=" + weight;
    }
}
