package com.thementorhub.blog.services;

import com.thementorhub.blog.payloads.UserDto;

import java.util.List;

public interface UserService {
    UserDto CreateUser(UserDto user);
    UserDto UpdateUser(UserDto user,Integer userId);
    UserDto getUserById(Integer userId);
    List<UserDto> getAllUsers();
    void deleteUser(Integer userId);

}
