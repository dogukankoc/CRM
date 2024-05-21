package com.etiyacrm.authservice.services.abstracts;

import com.etiyacrm.authservice.services.dtos.requests.RegisterRequest;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    void add(RegisterRequest request);
}
