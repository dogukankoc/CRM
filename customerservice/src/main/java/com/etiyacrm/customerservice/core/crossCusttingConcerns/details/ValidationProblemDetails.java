package com.etiyacrm.customerservice.core.crossCusttingConcerns.details;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.Map;

@Data
public class ValidationProblemDetails extends ProblemDetails{
//    private List<Map<String,String>> errors;
    private Map<String, String> errors;
    public ValidationProblemDetails(){
        setTitle("Validation Rule Violation");
        setDetail("Validation Problem");
        setType("http://etiya.com/exceptions/validation");
        setStatus(HttpStatus.BAD_REQUEST.toString());

    }
}
