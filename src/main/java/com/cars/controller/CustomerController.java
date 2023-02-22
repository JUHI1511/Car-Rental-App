package com.cars.controller;

import com.cars.bean.Booking;
import com.cars.bean.Car;
import com.cars.bean.Customer;
import com.cars.bean.User;
import com.cars.dto.UserDto;
import com.cars.exception.*;
import com.cars.service.BookingService;
import com.cars.service.CarService;
import com.cars.service.CustomerService;
import com.cars.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    //Customer can view cars
    //customer can crud on bookings


    @Autowired
    CarService carService;

    @GetMapping(path = "/getcar/{carNumber}")
    public  ResponseEntity<Car> viewCar(@PathVariable int carNumber) throws RecordNotFound {
        return  new ResponseEntity<>(carService.viewCar(carNumber), HttpStatus.OK);

    }

    @GetMapping(path = "/getcars")
    public ResponseEntity<List<Car>>viewCars() {

        return new ResponseEntity<>(carService.viewCars(),HttpStatus.OK);
    }

    //Bookings
    @Autowired
    BookingService bookingService;

    @PostMapping(path = "/addbooking")
    public ResponseEntity<Booking> addBooking(@RequestBody Booking booking) throws RecordAlreadyExists, InvalidDateTime, CarsNotAvailable {
        Booking newBooking=bookingService.addBooking(booking);
        return  new ResponseEntity<>(newBooking,HttpStatus.OK);
    }

    @GetMapping(path = "/getbooking/{bookingId}")
    public   ResponseEntity<Booking> viewBooking(@PathVariable int bookingId) throws RecordNotFound {
        return new ResponseEntity<>(bookingService.viewBooking(bookingId),HttpStatus.OK);

    }
//Customer should not see everyone's booking
    /*
    @GetMapping(path = "/getbookings")
    public ResponseEntity<List<Booking>> viewBookings() {

        return  new ResponseEntity<>( bookingService.viewBookings(),HttpStatus.OK);
    }

     */

    @PutMapping(path = "/updatebooking")
    public ResponseEntity<Booking>updateBooking(@RequestBody Booking booking) throws RecordNotFound, InvalidDateTime {
        return  new ResponseEntity<>(bookingService.updateBooking(booking),HttpStatus.OK);

    }

    @DeleteMapping(path = "/deletebooking/{bookingId}")
    public ResponseEntity<String>deleteBooking(@PathVariable int bookingId) throws RecordNotFound {
        bookingService.deleteBooking(bookingId);
        String message="Booking Deleted Successfully";
        return  new ResponseEntity<>(message,HttpStatus.OK);


    }

    @Autowired
    CustomerService customerService;

    @PostMapping(path="/addcustomer")
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) throws RecordAlreadyExists, InvalidEmail, InvalidPhoneNumber {
        Customer newCustomer=customerService.addCustomer(customer);
        return new ResponseEntity<>(newCustomer,HttpStatus.OK);
    }

    @GetMapping(path="/getcustomer/{customerId}")
    public ResponseEntity<Customer> viewCustomer(@PathVariable int customerId) throws RecordNotFound {
        return new ResponseEntity<>(customerService.viewCustomer(customerId),HttpStatus.OK);

    }
    @PutMapping(path="/updatecustomer")
    public ResponseEntity<Customer>updateCustomer(@RequestBody Customer customer) throws InvalidEmail, RecordNotFound, InvalidPhoneNumber {
        return new ResponseEntity<>(customerService.updateCustomer(customer),HttpStatus.OK);

    }

    @DeleteMapping(path="/deletecustomer/{customerId}")
    public ResponseEntity<String>deleteCustomer(@PathVariable int customerId) throws RecordNotFound {
        customerService.deleteCustomer(customerId);
        String message= "Customer Deleted Successfully";
        return new ResponseEntity<>(message,HttpStatus.OK);

    }


}






/*
    //Add an user
    @Autowired
    UserService userService;

    @PostMapping(path = "/adduser")
    public ResponseEntity<UserDto> addUser(@RequestBody User user) {
        UserDto user1=userService.addUser(user);
        return  new ResponseEntity<>(user1,HttpStatus.OK);
    }

    @GetMapping(path = "/getuser/{userId}")
    public UserDto viewUser(@PathVariable int userId) {
        return userService.viewUser(userId);

    }

    @GetMapping(path = "/getusers")
    public List<UserDto> viewUsers() {
        return userService.viewUsers();
    }

    @PutMapping(path = "/updateuser")
    public UserDto updateUser(@RequestBody User user) {
        return userService.updateUser(user);

    }

    @DeleteMapping(path = "/deleteuser/{userId}")
    public String deleteUser(@PathVariable int userId) {
        userService.deleteUser(userId);
        return "User Deleted Successfully";

    }

    @GetMapping(path="/getcustomers")
    public List<Customer> viewCustomers(){
        return customerService.viewCustomers();
    }
    */

