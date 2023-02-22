package com.cars.service;

import com.cars.bean.Variant;
import com.cars.dao.VariantDao;
import com.cars.exception.RecordAlreadyExists;
import com.cars.exception.RecordNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VariantServiceImpl implements  VariantService{
    @Autowired
    VariantDao variantDao;

    @Override
    public Variant addVariant(Variant variant) throws RecordAlreadyExists {
        if (variantDao.existsById(variant.getVariantId())){
            throw new RecordAlreadyExists("Variant Id  already exists");
        }
        variantDao.save(variant);
        return variant;
    }

    @Override
    public Variant viewVariant(Integer variantId) throws RecordNotFound {
        if(variantDao.findById(variantId).isEmpty())
              throw new RecordNotFound("Variant with "+ variantId+ " does not exist");
        Optional id=variantDao.findById(variantId);
        Variant variant= (Variant) id.get();
        return variant;

    }

    @Override
    public List<Variant> viewVariants() {
        List<Variant>variantList=variantDao.findAll();
        return  variantList;
    }

    @Override
    public Variant updateVariant(Variant variant) throws RecordNotFound,NullPointerException {
        int id=variant.getVariantId();
        if(variantDao.findById(id).isEmpty())
            throw new RecordNotFound("Variant with "+ id+ " does not exist");
        Variant variant1=variantDao.findById(id).get();
        variant1.setVariantName(variant.getVariantName());
        variant1.setCompany(variant.getCompany());
        variant1.setRentalPrice(variant.getRentalPrice());
        variant1.setCar(variant.getCar());
        variantDao.save(variant1);
        return variant1;


    }

    @Override
    public String deleteVariant(Integer variantId) throws RecordNotFound {
        if(variantDao.findById(variantId).isEmpty())
            throw new RecordNotFound("Variant with "+ variantId+ " does not exist");
        if(variantDao.findById(variantId).isPresent())
            variantDao.deleteById(variantId);
        return "Variant Deleted Successfully";
    }

}
