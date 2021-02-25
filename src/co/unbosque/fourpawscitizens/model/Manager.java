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
        this.assignID();
    }

    public static final String SEPARATE = ",";

    /**
     * This method upload the file scv separate by ;
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
     * This method read the file and save the information in ArrayList using an String [] array in the while
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

    public String assignID() {

        String g = null;
        String d = null;
        String e = null;
        String aux = "";
        for (int i = 0; i < pets.size(); i++) {

            String a = "" + this.pets.get(i).getMicrochip();

            aux = a.substring(a.length() - 3, a.length());

            String b = this.pets.get(i).getSpecies().substring(0);

            String c = this.pets.get(i).getSex().substring(0);

            String q = this.pets.get(i).getSize().substring(0);

            if (this.pets.get(i).isPotentDangerous() == false) {
                e = "T";

            } else if (this.pets.get(i).isPotentDangerous() == true) {
                e = "F";

            }
            String f = this.pets.get(i).getNeighborhood().substring(0);

            g = this.pets.get(i).getId();
            System.out.println("The Id is : " + aux + "-" + b + "-" + c + "-" + q + "-" + e +  "-" + q + "-" + f);
        }
        return g;

    }

}
