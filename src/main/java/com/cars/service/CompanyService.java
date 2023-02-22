package com.cars.service;

import com.cars.bean.Company;
import com.cars.exception.RecordAlreadyExists;
import com.cars.exception.RecordNotFound;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CompanyService {
    Company addCompany(Company company) throws RecordAlreadyExists;

    Company viewCompany(Integer companyId) throws RecordNotFound;


    List<Company> viewCompany();

    Company updateCompany(Company company) throws RecordNotFound,NullPointerException;

    String deleteCompany(Integer companyId) throws RecordNotFound;


}
