package com.leleproperty.leleproperty.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leleproperty.leleproperty.model.dao.User;
import com.leleproperty.leleproperty.model.request.RegistrationRequest;
import com.leleproperty.leleproperty.service.UserService;




@RestController
@RequestMapping("/api")
public class UserController {
	
	 @Autowired
	    private UserService userService;

	    @PostMapping("/register")
	    public ResponseEntity<String> register(@RequestBody RegistrationRequest request) {
	        boolean registered = userService.registerUser(request.getUsername(), request.getPassword());
	        if (registered) {
	            return ResponseEntity.ok("User registered successfully");
	        } else {
	            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Username already exists");
	        }
	    }
	    @GetMapping("/loggeduser")
	    public ResponseEntity<User> getLoginUser() {
	    	if(userService.getLoggedInUser()==null) {
	    		ResponseEntity.status(HttpStatus.BAD_REQUEST).body("not login yet");
	    	}
	    	 return ResponseEntity.ok(userService.getLoggedInUser());
	        }
	    
	    

@GetMapping("/getAllUser")
public ResponseEntity<List<User>> getAllUser() {
	 return ResponseEntity.ok(userService.getAllUser());
    }

}


	    // Login is handled automatically by Spring Security's form login
	
