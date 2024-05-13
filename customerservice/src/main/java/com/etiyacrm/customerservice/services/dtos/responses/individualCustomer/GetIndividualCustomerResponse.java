package com.etiyacrm.customerservice.services.dtos.responses.individualCustomer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetIndividualCustomerResponse {
    private long id;
    private String firstName;
    private String middleName;
    private String lastName;
    private Boolean gender;
    private String motherName;
    private String fatherName;
    private String nationalityIdentity;
    private LocalDate birthDate;
//    private LocalDateTime createdDate;
}
