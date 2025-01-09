package com.demo.searchengine.iam.interfaces.rest.transform;

import com.demo.searchengine.iam.domain.model.entities.Role;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RoleListFromStringAssembler {
    public static List<Role> toRoleListFromString(List<String> resourceList) {
        return Objects.nonNull(resourceList) ? resourceList.stream()
                .map(Role::toRoleFromName).toList() : new ArrayList<Role>();

    }
}
