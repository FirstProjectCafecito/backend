package com.demo.searchengine.iam.domain.model.queries;

import com.demo.searchengine.iam.domain.model.valueobjects.Roles;

public record GetRoleByNameQuery(Roles name) {
}
