package com.clementd.Music.model;

public class TrackDto {



    private Long id;
    private String songName;
    private String artist;
    private String[] featuring ;
    private String playlistName;

    // all entities must have an empty constructor
    public TrackDto() {}

    // constructor must be the same order as the original class
    public TrackDto(Track track) {

        this.id = track.getId();
        this.songName = track.getSongName();
        this.artist = track.getArtist();
        this.featuring = track.getFeaturing();
        this.playlistName = track.getPlaylistName();

    }


    /** only getters **/
    public Long getId() { return this.id; }
    public String getArtist() { return this.artist; }
    public String getSongName() { return  this.songName; }
    public String[] getFeaturing() { return this.featuring; }
    public String getPlaylist() { return this.playlistName; }




}
