package co.unbosque.fourpawscitizens.model.daos;

public class Pet {

    private String id;
    private String species;
    private String sex;
    private String size;
    private String neighborhood;
    private long microchip;
    private boolean potentDangerous;

    public Pet() {

    }

    public Pet(String id, String species, String sex, String size, String neighborhood, long microchip, boolean potentDangerous) {
        this.id = id;
        this.species = species;
        this.sex = sex;
        this.size = size;
        this.neighborhood = neighborhood;
        this.microchip = microchip;
        this.potentDangerous = potentDangerous;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public long getMicrochip() {
        return microchip;
    }

    public void setMicrochip(long microchip) {
        this.microchip = microchip;
    }

    public boolean isPotentDangerous() {
        return potentDangerous;
    }

    public void setPotentDangerous(boolean potentDangerous) {
        this.potentDangerous = potentDangerous;
    }
}
