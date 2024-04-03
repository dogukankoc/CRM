package com.etiyacrm.customerservice.core.crossCusttingConcerns.details;

import org.springframework.beans.factory.parsing.Problem;
import org.springframework.http.HttpStatus;

public class InternalServerErrorProblemDetails extends ProblemDetails {
    public InternalServerErrorProblemDetails (){
        setTitle("Internal Server Error");
        setType("http://etiya.com/exceptions/internalserver");
        setStatus(HttpStatus.INTERNAL_SERVER_ERROR.toString());
    }
}
