package model;

public class Owner {

    private int ownerId;
    private String name;
    private String phone;
    private int numberOfPets;

    public Owner(int ownerId, String name, String phone, int numberOfPets) {
        this.ownerId = ownerId;
        this.name = name;
        this.phone = phone;
        this.numberOfPets = numberOfPets;
    }

    public Owner() {
        this.ownerId = 0;
        this.name = "Unknown";
        this.phone = "Unknown";
        this.numberOfPets = 0;
    }


    public int getOwnerId() {
        return ownerId;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public int getNumberOfPets() {
        return numberOfPets;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setNumberOfPets(int numberOfPets) {
        this.numberOfPets = numberOfPets;
    }


    public void addPet() {
        numberOfPets++;
    }

    public boolean isFrequentClient() {
        return numberOfPets >= 2;
    }

    @Override
    public String toString() {
        return "model.Owner{ownerId=" + ownerId +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", numberOfPets=" + numberOfPets +
                '}';
    }
}
