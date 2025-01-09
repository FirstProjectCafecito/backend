package com.demo.searchengine.iam.domain.model.entities;

import com.demo.searchengine.iam.domain.model.valueobjects.Roles;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Role {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private Roles name;

    public Role(Roles name){
        this.name = name;
    }

    public static Role getDefaultRole(){ return new Role(Roles.USER);}

    public static Role toRoleFromName(String name){
        return new Role(Roles.valueOf(name));
    }

    public static List<Role> validateRoleSet(List<Role> roles){
        return roles == null || roles.isEmpty() ? List.of(getDefaultRole()) : roles;
    }

    public String getStringName(){
        return name.name();
    }

}
