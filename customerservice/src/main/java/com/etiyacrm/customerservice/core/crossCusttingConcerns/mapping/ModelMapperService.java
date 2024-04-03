package com.etiyacrm.customerservice.core.crossCusttingConcerns.mapping;

import org.modelmapper.ModelMapper;

public interface ModelMapperService {
    ModelMapper forResponse();
    ModelMapper forRequest();
}
