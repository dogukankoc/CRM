package com.etiya.searchservice.repository;

import com.etiya.searchservice.entities.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;


public interface FilterRepository extends MongoRepository<Customer,String>, FilterRepositoryCustom {

}