package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


public class File {

    public static List<Car> Read() {
        String filename = "data.txt";
        BufferedReader reader = null;
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        List<Car> cars = new ArrayList<>();

        try {
            reader = new BufferedReader(new FileReader(filename));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                Date date = format.parse(parts[3]);
                Car car = new Car(parts[0], parts[1], parts[2], date,Integer.parseInt(parts[4]));
                cars.add(car);
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return cars;
    }

}
