package com.minhtuan.commercemanager.services.ServicesImpl;

import com.minhtuan.commercemanager.model.User;
import com.minhtuan.commercemanager.repository.UserRepository;
import com.minhtuan.commercemanager.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;


    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }
}
