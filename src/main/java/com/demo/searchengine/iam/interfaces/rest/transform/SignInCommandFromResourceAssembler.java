package com.demo.searchengine.iam.interfaces.rest.transform;

import com.demo.searchengine.iam.domain.model.commands.SignInCommand;
import com.demo.searchengine.iam.interfaces.rest.resources.SignInResource;

public class SignInCommandFromResourceAssembler {
    public static SignInCommand toCommandFromResource(SignInResource resource) {
        return new SignInCommand(resource.username(), resource.password());
    }
}
