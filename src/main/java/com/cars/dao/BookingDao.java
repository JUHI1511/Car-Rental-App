package com.cars.dao;

import com.cars.bean.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingDao extends JpaRepository<Booking,Integer> {

    //boolean existsByCarNumber(int carNumber);
}
