package com.etiya.searchservice.kafka;

import com.etiyacrm.common.events.customers.CustomerCreatedEvent;
import com.etiya.searchservice.entities.Customer;
import com.etiya.searchservice.service.abstracts.FilterService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerCreatedConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerCreatedConsumer.class);
    private FilterService filterService;

    @KafkaListener(topics = "customer-created", groupId = "create-customer")
    private void consume(CustomerCreatedEvent customerCreatedEvent) {
        Customer customer = new Customer();
        customer.setCustomerId(customerCreatedEvent.getCustomerId());
        customer.setFirstName(customerCreatedEvent.getFirstName());
        customer.setMiddleName(customerCreatedEvent.getMiddleName());
        customer.setLastName(customerCreatedEvent.getLastname());
        customer.setNationalityIdentity(customerCreatedEvent.getNationalityIdentity());
        customer.setMobilePhone(customerCreatedEvent.getMobilePhone());
        LOGGER.info(String.format("Customer created event consumer => %s", customerCreatedEvent.toString()));
        filterService.addCustomer(customer);
    }
}