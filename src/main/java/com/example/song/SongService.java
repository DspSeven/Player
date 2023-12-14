/*

 * You can use the following import statements
  
 * import org.springframework.http.HttpStatus;
 * import org.springframework.web.server.ResponseStatusException;

 */

package com.example.song;

import java.util.*;

import org.springframework.cache.support.NullValue;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;

import com.example.song.Song;
import com.example.song.SongRepository;

// Don't modify the below code
public class SongService implements SongRepository {
    private static HashMap<Integer, Song> playlist = new HashMap<>();
    int uniqueId = 6;
    public SongService() {
        playlist.put(1, new Song(1, "Butta Bomma", "Ramajogayya Sastry", "Armaan Malik", "Thaman S"));
        playlist.put(2, new Song(2, "Kathari Poovazhagi", "Vijay", "Benny Dayal, Swetha Mohan", "A.R. Rahman"));
        playlist.put(3, new Song(3, "Tum Hi Ho", "Mithoon", "Arijit Singh", "Mithoon"));
        playlist.put(4, new Song(4, "Vizhiyil", "Vairamuthu", "Unni Menon", "A.R. Rahman"));
        playlist.put(5, new Song(5, "Nenjame", "Panchu Arunachalam", "S.P.Balasubrahmanyam", "Ilaiyaraaja"));
    }

    // Don't modify the above code

    // Write your code here
    
    @Override
    public ArrayList<Song> getAllSongs() {
    	Collection<Song> mySongs = playlist.values();
    	ArrayList<Song> arrayList = new ArrayList<>(mySongs);
    	return arrayList;
    }
    
    @Override
    public Song newSong(Song song) {
    	song.setSongId(uniqueId);
    	playlist.put(uniqueId, song);
    	uniqueId+=1;
    	return song;
    }
    
    @Override
    public Song getSong(int songId) {
    	Song getSong = playlist.get(songId);
    	if(getSong == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    	return getSong;
    }
    
    @Override
    public Song updateSong(int songId, Song song) {
    	Song updateSong = playlist.get(songId);
    	if(updateSong == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    	if(song.getSongName() != null) {
    		updateSong.setSongName(song.getSongName());
    	}
    	if(song.getLyricist() != null) {
    		updateSong.setLyricist(song.getLyricist());
    	}
    	if(song.getSinger() != null) {
    		updateSong.setSinger(song.getSinger());
    	}
    	if(song.getMusicDirector() != null) {
    		updateSong.setMusicDirector(song.getMusicDirector());
    	}
    	return updateSong;
    }
    
    @Override
    public void deleteSong(int songId) {
    	Song deleteSong = playlist.get(songId);
    	if(deleteSong == null) {
    		throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    	}else {
    		playlist.remove(songId);
    		throw new ResponseStatusException(HttpStatus.NO_CONTENT);
    	}
    }
}