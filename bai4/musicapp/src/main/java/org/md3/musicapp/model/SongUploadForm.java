package org.md3.musicapp.model;

import org.springframework.web.multipart.MultipartFile;

import java.nio.charset.MalformedInputException;

public class SongUploadForm {
    private int id;
    private String title;
    private String artist;
    private String genre;
    private MultipartFile song;

    public SongUploadForm() {
    }

    public SongUploadForm(String title, String artist, String genre, MultipartFile song) {
        this.title = title;
        this.artist = artist;
        this.genre = genre;
        this.song = song;
    }

    public SongUploadForm(int id, String title, String artist, String genre, MultipartFile song) {
        this(title, artist, genre, song);
        this.id = id;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public MultipartFile getSong() {
        return song;
    }

    public void setSong(MultipartFile song) {
        this.song = song;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
