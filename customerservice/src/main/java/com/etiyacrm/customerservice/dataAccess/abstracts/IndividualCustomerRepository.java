package com.etiyacrm.customerservice.dataAccess.abstracts;

import com.etiyacrm.customerservice.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IndividualCustomerRepository extends JpaRepository<Customer,Long> {
}
