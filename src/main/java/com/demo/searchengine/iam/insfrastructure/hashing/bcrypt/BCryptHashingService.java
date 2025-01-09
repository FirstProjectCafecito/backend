package com.demo.searchengine.iam.insfrastructure.hashing.bcrypt;

import com.demo.searchengine.iam.application.internal.outboundservices.hashing.HashingService;
import org.springframework.security.crypto.password.PasswordEncoder;

public interface BCryptHashingService extends HashingService, PasswordEncoder {
}
