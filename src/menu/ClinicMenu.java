package menu;

import model.*;
import exception.InvalidInputException;

import java.util.ArrayList;
import java.util.Scanner;

public class ClinicMenu implements Menu {

    private ArrayList<Animal> animals = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    @Override
    public void start() {
        int choice = -1;

        do {
            System.out.println("\n--- Vet Clinic Menu ---");
            System.out.println("1. Add Dog");
            System.out.println("2. Add Cat");
            System.out.println("3. View Animals");
            System.out.println("4. Treat Animals (Polymorphism)");
            System.out.println("5. Animals making sounds...");
            System.out.println("0. Exit");
            System.out.print("Choice: ");


            try {
                switch (choice) {
                    case 1 -> addDog();
                    case 2 -> addCat();
                    case 3 -> viewAnimals();
                    case 4 -> treatAnimals();
                    case 0 -> System.out.println("Exiting...");
                    default -> System.out.println("Invalid option.");
                }
            } catch (InvalidInputException e) {
                System.out.println("Input Error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("An unexpected error occurred.");
            }

        } while (choice != 0);
    }

    private void addDog() throws InvalidInputException {
        System.out.print("Enter dog name: ");
        String name = scanner.nextLine();

        System.out.print("Enter age: ");
        int age = scanner.nextInt();

        System.out.print("Enter weight: ");
        double weight = scanner.nextDouble();
        scanner.nextLine();

        animals.add(new Dog(name, age, weight));
        System.out.println("Dog " + name + " added successfully!");
    }

    private void addCat() throws InvalidInputException {
        System.out.print("Enter cat name: ");
        String name = scanner.nextLine();

        System.out.print("Enter age: ");
        int age = scanner.nextInt();

        System.out.print("Enter weight: ");
        double weight = scanner.nextDouble();
        scanner.nextLine();

        animals.add(new Cat(name, age, weight));
        System.out.println("Cat " + name + " added successfully!");
    }

    private void viewAnimals() {
        if (animals.isEmpty()) {
            System.out.println("No animals in the clinic.");
        } else {
            animals.forEach(System.out::println);
        }
    }

    private void treatAnimals() {
        if (animals.isEmpty()) {
            System.out.println("No animals to treat.");
            return;
        }
        System.out.println("Treating all animals...");
        for (Animal a : animals) {
            a.treat();
        }
    }

    private void makeAllSounds() {
        System.out.println("Animals making sounds...");
        // Использование интерфейса Actionable
        for (Animal a : animals) {
            a.makeSound();
        }
    }
}