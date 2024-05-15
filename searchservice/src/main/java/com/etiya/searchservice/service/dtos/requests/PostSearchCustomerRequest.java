package com.etiya.searchservice.service.dtos.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostSearchCustomerRequest {
    String customerId;
    String nationalityIdentity;
    String accountNumber;
    String mobilePhone;
    String firstName;
    String lastName;
    String orderNumber;
}