package com.etiyacrm.customerservice;

import com.etiyacrm.common.annotations.EnableSecurity;
import com.etiyacrm.common.business.abstracts.MessageService;
import com.etiyacrm.common.business.concretes.MessageServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;

@SpringBootApplication()
@EnableSecurity()
public class CustomerserviceApplication {
	public static void main(String[] args) {
		SpringApplication.run(CustomerserviceApplication.class, args);
	}

	@Bean
	public ModelMapper getModelMapper() {
		return new ModelMapper();
	}

}
