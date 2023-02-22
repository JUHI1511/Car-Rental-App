package com.cars.dao;

import com.cars.bean.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarDao extends JpaRepository<Car,Integer> {

    boolean existsByCarNumber(int carNumber);
}
