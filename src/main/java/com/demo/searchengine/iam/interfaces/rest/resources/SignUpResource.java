package com.demo.searchengine.iam.interfaces.rest.resources;

import com.demo.searchengine.iam.domain.model.entities.Role;

import java.util.List;

public record SignUpResource(String username, String password, List<String> roles) {
}
