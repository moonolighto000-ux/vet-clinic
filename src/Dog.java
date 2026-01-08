public class Dog extends Animal {

    private String breed;

    public Dog(int animalId, String name, int age, String ownerName, String breed) {
        super(animalId, name, age, ownerName); // MUST be first
        this.breed = breed;
    }

    public String getBreed() {
        return breed;
    }

    @Override
    public void treat() {
        System.out.println("Dog " + name + " is being treated with canine medicine.");
    }

    @Override
    public String getType() {
        return "Dog";
    }

    public void bark() {
        System.out.println(name + " is barking!");
    }

    public boolean isGuardDog() {
        return breed.equalsIgnoreCase("German Shepherd");
    }

    @Override
    public String toString() {
        return super.toString() + " | Breed: " + breed;
    }
}
