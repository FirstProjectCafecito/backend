package com.demo.searchengine.iam.domain.services;

import com.demo.searchengine.iam.domain.model.aggregates.User;
import com.demo.searchengine.iam.domain.model.queries.GetAllUsersQuery;
import com.demo.searchengine.iam.domain.model.queries.GetUserByIdQuery;
import com.demo.searchengine.iam.domain.model.queries.GetUserByUsernameQuery;

import java.util.List;
import java.util.Optional;

public interface UserQueryService {
    List<User> handle(GetAllUsersQuery query);
    Optional<User> handle(GetUserByIdQuery query);
    Optional<User> handle(GetUserByUsernameQuery query);
}
