package com.nextgate.assesment.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.nextgate.assesment.datatypes.Album;
import com.nextgate.assesment.datatypes.User;

public interface UserRepository extends CrudRepository<User, Long>{
	public List<User>findByUsername(String username);
}
