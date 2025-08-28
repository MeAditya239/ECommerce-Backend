package com.aditya.ecommerce.service;

import com.aditya.ecommerce.exception.UserException;
import com.aditya.ecommerce.model.User;

public interface UserService {

    public User findUserById(Long userId) throws UserException;

    public User findUserProfilesByJWT(String jwt) throws UserException;
}
