package com.nextgate.assesment.rest;

import com.nextgate.assesment.datatypes.Album;
import com.nextgate.assesment.datatypes.AlbumRequest;
import com.nextgate.assesment.datatypes.Singer;
import com.nextgate.assesment.datatypes.SingerCode;
import com.nextgate.assesment.datatypes.User;
import com.nextgate.assesment.service.AlbumService;
import com.nextgate.assesment.service.MusicService;
import com.nextgate.assesment.service.SingerService;
import com.nextgate.assesment.service.UserService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * A REST controller for managing the music catalogue via the User, Album and Singer services
 */
@RestController
@CrossOrigin(origins="*")
public class MusicRestController {
    
    @Autowired
    private UserService userService;
    
    @Autowired
    private AlbumService albumService;
    
    @Autowired
    private SingerService singerService;
    

    /**
     * POST method used to validate user login
     * @param User 
     * @return boolean
     */
    @PostMapping("user")
    public boolean checkUser(@RequestBody User user) {
        return userService.validateUser(user);
    }
    
    
    /**
     * POST method to Create new user
     * @param User
     * @return Album
     */
    @PostMapping("user/create")
    public User createUser(@RequestBody User user) {
    	
//    	User user = new User();
//    	user.setUserName("uuuu");
//    	user.setPassword("12345");
    	User u = userService.createUser(user);
        return u;
    }
    
    
    /**
     * GET method to get retrieve all albums
     * @param pageNo - Integer
     * @param pageSize -Integer
     * @param sortBy - String
     * @return Page
     */
    @GetMapping("album/all")
    public Page getAlbums(
    		@RequestParam(defaultValue = "0") Integer pageNo,
    		@RequestParam(defaultValue = "5")Integer pageSize,
    		@RequestParam(defaultValue = "name") String sortBy
    		) {
    	
        return albumService.getAlbums( pageNo,  pageSize,sortBy);
    }
    
    /**
     * GET method to get retrieve album by name
     * @param albumName - String
     * @param pageNo - Integer
     * @param pageSize -Integer
     * @param sortBy - String
     * @return Page
     */
    @GetMapping("album/{albumName}")
    public Page getAlbumName(
    		@PathVariable("albumName") String albumName,
    		@RequestParam(defaultValue = "0") Integer pageNo,
    		@RequestParam(defaultValue = "5")Integer pageSize,
    		@RequestParam(defaultValue = "name") String sortBy) {
    	
        return albumService.getAlbumByName(albumName, pageNo, pageSize, sortBy);
    }
    
    
    /**
     * GET method to get retrieve albums by singer name
     * @param singer - String
     * @param pageNo - Integer
     * @param pageSize -Integer
     * @return Page
     */
    @GetMapping("album/singer/{singer}")
    public Page getAlbumsBySinger(
    		@PathVariable("singer") String singer,
    		@RequestParam(defaultValue = "0") Integer pageNo,
    		@RequestParam(defaultValue = "5")Integer pageSize) {
    	
        return albumService.getAlbumBySinger(singer,pageNo,  pageSize);
    }
    
    
    /**
     * POST method to create new album with the existing singer
     * @param AlbumRequest
     * @return List<Album>
     */
    @PostMapping("album/create") 
    public List<Album> createAlbum(@RequestBody AlbumRequest req) {
//    	
    	Singer singer = singerService.getSinger(req.getSinger()).get();
    	Album album = new Album();
    	album.setCompany(req.getCompany());
    	album.setName(req.getName());
    	album.setYear(req.getYear());
    	album.setSinger(singer.getName());
    	ArrayList<Album> al = new ArrayList<Album>();
    	al.add(album);
    	singer.setAlbums(al);
    	return singerService.createSinger(singer).getAlbums();
    }
    
 
    
    /**
     * GET method to retrieve all singers
     * @param pageNo - Integer
     * @param pageSize -Integer
     * @param sortBy - String
     * @return Page
     */
    @GetMapping("singer/all")
    public Page getSingers(
    		@RequestParam(defaultValue = "0") Integer pageNo,
    		@RequestParam(defaultValue = "5")Integer pageSize,
    		@RequestParam(defaultValue = "name") String sortBy) {
        return singerService.getAllSingers(pageNo,pageSize,  sortBy);
    }

    
    /**
     * GET method to get retrieve singer by name
     * @param singerName - String
     * @param pageNo - Integer
     * @param pageSize -Integer
     * @param sortBy - String
     * @return Page
     */
    @GetMapping("singer/{singerName}")
    public Page getSinger(
    		@PathVariable("singerName") String singerName,
    		@RequestParam(defaultValue = "0") Integer pageNo,
    		@RequestParam(defaultValue = "5")Integer pageSize,
    		@RequestParam(defaultValue = "name") String sortBy) {
    	
        return singerService.getSingerByName(singerName, pageNo, pageSize, sortBy);
    }
    
    
    /**
     * GET method to get retrieve SingerCode
     * @return Iterable<Song>
     */
    @GetMapping("singer/ids")
    public Iterable<SingerCode> getSingerIds() {
        return singerService.getSingerIds();
    }
    
    
    /**
     * POST method to create new singer
     * @param Singer
     * @return Singer
     */
//    @RequestMapping(path="singer/create")
    @PostMapping("singer/create")
    public Singer createSinger(@RequestBody Singer singer) {
    	Singer s = singerService.createSinger(singer);
        return s;
    }
    
}
