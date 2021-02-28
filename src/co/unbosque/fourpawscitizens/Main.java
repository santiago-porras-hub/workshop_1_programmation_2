/**
 * Contains the class
 */
package co.unbosque.fourpawscitizens;

import co.unbosque.fourpawscitizens.model.Manager;

import java.util.Scanner;

/**
 * This class run the program
 * @author Santiago Porras and Omar Felipe Ladino
 */

public class Main {

    public static void main(String[] args) {

        /**
         * man is type Manager
         */
        Manager man = new Manager();
        /**
         * in is type Scanner
         */
        Scanner in = new Scanner(System.in);
        /**
         * n is type Integer
         */
        int n = 0;
        /**
         * topLast is type  String
         */
        String topLast = "";
        /**
         * neighborhood is type  String
         */
        String neighborhood = "";
        /**
         * sex is type  String
         */
        String sex = "";
        /**
         * specie is type String
         */
        String specie = "";
        /**
         * size is type String
         */
        String size = "";
        /**
         * pot is type String
         */
        String pot = "";
        /**
         * option is type Integer
         */
        int option = 0;
        /**
         * option 2 is type Integer
         */
        int option2 = 0;
        System.out.println("Welcome, please choose a option: ");
        do {
            System.out.println(
                    "\1.) Assign ID.\n2.)Find a pet by microchip.\n3.) Count by species.\n4.) Find by potential dangerous in the neighborhood.\n5.) Find by multiple fields.\n6.) Exit ");
            option = in.nextInt();
            switch (option) {
                case 1:
                    man.assignID();
                    System.out.println("ID´s assgned :D");

                    break;
                case 2:
                    System.out.println("Write a valid ID (Only numbers)");
                    System.out.println(man.findByMicrochip(in.nextLong()));
                    break;
                case 3:
                    System.out.println("Wtrite the specie that you want to search:");
//				System.out.println(man.countBySpecies(in.hasNextLine()));
                    break;
                case 4:
                    System.out.println("How many animals do you want?");
                    n = in.nextInt();
                    System.out.println("TOP or LAST?:");
                    topLast = in.nextLine();
                    System.out.println("Write a neighborhood: ");
                    neighborhood = in.nextLine();
//				System.out.println(man.findBypotentDangerousInNeighborhood(n,m,o));
                    break;
                case 5:
                    System.out.println("Sex?: ");
                    sex = in.nextLine();
                    System.out.println("Specie?: ");
                    specie = in.nextLine();
                    System.out.println("Size?: ");
                    size = in.nextLine();
                    System.out.println("Is a potential dangerous?");
                    pot = in.nextLine();
                    System.out.println(man.findByMultipleFields(specie, sex, size, pot));
                    break;
                case 6:
                    System.out.println("Goodbye :D");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Error, choose a valid optipn :(");
                    break;
            }
            do {
                System.out.println("1.) Continue\n2.) Exit.");
                option = in.nextInt();
                switch (option) {
                    case 1:
                        break;
                    case 2:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Error, choose a valid option :(");
                        break;
                }
            } while (option != 1);
        } while (option != 0);

    }


    }


