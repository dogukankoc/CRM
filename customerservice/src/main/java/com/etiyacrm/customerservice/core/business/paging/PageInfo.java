package com.etiyacrm.customerservice.core.business.paging;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PageInfo {
    private int page = 0; //Default value
    private int size = 10;
}
