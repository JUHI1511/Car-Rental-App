package com.cars.service;

import com.cars.bean.Company;
import com.cars.dao.CompanyDao;
import com.cars.exception.RecordAlreadyExists;
import com.cars.exception.RecordNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {
    @Autowired
    CompanyDao companyDao;

    @Override
    public Company addCompany(Company company) throws RecordAlreadyExists {
        if (companyDao.existsById(company.getCompanyId())){
            throw new RecordAlreadyExists("Company with this company id already exists");
        }
        companyDao.save(company);
        return company;
    }

    @Override
    public Company viewCompany(Integer companyId) throws RecordNotFound {
        if(companyDao.findById(companyId).isEmpty()){
            throw new RecordNotFound("Company with "+companyId+" does not exist");
        }
        Optional id=companyDao.findById(companyId);

        Company company= (Company) id.get();
        return company;

    }




    @Override
    public List<Company> viewCompany() {
        List<Company>companyList=companyDao.findAll();
        return  companyList;
    }

    @Override
    public Company updateCompany(Company company) throws RecordNotFound{
        int id=company.getCompanyId();
        if(companyDao.findById(id).isEmpty()){
            throw new RecordNotFound("Company with "+id+" does not exist");
        }
        Company company1=companyDao.findById(id).get();
        company1.setCompanyName(company.getCompanyName());
        company1.setVariant(company.getVariant());
        companyDao.save(company1);
        return company1;


    }

    @Override
    public String deleteCompany(Integer companyId) throws RecordNotFound {
       if(companyDao.findById(companyId).isEmpty())
           throw new RecordNotFound("Company with "+companyId+" does not exist");
        if(companyDao.findById(companyId).isPresent())
            companyDao.deleteById(companyId);
        return "Company Deleted Successfully";
    }

}
