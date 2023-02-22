package com.cars.service;

import com.cars.bean.Booking;
import com.cars.exception.CarsNotAvailable;
import com.cars.exception.InvalidDateTime;
import com.cars.exception.RecordAlreadyExists;
import com.cars.exception.RecordNotFound;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookingService {
    Booking addBooking(Booking booking) throws RecordAlreadyExists, InvalidDateTime, CarsNotAvailable;

    Booking viewBooking(Integer bookingId) throws RecordNotFound;

    List<Booking> viewBookings();

    Booking updateBooking(Booking booking) throws InvalidDateTime, RecordNotFound;

    String deleteBooking(Integer bookingId) throws RecordNotFound;


    void validateBookingDate(Booking booking) throws InvalidDateTime;

    void validateCarsAvailable(Booking booking) throws CarsNotAvailable;
}
