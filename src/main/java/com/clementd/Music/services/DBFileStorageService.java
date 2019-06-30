package com.clementd.Music.services;


import com.clementd.Music.model.Track;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.IOException;

/**
 * Contains methods to store and retrieve files to/from the database.
 */

@Service
@Transactional
public class DBFileStorageService {

    @Autowired
    private TrackDAO trackDAO;
    @Autowired
    private PlaylistDAO playlistDAO;

    public Track storeFile(MultipartFile file) {
        // Normalize file name
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        try {
            // Check if the file's name contains invalid characters
            if(fileName.contains("..")) {
                throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
            }
            // TODO deconcatenate string to get title and artist and featuring

            Track track = new Track(fileName, file.getContentType(), playlistDAO.getOne((long) 1) , file.getBytes());

            // save the track object in the table
            return trackDAO.save(track);
        } catch (IOException ex) {
            throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
        }
    }

    public Track getFile(Long fileId) {
        return trackDAO.findById(fileId)
                .orElseThrow(() -> new FileNotFoundException("File not found with id " + fileId));
    }



}
