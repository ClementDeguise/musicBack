package com.clementd.Music.model;

import javax.persistence.*;
import java.util.*;
import javax.validation.constraints.NotNull;

/** We create a JPA entity class that will then be used by the program to create the according tables and fill them in the
 * database
 * **/
@Entity
public class Playlist {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    private String name;
    private String thumbnail;
    private Integer numberOfSongs;

    @OneToMany(mappedBy = "playlist")
    private Set<Track> tracks;

    public Playlist() {}

    public Playlist(Long id, String name, Integer numberOfSongs, String thumbnail) {
        this.id = id;
        this.name = name;
        this.numberOfSongs = numberOfSongs;
        this.thumbnail = thumbnail;
    }


    public Long getId() { return this.id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return this.name; }
    public void setName(String name) { this.name = name; }

    public Integer getNumberOfSongs() { return this.numberOfSongs; }
    public void setNumberOfSongs(Integer numberOfSongs) { this.numberOfSongs = numberOfSongs; }


    public String getThumbnail() { return this.thumbnail; }
    public void setThumbnail(String thumbnail) { this.thumbnail = thumbnail; }





}
