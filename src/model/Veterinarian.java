package model;

public class Veterinarian {
    private int vetId;
    private String name;
    private String specialization;
    private int experience;

    public Veterinarian(String name, String specialization, int experience) {
        this.name = name;
        this.specialization = specialization;
        this.experience = experience;
    }

    public Veterinarian(int vetId, String name, String specialization, int experience) {
        this.vetId = vetId;
        this.name = name;
        this.specialization = specialization;
        this.experience = experience;
    }

    public int getVetId() { return vetId; }
    public void setVetId(int vetId) { this.vetId = vetId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getSpecialization() { return specialization; }
    public void setSpecialization(String specialization) { this.specialization = specialization; }

    public int getExperience() { return experience; }
    public void setExperience(int experience) { this.experience = experience; }

    @Override
    public String toString() {
        return "ID: " + vetId + " | Name: " + name +
                " | Specialization: " + specialization +
                " | Experience: " + experience + " years";
    }
}