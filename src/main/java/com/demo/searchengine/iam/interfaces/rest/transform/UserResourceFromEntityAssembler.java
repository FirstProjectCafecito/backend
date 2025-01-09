package com.demo.searchengine.iam.interfaces.rest.transform;

import com.demo.searchengine.iam.domain.model.aggregates.User;
import com.demo.searchengine.iam.interfaces.rest.resources.UserResource;

public class UserResourceFromEntityAssembler {
    public static UserResource toResourceFromEntity(User entity){

        return new UserResource(entity.getId(),entity.getUsername(),
                RoleStringListFromEntityListAssembler.toResourceListFromEntity(entity.getRoles()));
    }
}
