package com.cars.dao;

import com.cars.bean.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyDao extends JpaRepository<Company,Integer> {
    Company findByCompanyName(String companyName);
}
