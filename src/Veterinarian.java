public class Veterinarian {

    private int vetId;
    private String name;
    private String specialization;
    private int experience;

    public Veterinarian(int vetId, String name, String specialization, int experience) {
        this.vetId = vetId;
        this.name = name;
        this.specialization = specialization;
        this.experience = experience;
    }

    public Veterinarian() {
        this.vetId = 0;
        this.name = "Unknown";
        this.specialization = "General";
        this.experience = 0;
    }

    public int getVetId() {
        return vetId;
    }

    public String getName() {
        return name;
    }

    public String getSpecialization() {
        return specialization;
    }

    public int getExperience() {
        return experience;
    }

    public void setVetId(int vetId) {
        this.vetId = vetId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }


    public boolean canTreat(String species) {
        return specialization.equalsIgnoreCase(species);
    }

    public boolean isExperienced() {
        return experience > 5;
    }

    @Override
    public String toString() {
        return "Veterinarian{vetId=" + vetId +
                ", name='" + name + '\'' +
                ", specialization='" + specialization + '\'' +
                ", experience=" + experience +
                '}';
    }
}
