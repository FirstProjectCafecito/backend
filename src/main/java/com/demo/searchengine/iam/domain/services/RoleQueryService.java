package com.demo.searchengine.iam.domain.services;

import com.demo.searchengine.iam.domain.model.entities.Role;
import com.demo.searchengine.iam.domain.model.queries.GetAllRolesQuery;
import com.demo.searchengine.iam.domain.model.queries.GetRoleByNameQuery;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface RoleQueryService {
    List<Role> handle(GetAllRolesQuery query);
    Optional<Role> handle(GetRoleByNameQuery query);

}
