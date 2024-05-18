package com.etiyacrm.customerservice.services.dtos.requests.individualCustomer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CheckNationalityIdentityRequest {
    private String nationalityIdentity;
    private String firstName;
    private String lastName;
    private int birthDate;
}
