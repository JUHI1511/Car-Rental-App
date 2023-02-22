package com.cars.service;

import com.cars.bean.Booking;
import com.cars.bean.Car;
import com.cars.dao.BookingDao;
import com.cars.dao.CarDao;
import com.cars.exception.CarsNotAvailable;
import com.cars.exception.InvalidDateTime;
import com.cars.exception.RecordAlreadyExists;
import com.cars.exception.RecordNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class BookingServiceImpl implements BookingService{
    @Autowired
    BookingDao bookingDao;
  @Autowired
  CarDao carDao;
    @Override
    public Booking addBooking(Booking booking) throws RecordAlreadyExists, InvalidDateTime, CarsNotAvailable {
        if (bookingDao.existsById(booking.getBookingId())){
            throw new RecordAlreadyExists("Booking with this Booking Id  already exists");
        }
        this.validateBookingDate(booking);
        this.validateCarsAvailable(booking);
        bookingDao.save(booking);
        return booking;
    }

    @Override
    public Booking viewBooking(Integer bookingId) throws RecordNotFound {
        if(bookingDao.findById(bookingId).isEmpty())
              throw new RecordNotFound("Booking does not exist with this id");
        Optional id=bookingDao.findById(bookingId);
        Booking booking= (Booking) id.get();
        return booking;

    }

    @Override
    public List<Booking> viewBookings() {
        List<Booking>bookingList=bookingDao.findAll();
        return  bookingList;
    }

    @Override
    public Booking updateBooking(Booking booking) throws InvalidDateTime,RecordNotFound{
        int id=booking.getBookingId();
        if(bookingDao.findById(id).isEmpty())
            throw new RecordNotFound("Booking does not exist with this id");
        Booking booking1=bookingDao.findById(id).get();
        booking1.setCustomer(booking.getCustomer());
        booking1.setFuelType(booking.getFuelType());
        booking1.setSeaterType(booking.getSeaterType());
        booking1.setBookingDate(booking.getBookingDate());
        booking1.setPrice(booking.getPrice());
        this.validateBookingDate(booking);
        booking1.setFromDate(booking.getFromDate());
        booking1.setToDate(booking.getToDate());
        booking1.setStatus(booking.getStatus());
        booking1.setCar(booking.getCar());
        bookingDao.save(booking1);
        return booking1;


    }

    @Override
    public String deleteBooking(Integer bookingId) throws RecordNotFound {
        if(bookingDao.findById(bookingId).isEmpty())
            throw new RecordNotFound("Booking does not exist with this id");
        if(bookingDao.findById(bookingId).isPresent())
            bookingDao.deleteById(bookingId);
        return "Booking Deleted Successfully";
    }
    @Override
    public void validateBookingDate(Booking booking) throws InvalidDateTime{
        if(booking.getFromDate().isBefore(LocalDateTime.now()))
          throw new InvalidDateTime(" date & time has elapsed");


        if (booking.getToDate().isBefore(LocalDateTime.now())) {
            throw new InvalidDateTime("date & time has elapsed");
        }

    }
    @Override
    public void validateCarsAvailable(Booking booking) throws CarsNotAvailable {
        Car car=booking.getCar();
        if (carDao.existsByCarNumber(car.getCarNumber())){
            throw new CarsNotAvailable("Booking with this car number  is not available");
        }


    }

}
