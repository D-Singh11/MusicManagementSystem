package com.nextgate.assesment;

import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.nextgate.assesment.datatypes.Album;
import com.nextgate.assesment.datatypes.Singer;
import com.nextgate.assesment.datatypes.User;
import com.nextgate.assesment.service.SingerRepository;
import com.nextgate.assesment.service.UserRepository;


@Component
public class Loader implements ApplicationRunner{
	
	@Autowired
	private UserRepository userRepository;
    
    @Autowired
    private SingerRepository singerRepository;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		ArrayList<User> users = new ArrayList<User>();
		ArrayList<Album> albums = new ArrayList<Album>();
		HashMap<String, Singer> singers = new HashMap<String, Singer>();
		
		Scanner scan = new Scanner(new File("data/ng_music_data.txt"));
	    while(scan.hasNextLine()){
	        String line = scan.nextLine().trim();
	        String [] item = line.split("\\|");
	        if (item[0].equals("U")) {
	        	User user = new User(item[1].trim(), item[2].trim());
	        	users.add(user);
			}
	        else if (item[0].equals("A")) {
	        	String singer = item[1].trim().toLowerCase();
	        	String name = item[2].trim().toLowerCase();
	        	String year = item[3].trim();
	        	String company = item[4].trim();
	        	Album album = new Album(name, singer, year, company);
	        	albums.add(album);
			}
	        else if (item[0].equals("S")) {
	        	String name = item[1].trim().toLowerCase();
				if (!singers.containsKey(name)) {
					
					DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyyMMdd");
					LocalDate dob = LocalDate.parse(item[2].trim(),format);
		        	String gender = item[3].trim();
		        	String company = item[4].trim();
					Singer singer = new Singer(name, dob, gender, company);
					singers.put(name, singer);
				}
			}
	    }
	    scan.close();
	    
	    albums.forEach(album -> {
	    	Singer s = singers.get(album.getSinger());
	    	s.getAlbums().add(album);
	    });
	    
	    if (users.size() > 0) {
	    	 userRepository.saveAll(users);
		}
	    
	    if (singers.size() > 0) {
	    	 singerRepository.saveAll(singers.values());
		}
		
	}
}
