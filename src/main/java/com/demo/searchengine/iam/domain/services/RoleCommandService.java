package com.demo.searchengine.iam.domain.services;

import com.demo.searchengine.iam.domain.model.commands.SeedRolesCommand;

public interface RoleCommandService {
    void handle(SeedRolesCommand command);
}
