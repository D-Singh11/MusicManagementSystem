package com.nextgate.assesment.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.nextgate.assesment.datatypes.Album;
import com.nextgate.assesment.datatypes.Singer;
import com.nextgate.assesment.datatypes.SingerCode;

/**
 * This service handles the Singer related CRUD operations
 */
@Service
public class SingerService {
	@Autowired
	private SingerRepository singerRepository;
	
	
	/**
     * Retrieve singer by name
     * @param name - String
     * @param pageNo - Integer
     * @param pageSize -Integer
     * @param sortBy - String
     * @return Page
     */
	public Page getSingerByName(String name, Integer pageNo, Integer pageSize,String sortBy) {
		Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
		Page<Singer> pageResult = singerRepository.findByName(name, paging);
		return pageResult;
	}
	
	
	/**
     * Retrieve singer by singer name
     * @param pageNo - Integer
     * @param pageSize -Integer
     * @param sortBy - String
     * @return Page
     */
	public Page getAllSingers(Integer pageNo, Integer pageSize, String sortBy) {
		Pageable paging = PageRequest.of(pageNo, pageSize,Sort.by(sortBy));
		Page<Singer> pageResult = singerRepository.findAll(paging);
		return pageResult;
	}
	public Optional<Singer> getSinger(Integer id){
		return singerRepository.findById(id);
	}
	
	
	 /**
     * Retrieve all SingerCode, used in create album page
     * @return Iterable<Song>
     */
	public Iterable<SingerCode> getSingerIds(){
		ArrayList<SingerCode> singers = new ArrayList<SingerCode>();
		singerRepository.findAll().forEach(singer -> {
			singers.add(new SingerCode(singer.getName(),singer.getSingerId()));
		});
		return singers;
	}
	
	
	/**
     * Create new singer
     * @param Singer
     * @return Singer
     */
	public Singer createSinger(Singer singer) {
		Singer savedSinger = singerRepository.save(singer);
		return savedSinger;
	}

}
