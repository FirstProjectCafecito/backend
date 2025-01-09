package com.demo.searchengine.iam.interfaces.rest.transform;

import com.demo.searchengine.iam.domain.model.entities.Role;

import java.util.List;
import java.util.Set;

public class RoleStringListFromEntityListAssembler {
    public static List<String> toResourceListFromEntity(Set<Role> entity){
        return entity.stream()
                .map(Role::getStringName)
                .toList();
    }
}
