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
        System.out.println(pets.size());
        for (int i = 0; i < pets.size(); i++) {
            System.out.println(pets.get(i).isPotentDangerous());
        }
    }

    public void update() {


        for (int i = 0; i < pets.size(); i++) {

            System.out.println(pets.get(i).getSex());

        }

    }

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

            } catch(IOException e){

            } finally{
                if (bReader != null) {
                    try {
                        bReader.close();
                    } catch (IOException e) {

                    }
                }
            }

        }



    public static final String SEPARATE = ",";

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
}
