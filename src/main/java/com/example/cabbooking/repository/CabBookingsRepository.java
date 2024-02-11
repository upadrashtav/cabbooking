package com.example.cabbooking.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.cabbooking.model.Cabbookings;

@Repository
public interface CabBookingsRepository extends CrudRepository<Cabbookings, Long>{

}
