package com.cars.dto;

import com.cars.bean.Variant;
import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import java.util.List;
@Data
public class CompanyDto {
    private int companyId;
    private String companyName;
    private List<Variant> variant;

}
