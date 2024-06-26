package com.etiya.searchservice.service.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostSearchCustomerResponse {
    String customerId;
    String nationalityIdentity;
    String accountNumber;
    String mobilePhone;
    String firstName;
    String lastName;
    String middleName;
    String orderNumber;
    String role;
}
