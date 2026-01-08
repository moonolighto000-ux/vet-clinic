import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    2
    private static ArrayList<Animal> animals = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\n========================================");
            System.out.println("  VETERINARY CLINIC MANAGEMENT SYSTEM");
            System.out.println("========================================");
            System.out.println("1. Add Animal (General)");
            System.out.println("2. Add Dog");
            System.out.println("3. Add Cat");
            System.out.println("4. View All Animals (Polymorphic)");
            System.out.println("5. Demonstrate Polymorphism");
            System.out.println("6. View Dogs Only");
            System.out.println("7. View Cats Only");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> addAnimal();
                case 2 -> addDog();
                case 3 -> addCat();
                case 4 -> viewAllAnimals();
                case 5 -> demonstratePolymorphism();
                case 6 -> viewDogs();
                case 7 -> viewCats();
                case 0 -> System.out.println("Program finished.");
                default -> System.out.println("Invalid choice.");
            }

        } while (choice != 0);
    }


    private static void addAnimal() {
        System.out.print("ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Name: ");
        String name = scanner.nextLine();

        System.out.print("Age: ");
        int age = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Owner: ");
        String owner = scanner.nextLine();

        Animal animal = new Animal(id, name, age, owner);
        animals.add(animal);

        System.out.println("Animal added.");
    }

    private static void addDog() {
        System.out.print("ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Name: ");
        String name = scanner.nextLine();

        System.out.print("Age: ");
        int age = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Owner: ");
        String owner = scanner.nextLine();

        System.out.print("Breed: ");
        String breed = scanner.nextLine();

        Animal dog = new Dog(id, name, age, owner, breed);
        animals.add(dog);

        System.out.println("Dog added.");
    }

    private static void addCat() {
        System.out.print("ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Name: ");
        String name = scanner.nextLine();

        System.out.print("Age: ");
        int age = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Owner: ");
        String owner = scanner.nextLine();

        System.out.print("Indoor (true/false): ");
        boolean indoor = scanner.nextBoolean();

        Animal cat = new Cat(id, name, age, owner, indoor);
        animals.add(cat);

        System.out.println("Cat added.");
    }

    private static void viewAllAnimals() {
        for (Animal a : animals) {
            System.out.println(a);
        }
    }

    private static void demonstratePolymorphism() {
        for (Animal a : animals) {
            a.treat();
        }
    }

    private static void viewDogs() {
        for (Animal a : animals) {
            if (a instanceof Dog) {
                Dog dog = (Dog) a;
                System.out.println(dog);
                dog.bark();
            }
        }
    }

    private static void viewCats() {
        for (Animal a : animals) {
            if (a instanceof Cat) {
                Cat cat = (Cat) a;
                System.out.println(cat);
                cat.meow();
            }
        }
    }
}
