package com.cars.dto;

import com.cars.bean.Booking;
import com.cars.bean.Variant;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Data
public class CarDto {
    private int carNumber;
    private int modelYear;
    private Booking booking;
    private Variant variant;
    private String status;

}
