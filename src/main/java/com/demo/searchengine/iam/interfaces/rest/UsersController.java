package com.demo.searchengine.iam.interfaces.rest;

import com.demo.searchengine.iam.domain.model.queries.GetAllUsersQuery;
import com.demo.searchengine.iam.domain.model.queries.GetUserByIdQuery;
import com.demo.searchengine.iam.domain.model.queries.GetUserByUsernameQuery;
import com.demo.searchengine.iam.domain.services.UserQueryService;
import com.demo.searchengine.iam.interfaces.rest.resources.UserResource;
import com.demo.searchengine.iam.interfaces.rest.transform.UserResourceFromEntityAssembler;
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
@RequestMapping(value = "api/v1/users",produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Users", description = "Available User Endpoints")
public class UsersController {
    public final UserQueryService userQueryService;

    public UsersController(UserQueryService userQueryService) {
        this.userQueryService = userQueryService;
    }
    @GetMapping
    @Operation(summary = "Get All Users", description = "Get All Users")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Users Retrieved Successfully")
    })
    public ResponseEntity<List<UserResource>> getAllUsers(){
        var getAllUsersQuery = new GetAllUsersQuery();
        var users = userQueryService.handle(getAllUsersQuery);
        var usersResource = users.stream().map(UserResourceFromEntityAssembler::toResourceFromEntity).toList();
        return ResponseEntity.ok(usersResource);
    }
    @GetMapping
    @Operation(summary = "Get User By Id", description = "Get User By Id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User Retrieved Successfully")
    })
    public ResponseEntity<UserResource> getUserById(Long userId){
        var getUserByIdQuery = new GetUserByIdQuery(userId);
        var user = userQueryService.handle(getUserByIdQuery);
        if(user.isEmpty()) return ResponseEntity.notFound().build();
        var userOptional = user.get();
        var userResource = UserResourceFromEntityAssembler.toResourceFromEntity(userOptional);
        return ResponseEntity.ok(userResource);

    }
    @GetMapping
    @Operation(summary = "Get User By Username", description = "Get User By Username")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User Retrieved Successfully")
    })
    public ResponseEntity<UserResource> getUserByUsername(String username){
        var getUserByUsernameQuery = new GetUserByUsernameQuery(username);
        var user = userQueryService.handle(getUserByUsernameQuery);
        if(user.isEmpty()) return ResponseEntity.notFound().build();
        var userOptional = user.get();
        var userResource = UserResourceFromEntityAssembler.toResourceFromEntity(userOptional);
        return ResponseEntity.ok(userResource);
    }
}
