package com.clementd.Music.model;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

/** We create a JPA entity class that will then be used by the program to create the according tables and fill them in the
 * database
 *
 * The entity manager is created within the H2 implementation. The DAO will handle commons methods thanks to the Spring Data Interface,
 * and a custom DAO can be linked with custom methods to create queries using traditional Hibernate entity manager
 *
 * The Spring Data JPA allows conventions to avoid creating custom queries
 *
 * The file's contents will be stored as a byte array in the database
 *
 * **/
@Entity
public class Track {

    @Id
    @GeneratedValue
    private Long id; // long on 64 bit, int on 32 bit

    private String title;

    @NotNull
    private String fileName;

    private String fileType;

    // Lob = Large Object
    @Lob
    private byte[] data;


    private String artist;

    private String[] featuring ;

    @ManyToOne(optional = false)
    private Playlist playlist;

    // all entities must have an empty constructor
    public Track() {}

    public Track(String fileName, String fileType, Playlist playlist, byte[] data) {
        this.fileName = fileName;
        this.fileType = fileType;
        this.playlist = playlist;
        this.data = data;
    }


    /** getters & setters **/
    public Long getId() { return this.id; }
    public void setId(Long id) { this.id = id; }

    public String getArtist() { return this.artist; }
    public void setArtist(String artist) { this.artist = artist; }

    public String getTitle() { return  this.title; }
    public void setTitle(String title) { this.title = title; }

    public String getFileName() { return  this.fileName; }
    public void setFileName(String fileName) { this.fileName = fileName; }

    public String getFileType() { return  this.fileType; }
    public void setFileType(String fileType) { this.fileType = fileType; }

    public String[] getFeaturing() { return this.featuring; }
    public void setFeaturing(String[] featuring) { this.featuring = featuring; }

    public Long getPlaylistId() { return playlist.getId(); }
    public void setPlaylist(Playlist playlist) { this.playlist = playlist; }

    public String getPlaylistName() { return playlist.getName(); }

    public byte[] getData() { return this.data; }
    public void setData(byte[] data) { this.data = data; }

}
