package com.clementd.Music.services;


import com.clementd.Music.model.PlaylistDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/playlists")
@Transactional
@CrossOrigin
public class PlaylistController {


    //how to access the database ? Use a DAO
    @Autowired
    private PlaylistDAO playlistDAO;




    /** Get all playlists **/
    @GetMapping
    // list of DTO for every playlist that will point to a Playlist
    public List<PlaylistDto> findPlaylists() {

        // built-in method for finding all the playlists; get streamed then mapped to a new DTO which is collected in the list
        return playlistDAO.findAll()
                .stream()
                .map(PlaylistDto::new)
                .collect(Collectors.toList());
    }







}
