package org.example;

import java.sql.SQLException;
import java.util.List;

public interface CarRepository {

    boolean addCar(Car car) throws ClassNotFoundException, SQLException;

    void deleteCar(String id) throws SQLException, ClassNotFoundException;

    void updateCar(Car car) throws SQLException, ClassNotFoundException;

    List<Car> getAllCars() throws ClassNotFoundException, SQLException;

    List<Car> getCarLessThan20Years(List<Car> cars);

    List<Car> getCarWithAge(List<Car> cars, Integer age);

    List<Car> getCarsBetweenPrice(List<Car> cars, Integer price1,Integer price2);

}
