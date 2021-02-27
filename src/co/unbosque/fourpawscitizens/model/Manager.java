package co.unbosque.fourpawscitizens.model;

import co.unbosque.fourpawscitizens.model.daos.Pet;

import java.io.*;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Manager {

    File file = new File("C:\\Users\\santi\\workshop_1_programmation_2\\src\\co\\unbosque\\fourpawscitizens\\model\\daos\\pets-citizens.csv");

    ArrayList<Pet> pets = new ArrayList<Pet>();

    ArrayList<String> list = new ArrayList<String>();

    public Manager() {

        this.readFile();
        this.readCsv();

//		this.assingID2();
//		this.assign3();
        this.assignID();
        long numero = 978101081928801l;
        System.out.println(this.findByMicrochip(numero));
        System.out.println(findByMultipleFields("CANINO", "HEMBRA", "MINIATURA", "NO"));

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

    //	public void assignID() {
//
//		for (int i = 0; i < pets.size(); i++) {
//			for (int j = 0; j < pets.size(); j++) {
//				if (pets.get(i).getId().equals(pets.get(j).getId()) && i != j) {
//					System.out.println(
//							pets.get(i).getMicrochip() + "     asddddddddd         " + pets.get(j).getMicrochip());
//				}
//
//			}
//			System.out.println(pets.get(i).getId());
//		}
//
//	}

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
            System.out.println(pets.get(i).getSize());
        }

    }

    /**
     *  This method find an id by the paramater Microchip.
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
     * <b>pre</b> The field scv must be upload and update <br>
     * <b>post</b> The species has been counted.
     * This method will count the variable species.
     */
    public void countBySpecies() {

        int a = 0;
        int c = 0;

        for (int i = 0; i < pets.size(); i++) {

            String b = pets.get(i).getSpecies();

            if (b.equals("FELINO")) {

                a++;
            } else if (b.equals("CANINO")) {

                c++;

            }

        }
        System.out.println("El numero de animales por FELINO ES:" + a);
        System.out.println("El numero de animales por MACHO ES: " + c);
    }

    /**
     * This method will find an Id by using multiple fields
     * <b>pre</b> The field scv must be upload and update <br>
     * <b>post</b> The Id has been found.
     * @param species a variable of the object pet
     * @param sex a variable of the object pet
     * @param size a variable of the object pet
     * @param potentDangerous a variable of the object pet
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