package com.demo.searchengine.iam.interfaces.rest;

import com.demo.searchengine.iam.domain.model.entities.Role;
import com.demo.searchengine.iam.domain.model.queries.GetAllRolesQuery;
import com.demo.searchengine.iam.domain.model.queries.GetRoleByNameQuery;
import com.demo.searchengine.iam.domain.model.valueobjects.Roles;
import com.demo.searchengine.iam.domain.services.RoleQueryService;
import com.demo.searchengine.iam.interfaces.rest.resources.RoleResource;
import com.demo.searchengine.iam.interfaces.rest.transform.RoleResourceFromEntityAssembler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/roles",produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Roles", description = "Available Role Endpoints")
public class RolesController {
    private final RoleQueryService roleQueryService;

    public RolesController(RoleQueryService roleQueryService) {
        this.roleQueryService = roleQueryService;
    }
    @GetMapping
    @Operation(summary = "Get all roles", description = "Get all roles.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Roles retrieved successfully.")
    })
    public ResponseEntity<List<RoleResource>> getAllRoles(){
        var getAllRolesQuery = new GetAllRolesQuery();
        var roles = roleQueryService.handle(getAllRolesQuery);
        var roleResource = roles.stream().map(RoleResourceFromEntityAssembler::toResourceFromEntity).toList();
        return ResponseEntity.ok(roleResource);
    }
    @GetMapping
    @Operation(summary = "Get Role By Name", description = "Get Role By Name.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Roles retrieved successfully.")
    })
    public ResponseEntity<RoleResource> getRoleByName(String roleName){
        var getRoleByNameQuery = new GetRoleByNameQuery(Roles.valueOf(roleName));
        var role = roleQueryService.handle(getRoleByNameQuery);
        if(role.isEmpty()) return ResponseEntity.notFound().build();
        var roleEntity= role.get();
        var roleResource = RoleResourceFromEntityAssembler.toResourceFromEntity(roleEntity);
        return ResponseEntity.ok(roleResource);
    }
}
