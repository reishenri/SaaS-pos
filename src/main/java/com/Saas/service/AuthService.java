package com.Saas.service;

import com.Saas.exception.UserException;
import com.Saas.payload.dto.UserDto;
import com.Saas.payload.response.AuthResponse;

public interface AuthService {

    AuthResponse signup(UserDto userDto) throws UserException;
    AuthResponse login(UserDto userDto) throws UserException;

}
