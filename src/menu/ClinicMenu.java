package menu;

import model.*;
import exception.InvalidInputException;

import java.util.ArrayList;
import java.util.Scanner;

public class ClinicMenu {

    private ArrayList<Animal> animals = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void start() {

        int choice;

        do {
            System.out.println("\n1 Add Dog");
            System.out.println("2 Add Cat");
            System.out.println("3 View Animals");
            System.out.println("4 Treat Animals (Polymorphism)");
            System.out.println("0 Exit");

            choice = scanner.nextInt();

            try {
                switch (choice) {
                    case 1 -> addDog();
                    case 2 -> addCat();
                    case 3 -> viewAnimals();
                    case 4 -> treatAnimals();
                }
            } catch (InvalidInputException e) {
                System.out.println("Error: " + e.getMessage());
            }

        } while (choice != 0);
    }

    private void addDog() throws InvalidInputException {
        System.out.print("Enter dog name: ");
        scanner.nextLine();
        String name = scanner.nextLine();

        System.out.print("Enter age: ");
        int age = scanner.nextInt();

        System.out.print("Enter weight: ");
        double weight = scanner.nextDouble();

        animals.add(new Dog(name, age, weight));
        System.out.println("Dog " + name + " added!");
    }

    private void addCat() throws InvalidInputException {
        System.out.print("Enter cat name: ");
        scanner.nextLine();
        String name = scanner.nextLine();

        System.out.print("Enter age: ");
        int age = scanner.nextInt();

        System.out.print("Enter weight: ");
        double weight = scanner.nextDouble();

        animals.add(new Cat(name, age, weight));
        System.out.println("Dog " + name + " added!");
    }

    private void viewAnimals() {
        animals.forEach(System.out::println);
    }

    private void treatAnimals() {
        for (Animal a : animals)
            a.treat();
    }
}
