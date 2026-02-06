package menu;

import model.*;
import database.VeterinarianDAO;
import exception.InvalidInputException;

import java.util.List;
import java.util.Scanner;

public class ClinicMenu implements Menu {

    private Scanner scanner = new Scanner(System.in);
    private VeterinarianDAO vetDAO = new VeterinarianDAO();
    private List<Animal> animals = new java.util.ArrayList<>();

    @Override
    public void start() {
        int choice = -1;
        do {
            System.out.println("\n--- VET CLINIC MENU ---");
            System.out.println("1. Add Cat / Dog (Memory)");
            System.out.println("2. View Animals (Polymorphism)");
            System.out.println("3. Add Veterinarian (DB)");
            System.out.println("4. View All Veterinarians (DB)");
            System.out.println("5. Search Vet by Name (ILIKE)");
            System.out.println("6. Search Vet by Min Experience (Numeric)");
            System.out.println("7. Search Vet by range");
            System.out.println("8. Delete Veterinarian (Safe)");
            System.out.println("0. Exit");
            System.out.print("Choice: ");

            try {
                if (scanner.hasNextInt()) {
                    choice = scanner.nextInt();
                    scanner.nextLine();
                } else {
                    scanner.nextLine();
                    continue;
                }

                switch (choice) {
                    case 1 -> addAnimal();
                    case 2 -> viewAnimals();
                    case 3 -> addVeterinarian();
                    case 4 -> viewVets();
                    case 5 -> searchVet();
                    case 6 -> searchByExperience();
                    case 7 -> searchByExperienceRange();
                    case 8 -> deleteVet();
                    case 0 -> System.out.println("Goodbye!");
                    default -> System.out.println("Invalid option.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        } while (choice != 0);
    }


    private void addVeterinarian() {
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Specialization: ");
        String spec = scanner.nextLine();
        System.out.print("Experience (years): ");
        int exp = scanner.nextInt();
        scanner.nextLine();

        vetDAO.insert(new Veterinarian(name, spec, exp));
    }

    private void viewVets() {
        List<Veterinarian> vList = vetDAO.getAll();
        if (vList.isEmpty()) {
            System.out.println("No veterinarians in DB.");
            return;
        }
        vList.forEach(System.out::println);
    }

    private void searchVet() {
        System.out.print("Search name: ");
        String name = scanner.nextLine();
        vetDAO.searchByName(name).forEach(System.out::println);
    }

    private void searchByExperience() {
        System.out.print("Enter minimum years of experience: ");
        if (scanner.hasNextInt()) {
            int minExp = scanner.nextInt();
            scanner.nextLine();

            List<Veterinarian> results = vetDAO.getByMinExperience(minExp);
            if (results.isEmpty()) {
                System.out.println("No veterinarians found with experience >= " + minExp);
            } else {
                results.forEach(System.out::println);
            }
        } else {
            System.out.println("Invalid number format.");
            scanner.nextLine();
        }
    }

    private void deleteVet() {
        System.out.print("Enter ID to delete: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Are you sure? (y/n): ");
        if (scanner.nextLine().equalsIgnoreCase("y")) {
            if (vetDAO.delete(id)) System.out.println("Deleted.");
            else System.out.println("Not found.");
        }
    }

    private void searchByExperienceRange() {
        try {
            System.out.print("Enter minimum experience: ");
            int min = scanner.nextInt();
            System.out.print("Enter maximum experience: ");
            int max = scanner.nextInt();
            scanner.nextLine();

            List<Veterinarian> results = vetDAO.getByExperienceRange(min, max);

            if (results.isEmpty()) {
                System.out.println("No veterinarians found in range " + min + " - " + max);
            } else {
                System.out.println("--- Veterinarians in range " + min + "-" + max + " ---");
                results.forEach(System.out::println);
            }
        } catch (Exception e) {
            System.out.println("Invalid input. Please enter numbers.");
            scanner.nextLine();
        }
    }


    private void addAnimal() throws InvalidInputException {
        System.out.print("1. Dog, 2. Cat? ");
        int type = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Age: ");
        int age = scanner.nextInt();
        System.out.print("Weight: ");
        double w = scanner.nextDouble();
        scanner.nextLine();

        if (type == 1) animals.add(new Dog(name, age, w));
        else animals.add(new Cat(name, age, w));
    }

    private void viewAnimals() {
        if (animals.isEmpty()) {
            System.out.println("List is empty.");
            return;
        }
        animals.forEach(System.out::println);
    }
}