package com.cars.dto;

import com.cars.bean.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private int userId;

    @NotEmpty(message = "userType cannot be empty")
    private Role userType;
    @NotEmpty(message = "userName cannot be empty")
    @Size(min=3,message = "username must have minimum 3 characters")
    private String userName;

    @NotEmpty
    @Email(regexp = "[a-zA-Z_][\\w]*@[a-zA-Z]+[.][a-zA-Z]+",message = "Invalid Email, should follow <id>@<domain>.<topleveldomain> pattern")
    private String userEmail;
}
