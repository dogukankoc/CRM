package com.etiyacrm.customerservice.services.dtos.responses.contactMedium;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeletedContactMediumResponse {
    private long id;
    private LocalDateTime deletedDate;
}