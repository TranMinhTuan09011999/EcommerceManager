package com.minhtuan.commercemanager.services;

import com.minhtuan.commercemanager.model.User;

import java.util.Optional;

public interface UserService {
    Optional<User> findById(Long id);
}