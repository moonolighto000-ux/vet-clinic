public class Cat extends Animal {

    private boolean indoor;

    public Cat(int animalId, String name, int age, String ownerName, boolean indoor) {
        super(animalId, name, age, ownerName);
        this.indoor = indoor;
    }

    public boolean isIndoor() {
        return indoor;
    }

    @Override
    public void treat() {
        System.out.println("Cat " + name + " is receiving feline treatment.");
    }

    @Override
    public String getType() {
        return "Cat";
    }

    public void meow() {
        System.out.println(name + " says meow!");
    }

    public boolean needsVaccination() {
        return !indoor;
    }

    @Override
    public String toString() {
        return super.toString() + " | Indoor: " + indoor;
    }
}
