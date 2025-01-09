package com.demo.searchengine.iam.application.internal.commandservices;

import com.demo.searchengine.iam.domain.model.aggregates.User;
import com.demo.searchengine.iam.domain.model.commands.SignInCommand;
import com.demo.searchengine.iam.domain.model.commands.SignUpCommand;
import com.demo.searchengine.iam.domain.services.UserCommandService;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserCommandServiceImpl implements UserCommandService {

    @Override
    public Optional<User> handle(SignInCommand command) {
        return Optional.empty();
    }

    @Override
    public Optional<ImmutablePair<User, String>> handle(SignUpCommand command) {
        return Optional.empty();
    }
}
