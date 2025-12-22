public class Main {
    public static void main(String[] args) {

        System.out.println("=== Veterinary Clinic Management System ===\n");

        Pet pet1 = new Pet(1, "Sultan", "Dog", 4, "Aigerim");
        Pet pet2 = new Pet(2, "Murka", "Cat", 1, "Baurzhan");
        Pet pet3 = new Pet();

        Owner owner1 = new Owner(101, "Aigerim", "+77011234567", 1);
        Owner owner2 = new Owner(102, "Baurzhan", "+77017654321", 2);

        Veterinarian vet1 = new Veterinarian(201, "Dr. Zhanar", "Dog", 7);
        Veterinarian vet2 = new Veterinarian();

        System.out.println("--- PETS ---");
        System.out.println(pet1);
        System.out.println(pet2);
        System.out.println(pet3);
        System.out.println();

        System.out.println("--- OWNERS ---");
        System.out.println(owner1);
        System.out.println(owner2);
        System.out.println();

        System.out.println("--- VETERINARIANS ---");
        System.out.println(vet1);
        System.out.println(vet2);
        System.out.println();

        System.out.println("--- TESTING GETTERS ---");
        System.out.println("Pet1 name: " + pet1.getName());
        System.out.println("Owner1 phone: " + owner1.getPhone());
        System.out.println("Vet1 experience: " + vet1.getExperience());
        System.out.println();

        System.out.println("--- TESTING SETTERS ---");
        pet3.setName("Bunny");
        pet3.setSpecies("Rabbit");
        pet3.setAge(1);
        pet3.setOwnerName("Dana");
        System.out.println("Updated pet3: " + pet3);
        System.out.println();

        System.out.println("--- TESTING METHODS ---");
        System.out.println(pet2.getName() + " is young: " + pet2.isYoung());
        System.out.println(pet1.getName() + " life stage: " + pet1.getLifeStage());

        owner1.addPet();
        System.out.println(owner1.getName() + " frequent client: " + owner1.isFrequentClient());

        System.out.println(vet1.getName() + " can treat Dog: " + vet1.canTreat("Dog"));
        System.out.println(vet1.getName() + " is experienced: " + vet1.isExperienced());

        System.out.println("\n=== Program Complete ===");
    }
}
