package org.example;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Menu {

    public static void MenuBase(){
        System.out.println("Bienvenue");
        System.out.println("Dans votre gestionnnaire de véhicules");
        System.out.println("|-------------------------------------------------------|");
        System.out.println("|  0. Quitter                                           |");
        System.out.println("|  1. Ajouter tout les véhicules                       |");
        System.out.println("|  2. Modifier un véhicule                              |");
        System.out.println("|  3. Afficher un véhicule                               |");
        System.out.println("|  4. Supprimer un véhicule                             |");
        System.out.println("|  5. Afficher les véhicule d’un âge donné              |");
        System.out.println("|  6. Afficher les véhicules entre deux prix            |");
        System.out.println("|-------------------------------------------------------|");
    }
    public static Car CreateCar(){
        String register_number;
        String brand;
        String model;
        Date date_of_first_registration = null;
        int price = 0;

        System.out.println("|-------------------------------|");
        System.out.println("|Création d'une nouvelle voiture|");
        System.out.println("|-------------------------------|");
        System.out.println(" ");
        System.out.println(" ");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Registration number:");
        register_number = scanner.nextLine();
        System.out.println("Brand :");
        brand = scanner.nextLine();
        System.out.println("Model :");
        model = scanner.nextLine();

        boolean continuer = true;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        while (continuer) {
            System.out.println("Date of first registration:");
            String dateInput = scanner.nextLine();
            try {
                date_of_first_registration = formatter.parse(dateInput);
                continuer = false;
            } catch (ParseException e) {
                System.out.println("Format de date incorrect. Utilisez le format yyyy-MM-dd.");
            }
        }


        continuer = true;
        while (continuer == true) {
            System.out.println("Price :");
            try {
                price = Integer.parseInt(scanner.nextLine());
                continuer = false;

            } catch (NumberFormatException e) {
                System.out.println("Rentrer un nombre et non une chaine " + e.getMessage());
                continuer = true;
            }
        }


       return new Car(register_number,brand,model,date_of_first_registration,price);

    }

    public static int ActionVerif(Integer action) {

        boolean continuer = true;
        while (continuer == true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Entrer une option: ");
            try {
                action = Integer.parseInt(scanner.nextLine());
                continuer = false;

            } catch (NumberFormatException e) {
                System.out.println("Rentrer un nombre et non une chaine " + e.getMessage());
                continuer = true;
            }
        }
        return action;

    }
}
