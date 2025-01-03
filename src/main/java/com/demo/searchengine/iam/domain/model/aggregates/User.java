package com.demo.searchengine.iam.domain.model.aggregates;

import com.demo.searchengine.iam.domain.model.entities.Role;
import com.demo.searchengine.iam.domain.model.valueobjects.Roles;
import com.demo.searchengine.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
public class User extends AuditableAbstractAggregateRoot<User> {

    @NotBlank
    @Size(max = 50)
    private String username;

    @NotBlank
    @Size(max = 120)
    private String password;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "user_roles",
    joinColumns = @JoinColumn(name = "user_id"),
    inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    public User(){
        this.roles = new HashSet<>();
    }

    public User(String username, String password, List<Role> roles) {
        this();
        this.username = username;
        this.password = password;
        this.addRoles(roles);
    }
    public User addRole(Role role) {
        this.roles.add(role);
        return this;
    }
    public User addRoles(List<Role> roles) {
        var validateRoles = Role.validateRoleSet(roles);
        this.roles.addAll(validateRoles);
        return this;
    }
}

