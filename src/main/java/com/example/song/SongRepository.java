// Write your code here
package com.example.song;

import java.util.ArrayList;

public interface SongRepository {
	ArrayList<Song> getAllSongs();
	Song newSong(Song song);
	Song getSong(int songId);
	Song updateSong(int songId, Song song);
	void deleteSong(int songId);
}
