package com.project.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.demo.dto.LoginForm;
import com.project.demo.entity.UserEntity;
import com.project.demo.repository.UserRepository;

@Service
@Transactional
public class UserServiceImpl implements UserService, UserDetailsService {
	@Autowired
	private UserRepository repo;

//	METHOD MENCARI USER
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		UserEntity user = repo.findByUsername(username);
//		USER TIDAK DITEMUKAN
		if (user == null) {
			throw new UsernameNotFoundException("User tidak ditemukan");
		}
		return user;
	}

//	METHOD INSERT REGISTER -- SAVE REPO
	@Override
	public UserEntity insert(UserEntity dto) {
		// TODO Auto-generated method stub
		return repo.save(dto);
	}

//	METHOD LOGIN
	@Override
	public UserEntity login(String username, String password) {
		// TODO Auto-generated method stub
		UserEntity user = repo.findByUsername(username);
//		USER TIDAK DITEMUKAN
		if (user == null) {
			return null;
		}

//		PASSWORD TIDAK SAMA DENGAN DI DB
		if (!user.getPassword().equals(password)) {
			return null;
		}

//		BERHASIL LOGIN
		return user;
	}

}
