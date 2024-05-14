package com.etiya.searchservice.repository;

import com.etiya.searchservice.entities.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import java.util.List;

public class FilterRepositoryCustomImpl implements FilterRepositoryCustom{
    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public List<Customer> searchResult
            (String nationalityIdentity, String customerId, String mobilePhone, String accountNumber, String firstName, String lastName, String orderNumber) {
        Query query = new Query();
        if (nationalityIdentity != null) {
            query.addCriteria(Criteria.where("nationalityIdentity").is(nationalityIdentity));
        }
        if (customerId != null) {
            query.addCriteria(Criteria.where("customerId").is(customerId));
        }
        if (mobilePhone != null) {
            query.addCriteria(Criteria.where("mobilePhone").is(mobilePhone));
        }
        if (accountNumber != null) {
            query.addCriteria(Criteria.where("accountNumber").is(accountNumber));
        }
        if (firstName != null) {
            query.addCriteria(Criteria.where("firstName").is(firstName));
        }
        if (lastName != null) {
            query.addCriteria(Criteria.where("lastName").is(lastName));
        }
        if (orderNumber != null) {
            query.addCriteria(Criteria.where("orderNumber").is(orderNumber));
        }
        return mongoTemplate.find(query, Customer.class);
    }
}