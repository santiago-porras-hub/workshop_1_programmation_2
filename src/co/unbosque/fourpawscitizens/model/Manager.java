package co.unbosque.fourpawscitizens.model;

import co.unbosque.fourpawscitizens.model.daos.Pet;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Manager {

    Pet pet= new Pet();
    ArrayList <Pet> pets = new ArrayList<Pet>();

    public static final String SEPARATE = ",";

    public static void main(String[] args) {

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

   public void assignID( ){



    }
}
