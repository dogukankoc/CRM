package com.etiyacrm.authservice.services.abstracts;

import com.etiyacrm.authservice.services.dtos.requests.LoginRequest;
import com.etiyacrm.authservice.services.dtos.requests.RegisterRequest;

public interface AuthService {

    void register(RegisterRequest request);
    String login(LoginRequest request);
}
