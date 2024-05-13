package com.etiyacrm.common.events.customers;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerCreatedEvent {
    private String customerId;
    private String firstName;
    private String middleName;
    private String lastname;
    private String mobilePhone;
    private String nationalityIdentity;
}