/*
 * You can use the following import statements
 * 
 * import org.springframework.web.bind.annotation.*;
 * import java.util.*;
 * 
 */

// Write your code here
package com.example.song;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SongController {
	SongService songService = new SongService();

	@GetMapping("/songs")
	public ArrayList<Song> getAllSongs() {
		return songService.getAllSongs();
	}
	
	@PostMapping("/songs")
	public Song newSong(@RequestBody Song song) {
		return songService.newSong(song);
	}
	
	@GetMapping("/songs/{songId}")
	public Song getSong(@PathVariable("songId") int songId) {
		return songService.getSong(songId);
	}
	
	@PutMapping("/songs/{songId}")
	public Song updateSong(@PathVariable("songId") int songId, @RequestBody Song song) {
		return songService.updateSong(songId,song);
	}
	
	@DeleteMapping("/songs/{songId}")
	public void deleteSong(@PathVariable("songId") int songId) {
		songService.deleteSong(songId);
	}
}
