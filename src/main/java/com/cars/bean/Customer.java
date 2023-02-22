package com.cars.bean;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="Customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int customerId;
    private String emailId;
    private String customerName;
    @JsonIgnore
    @OneToMany(cascade=CascadeType.ALL,mappedBy="customer")
    private List<Booking> bookings;



    private String gender;

    public Customer(int customerId, String emailId, String customerName, List<Booking> bookings, String gender, String address, long phone, String licenseNo) {
        this.customerId = customerId;
        this.emailId = emailId;
        this.customerName = customerName;
        this.bookings = bookings;
        this.gender = gender;
        this.address = address;
        this.phone = phone;
        this.licenseNo = licenseNo;
    }

    private String address;
    private long phone;
    private String licenseNo;
}
