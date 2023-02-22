package com.cars.service;

import com.cars.bean.Customer;
import com.cars.exception.InvalidEmail;
import com.cars.exception.InvalidPhoneNumber;
import com.cars.exception.RecordAlreadyExists;
import com.cars.exception.RecordNotFound;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomerService {
    Customer addCustomer(Customer customer) throws RecordAlreadyExists, InvalidEmail, InvalidPhoneNumber;

    Customer viewCustomer(Integer customerId) throws RecordNotFound;

    List<Customer> viewCustomers();

    Customer updateCustomer(Customer customer) throws RecordNotFound,InvalidEmail, InvalidPhoneNumber;

    String deleteCustomer(Integer customerId) throws RecordNotFound;


    void validateCustomerEmail(String email) throws InvalidEmail;

    void validateCustomerPhone(long phoneNumber) throws InvalidPhoneNumber;
}
