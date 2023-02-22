package com.cars.bean;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name="cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int carNumber;
    private int modelYear;
    //@JsonManagedReference(value="ans")
   @OneToOne(mappedBy="car")
   @JsonIgnore
    private Booking booking;

    public Car(int carNumber, int modelYear, Booking booking,Variant variant, String status) {
        this.carNumber = carNumber;
        this.modelYear = modelYear;
        this.booking = booking;
        this.variant = variant;
        this.status = status;
    }

    @ManyToOne
    @JsonBackReference()
    @JoinColumn(name="variantId")
    private Variant variant;
    private String status;

}
