package com.etiyacrm.customerservice.business.dtos.requests.individualCustomer;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdateIndividualCustomerRequest {
    @NotBlank(message = "First name cannot be null and only spaces")
    private String firstName;
    private String middleName;
    @NotBlank(message = "Last name cannot be null and only spaces")
    private String lastName;
    @NotBlank(message = "Email cannot be null and only spaces")
    @Email(message = "Not a valid email address")
    private String email;
    @NotNull(message = "Gender cannot be null")
    @NotEmpty(message = "Gender cannot be empty")
    private Boolean gender;
    @NotBlank(message = "Mother name cannot be null and only spaces")
    private String motherName;
    @NotBlank(message = "Father name cannot be null and only spaces")
    private String fatherName;
    @NotBlank(message = "Nationality id cannot be null and only spaces")
    private String nationalityIdentity;
    @NotBlank(message = "Birth date cannot be null")
    private LocalDateTime birthDate;
}
