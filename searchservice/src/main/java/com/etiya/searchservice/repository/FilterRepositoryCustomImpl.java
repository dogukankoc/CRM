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
            query.addCriteria(Criteria.where("nationalityIdentity").regex(nationalityIdentity));
        }
        if (customerId != null) {
            query.addCriteria(Criteria.where("customerId").regex(customerId));
        }
        if (mobilePhone != null) {
            query.addCriteria(Criteria.where("mobilePhone").regex(mobilePhone));
        }
        if (accountNumber != null) {
            query.addCriteria(Criteria.where("accountNumber").regex(accountNumber));
        }
        if (firstName != null) {
            query.addCriteria(Criteria.where("firstName").regex(firstName,"i"));
        }
        if (lastName != null) {
            query.addCriteria(Criteria.where("lastName").regex(lastName,"i"));
        }
        if (orderNumber != null) {
            query.addCriteria(Criteria.where("orderNumber").regex(orderNumber));
        }
        return mongoTemplate.find(query, Customer.class);
    }
}