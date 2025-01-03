package com.demo.searchengine.iam.domain.services;

import com.demo.searchengine.iam.domain.model.aggregates.User;
import com.demo.searchengine.iam.domain.model.commands.SignInCommand;
import com.demo.searchengine.iam.domain.model.commands.SignUpCommand;
import org.apache.commons.lang3.tuple.ImmutablePair;

import java.util.Optional;

public interface UserCommandService {
    Optional<User> handle(SignInCommand command);
    Optional<ImmutablePair<User, String>> handle(SignUpCommand command);
}
