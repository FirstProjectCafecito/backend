package com.demo.searchengine.iam.application.internal.queryservices;

import com.demo.searchengine.iam.domain.model.aggregates.User;
import com.demo.searchengine.iam.domain.model.queries.GetAllUsersQuery;
import com.demo.searchengine.iam.domain.model.queries.GetUserByIdQuery;
import com.demo.searchengine.iam.domain.model.queries.GetUserByUsernameQuery;
import com.demo.searchengine.iam.domain.services.UserQueryService;
import com.demo.searchengine.iam.insfrastructure.persistence.jpa.repositories.UserRepository;

import java.util.List;
import java.util.Optional;

public class UserQueryServiceImpl implements UserQueryService {
    private final UserRepository userRepository;

    public UserQueryServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> handle(GetAllUsersQuery query) {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> handle(GetUserByIdQuery query) {
        return userRepository.findById(query.userId());
    }

    @Override
    public Optional<User> handle(GetUserByUsernameQuery query) {
        return userRepository.findByUsername(query.username());
    }
}
