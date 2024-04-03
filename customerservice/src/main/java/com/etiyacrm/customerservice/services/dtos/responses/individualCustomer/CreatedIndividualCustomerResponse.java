package com.etiyacrm.customerservice.services.dtos.responses.individualCustomer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreatedIndividualCustomerResponse {
    private long id;
    private String firstName;
    private String middleName;
    private String lastName;
    private String email;
    private Boolean gender;
    private String motherName;
    private String fatherName;
    private String nationalityIdentity;
    private LocalDateTime birthDate;
    private LocalDateTime createdDate;
}