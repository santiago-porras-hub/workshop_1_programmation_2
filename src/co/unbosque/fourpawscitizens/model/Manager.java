package co.unbosque.fourpawscitizens.model;

import co.unbosque.fourpawscitizens.model.daos.Pet;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Manager {

    File file= new File("C:\\Users\\santi\\workshop_1_programmation_2\\src\\co\\unbosque\\fourpawscitizens\\model\\daos\\pets-citizens.csv");

    Pet pet= new Pet();

    ArrayList <Pet> pets = new ArrayList<Pet>();

    ArrayList <String> list= new ArrayList<String>();



    public Manager(){

        pets= readFile(file);
        this.readFile(file);
        this.readCsv();
    }

    public void update (){



        for (int i = 0; i < pets.size(); i++) {

            System.out.println(pets.get(i).getSex());

        }

    }
    public ArrayList<Pet> readFile(File file)  {

        try {
            if (file.exists()) {
                BufferedReader bReader = new BufferedReader(new FileReader(file));
                ArrayList<Pet> listOfPets = new ArrayList<Pet>();
                Scanner scanner;
                scanner = new Scanner(file);

                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    Scanner separate = new Scanner(line);
                    separate = new Scanner(line);
                    separate.useDelimiter("\\s*,\\s*");
                    Pet pet= new Pet();

                    pet.setMicrochip(separate.nextLong());
                    pet.setSpecies(separate.next());
                    pet.setSex(separate.next());
                    pet.setSize(separate.next());
                    pet.setPotentDangerous(separate.nextBoolean());

                    listOfPets.add(pet);
                }

                bReader.close();
                return listOfPets;

            } else {
                return null;

            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return null;

        }

    }

    /**
     * 
     */
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

                System.out.println(Arrays.toString(field));

                // Volver a leer otra línea del fichero
                line = bufferLecture.readLine();
            }
        }
        catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
        finally {
            // Cierro el buffer de lectura
            if (bufferLecture != null) {
                try {
                    bufferLecture.close();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


}
