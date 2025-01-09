package com.demo.searchengine.iam.insfrastructure.tokens.jwt;

import com.demo.searchengine.iam.application.internal.outboundservices.tokens.TokenService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.core.Authentication;

public interface BearerTokenService extends TokenService {
    String getBearerTokenFrom(HttpServletRequest token);

    String generateToken(Authentication authentication);
}
