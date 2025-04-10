package com.leleProperty.LeleProperty.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.leleProperty.LeleProperty.model.dao.Role;
import com.leleProperty.LeleProperty.model.dao.User;
import com.leleProperty.LeleProperty.repository.RoleRepository;
import com.leleProperty.LeleProperty.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository; // Inject RoleRepository

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public boolean registerUser(String username, String password) {
        if (userRepository.existsByUsername(username)) {
            return false; // Username already exists
        }

        String encodedPassword = passwordEncoder.encode(password);
        User user = new User();
        user.setUsername(username);
        user.setPassword(encodedPassword);
        user.setEnabled(true);

        Set<Role> roles = new HashSet<>();
        Role defaultRole = roleRepository.findByName("USER"); // Fetch Role by name from database

        if (defaultRole == null) {
            // Handle case where "USER" role doesn't exist.
            // You might want to create the role here, or return an error.
            defaultRole = new Role();
            defaultRole.setName("USER");
            roleRepository.save(defaultRole); //create a new role.
        }

        roles.add(defaultRole);
        user.setRoles(roles);

        userRepository.save(user);
        return true;
    }
    public User getLoggedInUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated()) {
            return userRepository.getUserByUsername(authentication.getName());
        }
        return null; // Return null if no user is logged in
    }
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}
	
}