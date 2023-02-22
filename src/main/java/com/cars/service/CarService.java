package com.cars.service;

import com.cars.bean.Car;
import com.cars.bean.User;
import com.cars.exception.RecordAlreadyExists;
import com.cars.exception.RecordNotFound;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CarService {
    Car addCar(Car car) throws RecordAlreadyExists;

    Car viewCar(Integer carNumber) throws RecordNotFound;

    List<Car> viewCars();

    Car updateCar(Car car) throws RecordNotFound;

    String deleteCar(Integer carNumber) throws RecordNotFound;
}
