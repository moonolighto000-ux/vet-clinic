public class Animal {

    protected int animalId;
    protected String name;
    protected int age;
    protected String ownerName;

    public Animal(int animalId, String name, int age, String ownerName) {
        this.animalId = animalId;
        this.name = name;
        this.age = age;
        this.ownerName = ownerName;
    }

    public int getAnimalId() {
        return animalId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setAge(int age) {
        if (age >= 0) {
            this.age = age;
        }
    }

    public void treat() {
        System.out.println(name + " is receiving general treatment.");
    }

    public String getType() {
        return "Animal";
    }

    public boolean isAdult() {
        return age >= 2;
    }

    @Override
    public String toString() {
        return "[" + getType() + "] " + name +
                " (ID: " + animalId +
                ", Age: " + age +
                ", Owner: " + ownerName + ")";
    }
}
