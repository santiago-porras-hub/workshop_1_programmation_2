/**
 * This package contains the class
 */
package co.unbosque.fourpawscitizens.model;

import co.unbosque.fourpawscitizens.model.dtos.Pet;

import java.io.*;
import java.util.ArrayList;

public class Manager {

    File file = new File("C:\\Users\\santi\\workshop_1_programmation_2\\src\\co\\unbosque\\fourpawscitizens\\model\\daos\\pets-citizens.csv");

    /**
     * pets is a type ArrayList of Pet
     */
    ArrayList<Pet> pets = new ArrayList<Pet>();

    /**
     * Contains the methods to initialize
     */
    public Manager() {

        this.readFile();
        this.readCsv();
        this.assignID();
        long numero = 978101081928801l;
        this.findByMicrochip(0);
        this.countBySpecies(null);
        this.findBypotentDangerousInNeighborhood(0,null,null);
        this.findByMultipleFields(null,null,null,null);


    }

    public static final String SEPARATE = ",";

    /**
     * This method upload the file scv separate by ";" ;
     */
    public void readCsv() {

        BufferedReader bufferLecture = null;
        try {
            // Abrir el .csv en buffer de lectura
            bufferLecture = new BufferedReader(new FileReader("C:\\Users\\santi\\workshop_1_programmation_2\\src\\co\\unbosque\\fourpawscitizens\\model\\daos\\pets-citizens.csv"));

            // Leer una linea del archivo
            String line = bufferLecture.readLine();

            while (line != null) {
                // Sepapar la linea leída con el separador definido previamente
                String[] field = line.split(SEPARATE);

                // Volver a leer otra línea del fichero
                line = bufferLecture.readLine();
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        } finally {
            // Cierro el buffer de lectura
            if (bufferLecture != null) {
                try {
                    bufferLecture.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * <b>pre</b> The field scv must be upload <br>
     * This method read the file and save the information in ArrayList using an String [] array in the "while".
     */
    public void readFile() {
        BufferedReader bReader = null;
        try {
            bReader = new BufferedReader(new FileReader("C:\\Users\\santi\\workshop_1_programmation_2\\src\\co\\unbosque\\fourpawscitizens\\model\\daos\\pets-citizens.csv"));
            String line = bReader.readLine();

            while (line != null) {
                Pet pet = new Pet();
                try {
                    String[] field = line.split(";");
                    if (field.length == 6) {

                        pet.setId("NO-ID");

                        pet.setMicrochip(Long.parseLong(field[0]));
                        pet.setSpecies(field[1]);
                        pet.setSex(field[2]);
                        pet.setSize(field[3]);
                        if (field[4].equals("NO")) {
                            field[4] = "false";
                        } else if (field[4].equals("SI")) {
                            field[4] = "true";
                        }
                        pet.setPotentDangerous(Boolean.parseBoolean(field[4]));
                        pet.setNeighborhood(field[5]);

                        pets.add(pet);
                    }

                } catch (NumberFormatException e) {

                }
                line = bReader.readLine();
            }

        } catch (IOException e) {

        } finally {
            if (bReader != null) {
                try {
                    bReader.close();
                } catch (IOException e) {

                }
            }
        }

    }

    /**
     * <b>pre</b> The field scv must be upload and update <br>
     * <b>post</b> The id has been created. <br>
     * This method will assign an ID to the microchip while the microchip exist.
     */
    public void assignID() {
        String potential = "";
        String micro = "";
        String sp = "";
        String sex = "";
        String size = "";
        String nei = "";
        String id = "";
        String aux = "";
        String microchip = "";
        int tam = 0;
        int tamMicro = 0;
        for (int i = 0; i < pets.size(); i++) {
            sp = this.pets.get(i).getSpecies().substring(0, 1);
            sex = this.pets.get(i).getSex().substring(0, 1);
            if (this.pets.get(i).getSize().substring(0, 2).equals("MI")) {
                size = this.pets.get(i).getSize().substring(0, 2);
            } else {
                size = this.pets.get(i).getSize().substring(0, 1);
            }
            nei = this.pets.get(i).getNeighborhood();
            if (this.pets.get(i).isPotentDangerous() == false) {
                potential = "T";
            } else if (this.pets.get(i).isPotentDangerous() == true) {
                potential = "F";
            }
            micro = "" + this.pets.get(i).getMicrochip();
            aux = micro.substring(micro.length() - 3, micro.length());
            id = aux + "-" + sp + sex + size + potential + "-" + nei;
            for (int j = 0; j < pets.size(); j++) {
                microchip = "" + pets.get(i).getMicrochip();
                tam = aux.length();
                tamMicro = microchip.length();
                if (pets.get(j).getId().equals(id) && tamMicro != tam) {
                    aux = micro.substring(micro.length() - (tam + 1), micro.length());
                    id = aux + "-" + sp + sex + size + potential + "-" + nei;
                }
            }
            this.pets.get(i).setId(id);


           //System.out.println(pets.get(i).getSize());
        }
    }

    /**
     * This method find an id by the paramater Microchip.
     * <b>pre</b> The field scv must be upload and update <br>
     * <b>post</b> The Id has been found. <br>
     * @param microchip the first field for the csv file. microchip!=null
     * @return Id
     */
    public String findByMicrochip(long microchip) {
        String res = "";
        for (int i = 0; i < pets.size(); i++) {
            if (microchip == pets.get(i).getMicrochip()) {
                res = "ID: " + pets.get(i).getId() + "\nSpecies: " + pets.get(i).getSpecies() + "\n"
                        + pets.get(i).getSex() + "\nSize: " + pets.get(i).getSize() + "\nPotentially Dangerous: "
                        + pets.get(i).isPotentDangerous() + "\nNeighborhood: " + pets.get(i).getNeighborhood();
            }
        }
        return res;
    }

    /**
     * This method will count the variable species.
     * <b>pre</b> The field scv must be upload and update <br>
     * <b>post</b> The species has been counted.
     * @param species variable of pet
     * @return the num of each specie
     */
    public String countBySpecies(String species) {

        int S = 0;

        String res = "";

        for (int i = 0; i < pets.size(); i++) {
            if (pets.get(i).getSpecies().equals(species)) {

                S++;

                res = " El numero de animales de " + species + "es:" + S;
            }
        }
        return res;
    }

    /**
     * <b>pre</b> The id might be exist. <br>
     * <b>post</b> The id has been found
     * @param n a variable of the object pet. n!=0
     * @param position a variable of the object pet. position!=null
     * @param neighborhood a variable of the object pet. neighborhood!=null
     * @return the id
     */

    public String findBypotentDangerousInNeighborhood(int n, String position, String neighborhood) {

        String id = "";
        String res = "";
        ArrayList<Pet> arrDangerous = new ArrayList<Pet>();

        for (int i = 0; i < pets.size(); i++) {

            if (pets.get(i).getNeighborhood().equals(neighborhood) && this.pets.get(i).isPotentDangerous() == true) {

                arrDangerous.add(pets.get(i));
            }
        }

        if (n <= arrDangerous.size()) {
            if ("TOP".equals(position)) {
                for (int i = 0; i < n; i++) {
                    id = "" + arrDangerous.get(i).toString() + "\n";
                }
            } else if("LAST".equals(position)) {
                for (int i = arrDangerous.size() - 1; (arrDangerous.size() - n) <= i; i--) {
                    id = id + arrDangerous.get(i).toString() + "\n";
                }
            }

        } else {
            id = "No compatible";
        }
        return id;
    }

    /**
     * This method will find an Id by using multiple fields
     * <b>pre</b> The field scv must be upload and update <br>
     * <b>post</b> The Id has been found.
     * @param species         a variable of the object pet. species!=null
     * @param sex             a variable of the object pet. sex!=null
     * @param size            a variable of the object pet. size!=null
     * @param potentDangerous a variable of the object pet. potentDangerous!=null
     * @return Id
     */

    public String findByMultipleFields(String species, String sex, String size, String potentDangerous) {
        boolean pot = true;
        String res = "";
        switch (potentDangerous) {
            case "SI":
                pot = true;
                break;
            case "NO":
                pot = false;
                break;
            default:
                break;
        }
        for (int i = 0; i < pets.size(); i++) {
            if (pets.get(i).getSex().equals(sex) && pets.get(i).getSpecies().equals(species)
                    && pets.get(i).isPotentDangerous() == pot && pets.get(i).getSize().equals(size)) {
                res += pets.get(i).getId() + "\n";
            }
        }
        return res;
    }


}