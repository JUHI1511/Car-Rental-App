package com.cars.service;

import com.cars.bean.Customer;
import com.cars.dao.CustomerDao;
import com.cars.exception.InvalidEmail;
import com.cars.exception.InvalidPhoneNumber;
import com.cars.exception.RecordAlreadyExists;
import com.cars.exception.RecordNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerDao customerDao;

    @Override
    public Customer addCustomer(Customer customer) throws RecordAlreadyExists, InvalidEmail, InvalidPhoneNumber {
        if (customerDao.existsById(customer.getCustomerId())){
            throw new RecordAlreadyExists("Customer with this customer id  already exists");
        }
       // this.validateCustomerEmail(customer.getEmailId());
        //this.validateCustomerPhone(customer.getPhone());
        customerDao.save(customer);
        return customer;
    }

    @Override
    public Customer viewCustomer(Integer customerId) throws RecordNotFound {
        if(customerDao.findById(customerId).isEmpty())
            throw new RecordNotFound("Customer with "+customerId+" does not exist");
        Optional id=customerDao.findById(customerId);
        Customer customer= (Customer) id.get();
        return customer;

    }

    @Override
    public List<Customer> viewCustomers() {
        List<Customer>customerList=customerDao.findAll();
        return  customerList;
    }

    @Override
    public Customer updateCustomer(Customer customer) throws  RecordNotFound,InvalidEmail,InvalidPhoneNumber{
        int id=customer.getCustomerId();
        if(customerDao.findById(id).isEmpty())
            throw new RecordNotFound("Customer with "+id+ " does not exist");
        Customer customer1=customerDao.findById(id).get();
        this.validateCustomerEmail(customer.getEmailId());
        this.validateCustomerPhone(customer.getPhone());
        customer1.setEmailId(customer.getEmailId());
        customer1.setCustomerName(customer.getCustomerName());
        customer1.setBookings(customer.getBookings());
        customer1.setGender(customer.getGender());
        customer1.setAddress(customer.getAddress());
        customer1.setPhone(customer.getPhone());
        customer1.setLicenseNo(customer.getLicenseNo());
        customerDao.save(customer1);
        return customer1;


    }

    @Override
    public String deleteCustomer(Integer customerId) throws RecordNotFound{
        if(customerDao.findById(customerId).isEmpty())
            throw new RecordNotFound("Customer with "+customerId+" does not exist");
        //convert BigInteger to integer
        if(customerDao.findById(customerId).isPresent())
            customerDao.deleteById(customerId);
        return "Customer Deleted Successfully";
    }

    @Override
    public void validateCustomerEmail(String email) throws InvalidEmail {
        String regexEmail="^(.+)@(\\\\S+)$";
        Pattern p1 = Pattern.compile(regexEmail);
        Matcher m1 = p1.matcher(email);
        if(!m1.matches())
            throw new InvalidEmail("Not a valid Email id");

    }
    @Override
    public void validateCustomerPhone(long phoneNumber) throws InvalidPhoneNumber {
        String phone= String.valueOf(phoneNumber);
        String regexPhone = "^[1-9][\\d]{5}$";
        Pattern p1 = Pattern.compile(regexPhone);
        Matcher m1 = p1.matcher(phone);
        if(!m1.matches())
            throw new InvalidPhoneNumber("Phone number should contain only 5 Digits & should not start with 0");

    }
}
