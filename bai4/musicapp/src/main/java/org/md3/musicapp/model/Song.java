package org.md3.musicapp.model;

public class Song {
    private int id;
    private String title;
    private String artist;
    private String genre;
    private String songUrl;

    public Song() {
    }

    public Song(String title, String artist, String genre, String songUrl) {
        this.title = title;
        this.artist = artist;
        this.genre = genre;
        this.songUrl = songUrl;
        this.id = (int) (Math.random() * 10000);
    }

    public Song(int id, String title, String artist, String genre, String songUrl) {
        this(title, artist, genre, songUrl);
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

    public String getSongUrl() {
        return songUrl;
    }

    public void setSongUrl(String songUrl) {
        this.songUrl = songUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public int hashCode() {
        return id ^ title.hashCode() ^ artist.hashCode() ^ genre.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if( obj == this) {
            return true;
        }

        if(!(obj instanceof Song)) {
            return false;
        }
        Song other = (Song) obj;

        return title.equals(other.title) && artist.equals(other.artist) && genre.equals(other.genre);
    }
}
