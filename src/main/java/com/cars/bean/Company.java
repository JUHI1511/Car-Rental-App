package com.cars.bean;

import javax.persistence.*;

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
@Table(name="Companies")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int companyId;
    private String companyName;
    @JsonIgnore
    @OneToMany(cascade=CascadeType.ALL,mappedBy="company")
    private List<Variant> variant;

    public Company(int companyId, String companyName,List<Variant> variant) {
        this.companyId = companyId;
        this.companyName = companyName;
        this.variant=variant;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }
}
