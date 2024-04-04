package org.example;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        System.out.println("Hello world!");
        System.out.println("1. Récupération et affichage de tout les vehicules du fichier de données");
        List<Car> cars= File.Read();
        Car.printAllCar(cars);
        String log="Car.printAllCar("+cars+")";
        Log.Save(log);
        System.out.println(" ");
        System.out.println("-------------------------------------------------------------------------");
        System.out.println(" ");
        System.out.println("2. Filtrer et afficher les véhicules de moins de 20 ans");
        CarRepositoryImpl carRepo = new CarRepositoryImpl();
        cars = carRepo.getCarLessThan20Years(cars);
        log="carRepo.getCarLessThan20Years("+cars+")";
        Log.Save(log);
        Car.printAllCar(cars);
//        System.out.println(" ");
//        System.out.println("-------------------------------------------------------------------------");
//        System.out.println(" ");
//        System.out.println("3. Enregistrement des véhicules de moins de 20 ans");
//
//        for (Car car : cars) {
//            try {
//                log="carRepo.addCar("+car+")";
//                Log.Save(log);
//                if (carRepo.addCar(car)) {
//                    System.out.println("Voiture enregistrée avec succès");
//                    log="Voiture enregistrée avec succès "+car;
//                    Log.Save(log);
//                } else {
//                    System.out.println("Insertion failed !");
//                    log="Insertion failed ! "+car;
//                    Log.Save(log);
//                }
//            } catch (ClassNotFoundException | SQLException e) {
//                e.printStackTrace();
//            }
//        }

        int action=0;
        while (action != 7) {
            Menu.MenuBase();
            action = Menu.ActionVerif(0);

            if(action==1){ //creation

                Car car =Menu.CreateCar();
                if (carRepo.addCar(car)) {
                    System.out.println("Voiture enregistrée avec succès");
                    log="Voiture enregistrée avec succès "+car;
                    Log.Save(log);
                } else {
                    System.out.println("Insertion failed !");
                    log="Insertion failed ! "+car;
                    Log.Save(log);
                }
                log="Menu.CreateCar()";
                Log.Save(log);
            }else if (action==2) { //modification
                Car car = Menu.CreateCar();
                carRepo.updateCar(car);
                log = "Menu.updateCar()";
                Log.Save(log);
            }else if (action==3) { //Afficher
                cars= carRepo.getAllCars();
                Car.printAllCar(cars);
                log = "carRepo.getAllCars()";
                Log.Save(log);
            }else if (action==4) { //Supprimer

                cars= carRepo.getAllCars();
                Car.printAllCar(cars);
                log = "carRepo.getAllCars()";
                Log.Save(log);
                String register_number;
                Scanner scanner = new Scanner(System.in);
                System.out.println("Registration number:");
                register_number = scanner.nextLine();

                carRepo.deleteCar(register_number);


            }else if (action==5) { //afficher vehicule age

                cars= carRepo.getAllCars();
                Car.printAllCar(cars);
                log = "carRepo.getAllCars()";
                Log.Save(log);
                boolean continuer=true;
                int age=0;
                while (continuer == true) {
                    Scanner scanner = new Scanner(System.in);
                    System.out.println("Entrer un age: ");
                    try {
                        age = Integer.parseInt(scanner.nextLine());
                        continuer = false;

                    } catch (NumberFormatException e) {
                        System.out.println("Rentrer un nombre et non une chaine " + e.getMessage());
                        continuer = true;
                    }
                }
                cars= carRepo.getCarWithAge(cars,age);
                Car.printAllCar(cars);
                log = "carRepo.getCarWithAge("+cars+" , " + age+")";
                Log.Save(log);
            }else if (action==6) { //afficher vehicule age

                cars= carRepo.getAllCars();
                Car.printAllCar(cars);
                log = "carRepo.getAllCars()";
                Log.Save(log);
                boolean continuer=true;
                int price1=0;
                int price2=0;
                while (continuer == true) {
                    Scanner scanner = new Scanner(System.in);
                    System.out.println("Entrer un prix min: ");
                    try {
                        price1 = Integer.parseInt(scanner.nextLine());
                        continuer = false;

                    } catch (NumberFormatException e) {
                        System.out.println("Rentrer un nombre et non une chaine " + e.getMessage());
                        continuer = true;
                    }
                }
                continuer=true;
                while (continuer == true) {
                    Scanner scanner = new Scanner(System.in);
                    System.out.println("Entrer un prix max: ");
                    try {
                        price2 = Integer.parseInt(scanner.nextLine());
                        continuer = false;

                    } catch (NumberFormatException e) {
                        System.out.println("Rentrer un nombre et non une chaine " + e.getMessage());
                        continuer = true;
                    }
                }

                cars=carRepo.getCarsBetweenPrice(cars,price1,price2);
                Car.printAllCar(cars);
                log = "carRepo.getCarWithAge("+cars+" , " + price1+ " , "+ price2+ ")";
                Log.Save(log);
            }


        }



    }
}