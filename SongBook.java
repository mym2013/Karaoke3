package com.teamtreehouse.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SongBook {
  private List<Song> mSongs;
  
  public SongBook() {
    mSongs = new ArrayList<Song>();
  }
  
  public void addSong(Song song) {
    mSongs.add(song);
  }
  
  public int getSongCount() {
    return mSongs.size();
  }
  
  // FIXME:  This should be cached!
  private Map<String, List<Song>> byArtist() {
		//
		
    Map<String, List<Song>> byArtist = new HashMap<>();
    for (Song song : mSongs) {
      List<Song> artistSongs = byArtist.get(song.getArtist());
      if (artistSongs == null) {
	// indicar que el atajo de la línea 28<> es sólo valido para java 7 hacia arriba
		// just to point out that this shorthand is only available on java  7 and higher		
				
        artistSongs = new ArrayList<>();
        byArtist.put(song.getArtist(), artistSongs);
      }
      artistSongs.add(song);
    }
    return byArtist;
  }
  
  public Set<String> getArtists() {
    return byArtist().keySet();
  }
  
  public List<Song> getSongsForArtist(String artistName) {
    return byArtist().get(artistName);
  }
  
}