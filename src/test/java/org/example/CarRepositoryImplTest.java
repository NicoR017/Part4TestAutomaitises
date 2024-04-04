package org.example;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Date;

import static jdk.internal.org.objectweb.asm.util.CheckClassAdapter.verify;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

class CarRepositoryImplTest {

    @Test
    void addCar() {
        Car car = new Car("1234ABCD", "Toyota", "Corolla", new Date(2015, 1, 1), 20000);
        CarDBConfig carDBConfigMock = Mockito.mock(CarDBConfig.class);
        Connection connectionMock = Mockito.mock(Connection.class);
        PreparedStatement preparedStatementMock = Mockito.mock(PreparedStatement.class);

        when(carDBConfigMock.getConnection()).thenReturn(connectionMock);
        when(connectionMock.prepareStatement(anyString())).thenReturn(preparedStatementMock);
        when(preparedStatementMock.executeUpdate()).thenReturn(1);

        CarRepositoryImpl carRepository = new CarRepositoryImpl(carDBConfigMock);
        boolean isAdded = carRepository.addCar(car);

        assertTrue(isAdded);
        verify(preparedStatementMock, times(1)).setString(1, car.getRegister_number());
        verify(preparedStatementMock, times(1)).setString(2, car.getBrand());
        verify(preparedStatementMock, times(1)).setString(3, car.getModel());
        verify(preparedStatementMock, times(1)).setDate(4, new java.sql.Date(car.getDate_of_first_registration().getTime()));
        verify(preparedStatementMock, times(1)).setInt(5, car.getPrice());
    }

    @Test
    void deleteCar() {
    }

    @Test
    void updateCar() {
    }

    @Test
    void getAllCars() {
    }

    @Test
    void getCarLessThan20Years() {
    }

    @Test
    void getCarWithAge() {
    }

    @Test
    void getCarsBetweenPrice() {
    }
}