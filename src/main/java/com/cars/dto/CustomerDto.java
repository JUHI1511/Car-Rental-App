package com.cars.dto;

import com.cars.bean.Booking;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
public class CustomerDto {

    private int customerId;

    private String emailId;

    private String customerName;


    private String gender;


    private String address;
    private long phone;
    private String licenseNo;

}

