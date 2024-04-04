package org.example;

import java.util.Date;
import java.util.List;

public class Car {

    private String register_number;
    private String brand;
    private String model;
    private Date date_of_first_registration;
    private int price;

    public Car(String registerNumber, String brand, String model, Date dateOfFirstRegistration, int price) {
        register_number = registerNumber;
        this.brand = brand;
        this.model = model;
        date_of_first_registration = dateOfFirstRegistration;
        this.price = price;
    }

    public String getRegister_number() {
        return register_number;
    }

    public void setRegister_number(String register_number) {
        this.register_number = register_number;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Date getDate_of_first_registration() {
        return date_of_first_registration;
    }

    public void setDate_of_first_registration(Date date_of_first_registration) {
        this.date_of_first_registration = date_of_first_registration;
    }

    public static void printAllCar(List<Car> cars){
        for (Car car : cars) {
            System.out.println(car.getRegister_number() + ", " + car.getBrand() + ", " + car.getModel() + ", " + car.getDate_of_first_registration());
        }
    }


    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
