package com.cars.bean;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="Booking")

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
private int bookingId;
    @ManyToOne
    @JoinColumn(name="customerId")
    @JsonBackReference
    private Customer customer;

    //private Car car;
    private String fuelType;
    private String seaterType;
 //  @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
 @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", shape = JsonFormat.Shape.STRING)
private LocalDateTime bookingDate;


    private int price;
    //@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", shape = JsonFormat.Shape.STRING)
private LocalDateTime fromDate;


    //@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", shape = JsonFormat.Shape.STRING)
    private LocalDateTime toDate;
private String status;

    public Booking(int bookingId, Customer customer, String fuelType, String seaterType, LocalDateTime bookingDate, int price, LocalDateTime fromDate,LocalDateTime toDate, String status, Car car) {
        this.bookingId = bookingId;
        this.customer = customer;
        this.fuelType = fuelType;
        this.seaterType = seaterType;
        this.bookingDate = bookingDate;
        this.price = price;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.status = status;
        this.car = car;
    }



    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "car_number", referencedColumnName = "carNumber")
    @JsonBackReference(value="a")
    private Car car;
}
