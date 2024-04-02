package com.etiyacrm.customerservice;

import com.etiyacrm.customerservice.core.utilities.mapping.ModelMapperManager;
import com.etiyacrm.customerservice.core.utilities.mapping.ModelMapperService;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CustomerserviceApplication {
	public static void main(String[] args) {
		SpringApplication.run(CustomerserviceApplication.class, args);
	}

	@Bean
	public ModelMapper getModelMapper() {
		return new ModelMapper();
	}
//	@Bean
//	public ModelMapperService getModelMapperService(ModelMapper  modelMapper) {
//		return new ModelMapperManager(modelMapper);
//	}
}
