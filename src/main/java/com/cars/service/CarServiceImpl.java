package com.cars.service;

import com.cars.bean.Car;
import com.cars.bean.Car;
import com.cars.dao.CarDao;
import com.cars.dao.CarDao;
import com.cars.exception.RecordAlreadyExists;
import com.cars.exception.RecordNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    CarDao carDao;

    @Override
    public Car addCar(Car car) throws RecordAlreadyExists {
        if (carDao.existsById(car.getCarNumber())){
            throw new RecordAlreadyExists(" Car with this car Number already exists");
        }
        carDao.save(car);
        return car;
    }

    @Override
    public Car viewCar(Integer carNumber) throws RecordNotFound{
    if(carDao.findById(carNumber).isEmpty())
        throw new RecordNotFound("Car with "+carNumber+" number does not exists");

        Car car = (Car)carDao.findById(carNumber) .get();
        return car;

    }

    @Override
    public List<Car> viewCars() {
        List<Car> carList = carDao.findAll();
        return carList;
    }

    @Override
    public Car updateCar(Car car) throws RecordNotFound {
        int number = car.getCarNumber();



        if(carDao.findById(number).isEmpty())
            throw new RecordNotFound("Car with "+number +"does not exists");
        Car car1 = carDao.findById(number).get();
        car1.setModelYear(car.getModelYear());
        car1.setVariant(car.getVariant());
        car1.setStatus(car.getStatus());
        carDao.save(car1);
        return car1;


    }

    @Override
    public String deleteCar(Integer carNumber) throws RecordNotFound {
        //convert BigInteger to integer
        if (carDao.findById(carNumber).isPresent())
            carDao.deleteById(carNumber);
        else
            throw new RecordNotFound("Car with "+carNumber +" number does not exist");
        return "Car Deleted Successfully";
    }
}