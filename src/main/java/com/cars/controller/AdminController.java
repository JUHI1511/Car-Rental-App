package com.cars.controller;

import com.cars.bean.*;
import com.cars.dto.UserDto;
import com.cars.exception.RecordAlreadyExists;
import com.cars.exception.RecordNotFound;
import com.cars.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/admin")
public class AdminController {
    //Admin can view registered users no crud operations on registered users
    @Autowired
    CustomerService customerService;
    @Autowired
    CompanyService companyService;


    @GetMapping(path = "/getcustomer/{customerId}")
    public ResponseEntity<Customer> viewCustomer(@PathVariable int customerId) throws RecordNotFound {
        return new ResponseEntity<>(customerService.viewCustomer(customerId), HttpStatus.OK);

    }

    @GetMapping(path = "/getcustomers")
    public ResponseEntity<List<Customer>> viewCustomers() {

        return new ResponseEntity<>(customerService.viewCustomers(), HttpStatus.OK);
    }


    //Admin can perform crud operations on companies

    @PostMapping(path = "/addcompany")
    public ResponseEntity<Company> addCompany(@RequestBody Company company) throws RecordAlreadyExists {
        Company newCompany = companyService.addCompany(company);
        return new ResponseEntity<>(newCompany, HttpStatus.OK);
    }

    @GetMapping(path = "/getcompany/{companyId}")
    public ResponseEntity<Company> viewCompany(@PathVariable int companyId) throws RecordNotFound {
        return new ResponseEntity<>(companyService.viewCompany(companyId), HttpStatus.OK);

    }

    @GetMapping(path = "/getcompany")
    public ResponseEntity<List<Company>> viewCompany() {

        return new ResponseEntity<>(companyService.viewCompany(), HttpStatus.OK);
    }

    @PutMapping(path = "/updatecompany")
    public ResponseEntity<Company> updateCompany(@RequestBody Company company) throws RecordNotFound {
        return new ResponseEntity<>(companyService.updateCompany(company), HttpStatus.OK);

    }

    @DeleteMapping(path = "/deletecompany/{companyId}")
    public ResponseEntity<String> deleteCompany(@PathVariable int companyId) throws RecordNotFound {
        companyService.deleteCompany(companyId);
        String message = "Company Deleted Successfully";
        return new ResponseEntity<>(message, HttpStatus.OK);

    }

    //Admin can perform crud operations on variants
    @Autowired
    VariantService variantService;

    @PostMapping(path = "/addvariant")
    public ResponseEntity<Variant> addVariant(@RequestBody Variant variant) throws RecordAlreadyExists {
        Variant newVariant = variantService.addVariant(variant);
        return new ResponseEntity<>(newVariant, HttpStatus.OK);
    }

    @GetMapping(path = "/getvariant/{variantId}")
    public ResponseEntity<Variant> viewVariant(@PathVariable int variantId) throws RecordNotFound {
        return new ResponseEntity<>(variantService.viewVariant(variantId), HttpStatus.OK);

    }

    @GetMapping(path = "/getvariants")
    public ResponseEntity<List<Variant>> viewVariants() {

        return new ResponseEntity<>(variantService.viewVariants(), HttpStatus.OK);
    }

    @PutMapping(path = "/updatevariant")
    public ResponseEntity<Variant> updateVariant(@RequestBody Variant variant) throws RecordNotFound {
        return new ResponseEntity<>(variantService.updateVariant(variant), HttpStatus.OK);

    }

    @DeleteMapping(path = "/deletevariant/{variantId}")
    public ResponseEntity<String> deleteVariant(@PathVariable int variantId) throws RecordNotFound {
        variantService.deleteVariant(variantId);
        String message = "Variant Deleted Successfully";
        return new ResponseEntity<>(message, HttpStatus.OK);

    }

    //Admin can perform crud operations on cars
    @Autowired
    CarService carService;

    @PostMapping(path = "/addcar")
    public ResponseEntity<Car> addCar(@RequestBody Car car) throws RecordAlreadyExists {
        return new ResponseEntity<>(carService.addCar(car), HttpStatus.OK);

    }

    @GetMapping(path = "/getcar/{carNumber}")
    public ResponseEntity<Car> viewCar(@PathVariable int carNumber) throws RecordNotFound {
        return new ResponseEntity<>(carService.viewCar(carNumber), HttpStatus.OK);

    }

    @GetMapping(path = "/getcars")
    public ResponseEntity<List<Car>> viewCars() {

        return new ResponseEntity<>(carService.viewCars(), HttpStatus.OK);
    }

    @PutMapping(path = "/updatecar")
    public ResponseEntity<Car> updateCar(@RequestBody Car car) throws RecordNotFound {
        return new ResponseEntity<>(carService.updateCar(car), HttpStatus.OK);

    }

    @DeleteMapping(path = "/deletecar/{carNumber}")
    public ResponseEntity<String> deleteCar(@PathVariable int carNumber) throws RecordNotFound {
        carService.deleteCar(carNumber);
        String message = "Car Deleted Successfully";
        return new ResponseEntity<>(message, HttpStatus.OK);

    }

    // Admin can view bookings
    @Autowired
    BookingService bookingService;


    @GetMapping(path = "/getbooking/{bookingId}")
    public ResponseEntity<Booking> viewBooking(@PathVariable int bookingId) throws RecordNotFound {
        return new ResponseEntity<>(bookingService.viewBooking(bookingId), HttpStatus.OK);

    }

    @GetMapping(path = "/getbookings")
    public ResponseEntity<List<Booking>> viewBookings() {
        return new ResponseEntity<>(bookingService.viewBookings(), HttpStatus.OK);
    }
}











/*
    //Admin can crud on users
    @Autowired
    UserService userService;

    @PostMapping(path="/adduser")
    public ResponseEntity<UserDto> addUser(@RequestBody User user){
        return  new ResponseEntity<>(userService.addUser(user),HttpStatus.OK);

    }

    @GetMapping(path="/getuser/{userId}")
    public UserDto viewUser(@PathVariable int userId){
        return userService.viewUser(userId);

    }
    @GetMapping(path="/getusers")
    public List<UserDto> viewUsers(){

        return userService.viewUsers();
    }
    @PutMapping(path="/updateuser")
    public UserDto updateUser(@RequestBody User user){
        return userService.updateUser(user);

    }
    @DeleteMapping(path="/deleteuser/{userId}")
    public String deleteUser(@PathVariable int userId){
        userService.deleteUser(userId);
        return "User Deleted Successfully";

    }


     */


