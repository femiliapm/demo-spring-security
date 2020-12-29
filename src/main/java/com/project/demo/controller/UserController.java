package com.project.demo.controller;

import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.demo.config.MD5Generator;
import com.project.demo.dto.LoginForm;
import com.project.demo.dto.StatusMessageDto;
import com.project.demo.entity.UserEntity;
import com.project.demo.services.UserServiceImpl;

@RestController
@RequestMapping("/api/users")
public class UserController {
	@Autowired
	UserServiceImpl userService;

	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody LoginForm dto) {
		StatusMessageDto response = new StatusMessageDto();
		try {
//			LOGIN DAN GENERATE HASH PASSWORD
			UserEntity user = userService.login(dto.getUsername(), MD5Generator.generate(dto.getPassword()));
			if (user == null) {
				response.setStatus(0);
				response.setMessage("Login gagal");
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR.value()).body(response);
			}

//			LOGIN BERHASIL, GENERATE TOKEN, UNTUK REQUEST LAINNYA
			String baseStr = user.getUsername() + ":" + user.getPassword(); // base string token
			String token = Base64.getEncoder().encodeToString(baseStr.getBytes()); // encode menjadi token

			response.setStatus(1);
			response.setMessage("Login berhasil");
			response.setData(token);

			return ResponseEntity.ok(response);
		} catch (Exception e) {
			// TODO: handle exception
			response.setStatus(0);
			response.setMessage("Error: " + e.getMessage());
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED.value()).body(response);
		}
	}
	
	@PostMapping("/register")
	public ResponseEntity<?> register(@RequestBody UserEntity data) {
		StatusMessageDto response = new StatusMessageDto();
		
		try {
			data.setPassword(MD5Generator.generate(data.getPassword()));
			UserEntity createdUser = userService.insert(data);
			
			response.setStatus(1);
			response.setMessage("User created!");
			response.setData(createdUser);
			
			return ResponseEntity.ok(response);
		} catch (Exception e) {
			// TODO: handle exception
			response.setStatus(0);
			response.setMessage("Error: " + e.getMessage());
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED.value()).body(response);
		}
	}
}
