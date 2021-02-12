package com.nextgate.assesment.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.nextgate.assesment.datatypes.Album;
import com.nextgate.assesment.datatypes.Singer;

public interface SingerRepository extends JpaRepository<Singer,Integer> {
	public Page<Singer> findByName(String name, Pageable pageable);

}
