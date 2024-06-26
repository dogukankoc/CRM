package com.etiyacrm.common.events.contactMediums;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContactMediumUpdatedEvent {
    private String id;
    private String mobilePhone;
}
