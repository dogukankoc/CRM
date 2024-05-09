package com.etiyacrm.customerservice.services.dtos.responses.contactMedium;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreatedContactMediumResponse {

    private String email;

    private String mobilePhone;

    private String homePhone;

    private String fax;

    private long customerId;
}