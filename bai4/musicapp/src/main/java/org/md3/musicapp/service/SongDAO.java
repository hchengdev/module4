package org.md3.musicapp.service;

import org.md3.musicapp.model.Song;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SongDAO implements SongDAOInterface {
    private static final List<Song> songList;
    static {
        songList = new ArrayList<Song>();
        songList.add(new Song(1, "Poker Face", "Lady Gaga", "Pop", "https://dummyurl.com/1"));
        songList.add(new Song(2, "Shape of You", "Ed Sheeran", "Pop", "https://dummyurl.com/2"));
        songList.add(new Song(3, "Blinding Lights", "The Weeknd", "R&B", "https://dummyurl.com/3"));
        songList.add(new Song(4, "Bohemian Rhapsody", "Queen", "Rock", "https://dummyurl.com/4"));
        songList.add(new Song(5, "Rolling in the Deep", "Adele", "Pop", "https://dummyurl.com/5"));
    }

    @Override
    public List<Song> getAllSongs() {
        return songList;
    }

    @Override
    public Song getSongById(int id) {
        for (Song song : songList) {
            if (song.getId() == id) {
                return song;
            }
        }
        return null;
    }

    @Override
    public void addSong(Song song) {
        songList.add(song);
    }
}
