package com.demo.searchengine.iam.interfaces.rest.transform;

import com.demo.searchengine.iam.domain.model.aggregates.User;
import com.demo.searchengine.iam.interfaces.rest.resources.AuthenticatedUserResource;

public class AuthenticatedUserResourceFromEntityAssembler {
    public static AuthenticatedUserResource toResourceFromEntity(User entity, String token){
        return new AuthenticatedUserResource(entity.getId(),
                entity.getUsername(),
                token);
    }
}
