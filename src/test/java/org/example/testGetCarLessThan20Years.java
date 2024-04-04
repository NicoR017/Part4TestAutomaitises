package org.example;

import org.example.Car;
import org.example.CarRepositoryImpl;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class testGetCarLessThan20Years {
    @Test
    public void testGetCarLessThan20Years() {

        Car car1 = Mockito.mock(Car.class);
        Car car2 = Mockito.mock(Car.class);
        Car car3 = Mockito.mock(Car.class);


        java.util.Date date = new Date(2015, 1, 1);
        Mockito.when(car1.getDate_of_first_registration()).thenReturn(date);
        date = new Date(1980, 1, 1);
        Mockito.when(car2.getDate_of_first_registration()).thenReturn(date);
        date = new Date(2021, 1, 1);
        Mockito.when(car3.getDate_of_first_registration()).thenReturn(date);
        List<Car> cars = Arrays.asList(car1, car2, car3);

        CarRepositoryImpl carRepo = new CarRepositoryImpl();

        List<Car> result = carRepo.getCarLessThan20Years(cars);

        assertEquals(2, result.size());
        assertEquals(car1, result.get(0));
        assertEquals(car3, result.get(1));
    }
}
