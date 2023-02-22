package com.cars.dto;

import com.cars.bean.Car;
import com.cars.bean.Customer;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
@Data
public class BookingDto {

    private int bookingId;
   // @NotBlank( message = "Passenger UIN cannot be null")
    //@Size(min=12,max=12,message = "passenger UIN must have 12 digits")
    private Customer customer;
    private String fuelType;
    private String seaterType;
    private Date bookingDate;
    private int price;
    private Date fromDate;
    private Date toDate;
    private String status;
    private Car car;
}

