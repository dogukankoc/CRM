package com.etiya.searchservice.service.concretes;

import com.etiya.searchservice.entities.Customer;
import com.etiya.searchservice.repository.FilterRepository;
import com.etiya.searchservice.service.abstracts.FilterService;
import com.etiya.searchservice.service.dtos.requests.PostSearchCustomerRequest;
import com.etiya.searchservice.service.dtos.responses.PostSearchCustomerResponse;
import lombok.AllArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class FilterServiceImpl implements FilterService {

    private FilterRepository filterRepository;
    private MongoTemplate mongoTemplate;

    @Override
    public void addCustomer(Customer customer) {
        filterRepository.save(customer);
    }

    @Override
    public List<PostSearchCustomerResponse> search(
            String nationalityIdentity,
            String id,
            String accountNumber,
            String mobilePhone,
            String firstName,
            String lastName,
            String orderNumber) {

        List<Customer> customers =
                this.filterRepository.searchResult(
                        nationalityIdentity, id, mobilePhone, accountNumber, firstName, lastName, orderNumber
                );
        List<PostSearchCustomerResponse> searchResponses = new ArrayList<>();

        for (Customer customer : customers) {
            PostSearchCustomerResponse searchResponse = new PostSearchCustomerResponse();
            searchResponse.setCustomerId(customer.getCustomerId());
            searchResponse.setFirstName(customer.getFirstName());
            searchResponse.setLastName(customer.getLastName());
            searchResponse.setMiddleName(customer.getMiddleName());
            searchResponse.setRole(customer.getRole());
            searchResponse.setNationalityIdentity(customer.getNationalityIdentity());
            searchResponse.setAccountNumber(customer.getAccountNumber());
            searchResponse.setMobilePhone(customer.getMobilePhone());
            searchResponses.add(searchResponse);
        }
        return searchResponses;
    }
    }
