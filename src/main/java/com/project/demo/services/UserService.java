package com.project.demo.services;

import com.project.demo.entity.UserEntity;

// SERVICE USER
public interface UserService {
	UserEntity insert(UserEntity dto);

	UserEntity login(String username, String password);
}
