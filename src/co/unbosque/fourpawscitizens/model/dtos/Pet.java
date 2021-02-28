package co.unbosque.fourpawscitizens.model.dtos;

public class Pet {

    /**
     * microchip is type long
     */
    private long microchip;
    /**
     * species is type String
     */
    private String species;
    /**
     * sex is type String
     */
    private String sex;
    /**
     * size is type of String
     */
    private String size;
    /**
     * neighborhood is type String
     */
    private String neighborhood;
    /**
     * potentDangerous is type Boolean
     */
    private boolean potentDangerous;
    /**
     * id is type String
     */
    private String id;

    public Pet() {

    }

    /**
     * This constructor initialize the variables.
     * @param id a variable of the object pet. id!=null
     * @param species a variable of the object pet. species!=null
     * @param sex a variable of the object pet. sex!=null
     * @param size a variable of the object pet. size!=null
     * @param neighborhood a variable of the object pet.  neighborhood!=null
     * @param microchip a variable of the object pet. microchip!=null
     * @param potentDangerous a variable of the object pet. potentDangerous!=null
     */
    public Pet(String id, String species, String sex, String size, String neighborhood, long microchip, boolean potentDangerous) {
        this.id = id;
        this.species = species;
        this.sex = sex;
        this.size = size;
        this.neighborhood = neighborhood;
        this.microchip = microchip;
        this.potentDangerous = potentDangerous;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "microchip=" + microchip +
                ", species='" + species + '\'' +
                ", sex='" + sex + '\'' +
                ", size='" + size + '\'' +
                ", neighborhood='" + neighborhood + '\'' +
                ", potentDangerous=" + potentDangerous +
                ", id='" + id + '\'' +
                '}';
    }

   /** @return the id
     */
    public String getId() {
        return id;
    }

    /** @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /** @return the microchip
     */
    public long getMicrochip() {
        return microchip;
    }

    /** @param microchip the microChip to set
     */
    public void setMicrochip(long microchip) {
        this.microchip = microchip;
    }

    /** @return the species
     */
    public String getSpecies() {
        return species;
    }

    /** @param species the species to set
     */
    public void setSpecies(String species) {
        this.species = species;
    }

    /** @return the sex
     */
    public String getSex() {
        return sex;
    }

    /** @param sex the sex to set
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

    /** @return the size
     */
    public String getSize() {
        return size;
    }

    /** @param size the size to set
     */
    public void setSize(String size) {
        this.size = size;
    }

    /** @return the potentDangerous
     */
    public boolean isPotentDangerous() {
        return potentDangerous;
    }

    /** @param potentDangerous the potentDangerous to set
     */
    public void setPotentDangerous(boolean potentDangerous) {
        this.potentDangerous = potentDangerous;
    }

    /** @return the neighborhood
     */
    public String getNeighborhood() {
        return neighborhood;
    }

    /** @param neighborhood the neighborhood to set
     */
    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

}
