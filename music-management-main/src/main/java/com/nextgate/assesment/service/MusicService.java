package com.nextgate.assesment.service;

import com.nextgate.assesment.datatypes.SingerCode;
import com.nextgate.assesment.datatypes.User;

import org.springframework.stereotype.Service;

/**
 * The Music service that will handle the CRUD operations
 *
 * TODO: Add more methods & link to a SQL database
 *
 * @author nextgate.employee
 */
@Service
public class MusicService {

    /**
     * Retrieve a song by Id
     *
     * @param Id the song Id
     * @return Song
     */
    public SingerCode getSongById(String Id) {
        return new SingerCode("Test Song");
    }
    
    
    /**
     * Retrieve a user by username
     *
     * @param username of th user
     * @return User
     */
    public User getUserName(String username) {
        return new User("User returned");
    }

}
