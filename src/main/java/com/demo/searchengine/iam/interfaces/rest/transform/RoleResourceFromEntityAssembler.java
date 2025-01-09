package com.demo.searchengine.iam.interfaces.rest.transform;

import com.demo.searchengine.iam.domain.model.entities.Role;
import com.demo.searchengine.iam.interfaces.rest.resources.RoleResource;

public class RoleResourceFromEntityAssembler {
    public static RoleResource toResourceFromEntity(Role entity){
        return new RoleResource(entity.getId(),entity.getStringName());
    }
}
