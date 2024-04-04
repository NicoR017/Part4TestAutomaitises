package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class CarRepositoryImpl implements CarRepository {

    @Override
    public boolean addCar(Car car) throws ClassNotFoundException, SQLException {
        CarDBConfig studentDBConfig = new CarDBConfig();
        Connection connection = studentDBConfig.getConnection();
        String insertionQuery = "INSERT INTO car (registration_number, brand, model,date_of_first_registration,price) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(insertionQuery);
        preparedStatement.setString(1, car.getRegister_number());
        preparedStatement.setString(2, car.getBrand());
        preparedStatement.setString(3, car.getModel());
        java.util.Date utilDate = car.getDate_of_first_registration();
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        preparedStatement.setDate(4, sqlDate);
        preparedStatement.setInt(5, car.getPrice());
        int rowsAffected = preparedStatement.executeUpdate();
        return rowsAffected > 0;
    }

    @Override
    public void deleteCar(String id) throws SQLException, ClassNotFoundException {
        CarDBConfig studentDBConfig = new CarDBConfig();
        Connection connection = studentDBConfig.getConnection();
        String insertionQuery = "DELETE FROM car WHERE registration_number = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(insertionQuery);
        preparedStatement.setString(1, id);

        int rowsAffected = preparedStatement.executeUpdate();
        if (rowsAffected > 0) {
            System.out.println("La voiture a été supprimé avec succès.");
        } else {
            System.out.println("Aucune voiture trouvé avec cet ID.");

        }
        preparedStatement.close();
        connection.close();


    }

    @Override
    public void updateCar(Car car) throws SQLException, ClassNotFoundException{
        CarDBConfig studentDBConfig = new CarDBConfig();
        Connection connection = studentDBConfig.getConnection();

        String insertionQuery = "UPDATE car SET brand = ?, model = ?, date_of_first_registration=?, price=? WHERE registration_number = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(insertionQuery);

        preparedStatement.setString(1, car.getBrand());
        preparedStatement.setString(2, car.getModel());
        java.util.Date utilDate = car.getDate_of_first_registration();
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        preparedStatement.setDate(3, sqlDate);
        preparedStatement.setInt(4, car.getPrice());
        preparedStatement.setString(5, car.getRegister_number());
        int rowsAffected = preparedStatement.executeUpdate();
        if (rowsAffected > 0) {
            System.out.println("La voiture a été modifier avec succès.");
        } else {
            System.out.println("Aucune voiture trouvé avec cet ID.");

        }
        preparedStatement.close();
        connection.close();
    }

    @Override
    public List<Car> getAllCars() throws ClassNotFoundException, SQLException {

        List<Car> cars = new ArrayList<>();
        CarDBConfig studentDBConfig = new CarDBConfig();
        Connection connection = studentDBConfig.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * from car");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            String register_number =resultSet.getString("registration_number");
            String brand=resultSet.getString("brand");
            String model=resultSet.getString("model");
            Date date_of_first_registration=resultSet.getDate("date_of_first_registration");
            int price=resultSet.getInt("price");

            cars.add(new Car(register_number, brand, model,date_of_first_registration,price));
        }
        resultSet.close();
        preparedStatement.close();
        connection.close();
        return cars;
    }

    @Override
    public  List<Car> getCarLessThan20Years(List<Car> cars) {
        LocalDate dateDuJour = LocalDate.now();
        Iterator<Car> iterator = cars.iterator();
        while (iterator.hasNext()) {
            Car car = iterator.next();
            if (dateDuJour.getYear() - (car.getDate_of_first_registration().getYear()+1900) >= 20) {
                System.out.println(car.getDate_of_first_registration().getYear()+1900);
                iterator.remove();
            }
        }
        return cars;
    }

    @Override
    public List<Car> getCarWithAge(List<Car> cars, Integer age) {
        LocalDate dateDuJour = LocalDate.now();
        Iterator<Car> iterator = cars.iterator();
        while (iterator.hasNext()) {
            Car car = iterator.next();
            if (dateDuJour.getYear() - (car.getDate_of_first_registration().getYear()+1900) != age) {
               iterator.remove();
            }
        }
        return cars;
    }

    @Override
    public List<Car> getCarsBetweenPrice(List<Car> cars, Integer price1, Integer price2) {
        Iterator<Car> iterator = cars.iterator();
        while (iterator.hasNext()) {
            Car car = iterator.next();
            if  (!(price1<= car.getPrice() && car.getPrice() <=price2) ){
                iterator.remove();
            }
        }
        return cars;
    }


}
