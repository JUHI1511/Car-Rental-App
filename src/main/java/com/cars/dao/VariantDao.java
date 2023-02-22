package com.cars.dao;

import com.cars.bean.Variant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VariantDao extends JpaRepository<Variant,Integer> {

}
