package com.cars.bean;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@ToString
@Table(name="variant")
public class Variant {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="id")
    private int variantId;
    @Column(name="name")
    private String variantName;
    @ManyToOne
    @JsonBackReference
    @JoinColumn(name="companyId")
    private Company company;
    @JsonIgnore
    @OneToMany(cascade=CascadeType.ALL,mappedBy="variant")
    private List<Car> car;

    public Variant(int variantId, String variantName, Company company, int rentalPrice,List<Car>car) {
        this.variantId = variantId;
        this.variantName = variantName;
        this.company = company;
        this.rentalPrice = rentalPrice;
        this.car=car;
    }

    private int rentalPrice;

}
