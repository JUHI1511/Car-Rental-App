package com.cars.bean;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @NoArgsConstructor
@Entity
@ToString
@Table(name="caruser")
public class User {
      @Id
      @GeneratedValue(strategy= GenerationType.AUTO)
              @Column(name="id")
    private int userId;
    @NotNull(message = "User type is mandatory")
      private Role userType;
      @Column(name="name")
      @NotNull(message = "Name is mandatory")
    private String userName;
    @NotNull(message = "Password is mandatory")
      @Column(name="password")
      private String userPassword;
    @NotNull(message = "Phone Number is mandatory")
      @Column(name="phonenumber")
    private long userPhone;
    @NotBlank(message = "Email is mandatory")
      @Column(name="email")
    private String userEmail;

    public User(int userId, User userType,String userName, String userPassword,long userPhone, String userEmail) {
        this.userId = userId;
        if(userType.equals("admin") || userType.equals("Admin") || userType.equals("ADMIN"))
            this.userType = Role.ADMIN;
        else
            this.userType=Role.CUSTOMER;

        this.userName = userName;
        this.userPassword=userPassword;
        this.userPhone = userPhone;
        this.userEmail = userEmail;
    }

}

