package org.md3.musicapp.service;

import org.md3.musicapp.model.Song;

import java.util.List;

public interface SongDAOInterface {
    List<Song> getAllSongs();

    Song getSongById(int id);

    void addSong(Song song);
}
