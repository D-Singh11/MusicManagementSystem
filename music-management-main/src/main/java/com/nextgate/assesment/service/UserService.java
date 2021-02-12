package com.nextgate.assesment.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import org.aspectj.weaver.tools.ISupportsMessageContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.nextgate.assesment.datatypes.Album;
import com.nextgate.assesment.datatypes.User;


/**
 * This service handles the User related CRUD operations
 *
 */
@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;


	/**
     * Create new user
     * @param User
     * @return User
     */
	public User createUser(User user) {
		User u = userRepository.save(user);
		
		return userRepository.save(u);
	}
	
	
	/**
     * Validate a user
     * @param User
     * @return boolean
     */
	public boolean validateUser(User user) {
		boolean isAuntenticated = false;
		List<User> result = userRepository.findByUsername(user.getUserName());
		
		for(User savedUser: result) {
			if (savedUser.getUserName().equalsIgnoreCase(user.getUserName()) && savedUser.getPassword().equals(user.getPassword())) {
				 isAuntenticated =  true;
				 break;
			}
		}
		return isAuntenticated;
	}

}
