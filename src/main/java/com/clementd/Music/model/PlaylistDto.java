package com.clementd.Music.model;

import java.util.Set;

public class PlaylistDto {


    private Long id;
    private String name;
    private String thumbnail;
    private Integer numberOfSongs;


    public PlaylistDto() {}

    public PlaylistDto(Playlist playlist) {

        this.id = playlist.getId();
        this.name = playlist.getName();
        this.thumbnail = playlist.getThumbnail();
        this.numberOfSongs = playlist.getNumberOfSongs();

    }


    public Long getId() { return this.id; }
    public String getName() { return this.name; }
    public Integer getNumberOfSongs() { return this.numberOfSongs; }
    public String getThumbnail() { return this.thumbnail; }
    //public Set<Track> getTracks() { return this.tracks; }

}
