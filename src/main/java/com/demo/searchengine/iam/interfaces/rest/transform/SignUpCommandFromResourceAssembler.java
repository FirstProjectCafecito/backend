package com.demo.searchengine.iam.interfaces.rest.transform;

import com.demo.searchengine.iam.domain.model.commands.SignUpCommand;
import com.demo.searchengine.iam.domain.model.entities.Role;
import com.demo.searchengine.iam.interfaces.rest.resources.SignUpResource;

public class SignUpCommandFromResourceAssembler {
    public static SignUpCommand toCommandFromResource(SignUpResource resource) {
        var roles = RoleListFromStringAssembler.toRoleListFromString(resource.roles());
        System.out.println("roles: " + roles);
        return new SignUpCommand(resource.username(),
                resource.password(),
                roles
                );
    }
}
