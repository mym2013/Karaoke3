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
		// indicar que el atajo de la línea 28<> es sólo valido para java 7 hacia arriba
	// just to point out that this shorthand  on line 28, is only available on java  7 and higher		
		
    Map<String, List<Song>> byArtist = new HashMap<>();
    for (Song song : mSongs) {
      List<Song> artistSongs = byArtist.get(song.getArtist());

/**** 	Nota importante!!  lo que hace este if, es que verifica en el Map, mediante el ingreso de la key del Map, tomada de una lista de canciones, verificando y asociando  en caso de encontrar al artista, a un lote de posibles canciones (o al menos una), sino encuentra el artista, es decir retorna un null en el if, crea de inmediato una lista tipo arreglo, que luego completa ingresando en el Map( que se llama byArtist en este codigo) asi qeda el nuevo mapa actualizado y devuelve entonces un mapa como fué indicado en el comienzo del desarrollo de esta función (un poco complejo pero funciona)  	****/	
/**** 	Important Note: this if statement, is checking using the keyMap, getting from a List of <Songs> if it is possible to find out the artist, if it so, it is gonna return the Map, no changes, but if is not, has to create a new list, and then has tu put on the map the artist and the artist song, and then returning the Map refreshed	****/	
  if (artistSongs == null) {
        artistSongs = new ArrayList<>();
        byArtist.put(song.getArtist(), artistSongs);
      }
      artistSongs.add(song);
    }
		
	
		// las lineas 33 a las 38, hacen en caso de que no exista el artista en la lista o arreglo, la creación de una nueva lista o areglo, y le agrega ese artista q no está ( esta un poco enredado, hay que ver si funciona
		// lines 33 to 38 shows how to create a new list or aarray in case of null is detected on if statement, maybe a litle confusing, but let see if it works.
    return byArtist;
  }
  
  public Set<String> getArtists() {
    return byArtist().keySet();
  }
  
  public List<Song> getSongsForArtist(String artistName) {
    return byArtist().get(artistName);
  }
  
}