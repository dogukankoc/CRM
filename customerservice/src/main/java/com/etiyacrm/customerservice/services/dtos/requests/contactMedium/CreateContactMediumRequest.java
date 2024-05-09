package com.etiyacrm.customerservice.services.dtos.requests.contactMedium;

import jakarta.persistence.Column;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateContactMediumRequest {
    @NotNull
    private String email;
    @NotNull
    private String mobilePhone;

    private String homePhone;

    private String fax;

    private long customerId;
}