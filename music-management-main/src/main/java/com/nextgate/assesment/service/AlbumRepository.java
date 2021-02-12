package com.nextgate.assesment.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.nextgate.assesment.datatypes.Album;

//public interface AlbumRepository extends CrudRepository<Album,Integer> {
//
//}

public interface AlbumRepository extends JpaRepository<Album,Integer> {
	public Page<Album> findBySinger(String singer, Pageable pageable);

	public Page<Album> findByName(String name, Pageable pageable);
}

