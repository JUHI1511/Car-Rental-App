package com.cars.service;

import com.cars.bean.Variant;
import com.cars.exception.RecordAlreadyExists;
import com.cars.exception.RecordNotFound;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface VariantService {
    Variant addVariant(Variant variant) throws RecordAlreadyExists;

    Variant viewVariant(Integer variantId) throws RecordNotFound;

    List<Variant> viewVariants();

    Variant updateVariant(Variant variant) throws RecordNotFound;

    String deleteVariant(Integer variantId) throws RecordNotFound;


}
