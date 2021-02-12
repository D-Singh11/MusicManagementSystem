package com.nextgate.assesment.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.nextgate.assesment.datatypes.Album;
import com.nextgate.assesment.datatypes.Singer;

/**
 * This service handles the Album related CRUD operations
 */
@Service
public class AlbumService {
	
	@Autowired
	private AlbumRepository albumRepository;
	
	/**
     * Retrieve all albums
     * @param pageNo - Integer
     * @param pageSize -Integer
     * @param sortBy - String
     * @return Page
     */
	public Page getAlbums(Integer pageNo, Integer pageSize, String sortBy) {	
		Pageable paging = PageRequest.of(pageNo, pageSize,Sort.by(sortBy));
		Page<Album> pageResult = albumRepository.findAll(paging);
		return pageResult;
	}
	
	
	public Iterable<Album> getAll() {
		return albumRepository.findAll();
	}


	public Optional<Album> getAlbumById(Integer id) {
//		return albums.get(id);
		return albumRepository.findById(id);
	}
	
	
	/**
     * Retrieve album by singer
     * @param albumName - String
     * @param pageNo - Integer
     * @param pageSize -Integer
     * @param sortBy - String
     * @return Page
     */
	public Page getAlbumBySinger(String singer, Integer pageNo, Integer pageSize) {
		Pageable paging = PageRequest.of(pageNo, pageSize);
		Page<Album> pageResult = albumRepository.findBySinger(singer, paging);
		return pageResult;
	}
	
	
	/**
     * Retrieve album by name
     * @param albumName - String
     * @param pageNo - Integer
     * @param pageSize -Integer
     * @param sortBy - String
     * @return Page
     */
	public Page getAlbumByName(String name, Integer pageNo, Integer pageSize,String sortBy) {
		Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
		Page<Album> pageResult = albumRepository.findByName(name, paging);
		return pageResult;
	}
	
	
	
	/**
     * Create new album
     * @param AlbumRequest
     * @return Album
     */
	public Album createAlbum(Album album) {
		Album newAlbum = new Album();
		newAlbum.setName(album.getName());
		newAlbum.setYear(album.getYear());
		newAlbum.setCompany(album.getCompany());
		return albumRepository.save(newAlbum);
	}
	

//	Not used
	public String deleteAlbum(Integer albumId) {
		albumRepository.deleteById(albumId);
		return albumId + "removed";
	}

}
