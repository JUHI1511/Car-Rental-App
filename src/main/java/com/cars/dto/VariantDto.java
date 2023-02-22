package com.cars.dto;

import com.cars.bean.Car;
import com.cars.bean.Company;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data

public class VariantDto {
    @NotEmpty
    @Email(regexp = "[a-zA-Z_][\\w]*@[a-zA-Z]+[.][a-zA-Z]+",message = "Invalid Email, should follow <id>@<domain>.<topleveldomain> pattern")
    private int variantId;

    @NotEmpty
    private String variantName;
    private Company company;

    private int rentalPrice;

}
