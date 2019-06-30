package com.clementd.Music.services;


import com.clementd.Music.model.Track;
import com.clementd.Music.model.TrackDto;
import org.apache.catalina.filters.ExpiresFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping
@CrossOrigin
public class TrackController {

    // TODO add playlist field in the formData to automatically compile all tracks in the request (for multi files) to the specifiec playlist

    private static final Logger logger = LoggerFactory.getLogger(TrackController.class);


    @Autowired
    private DBFileStorageService dbFileStorageService;

    // TODO add a file type check to only accept audio files

    @PostMapping("/uploadFile")
    public TrackDto uploadFile(@RequestParam("file") MultipartFile file) {
        // store the file
        Track track = dbFileStorageService.storeFile(file);

        // set up access link from the db
        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/downloadFile/")
                .path(Long.toString(track.getId()))
                .toUriString();


        return new TrackDto(track.getFileName(), fileDownloadUri,
                file.getContentType(), file.getSize());
    }

    @PostMapping("/uploadMultipleFiles")
    public List<TrackDto> uploadMultipleFiles(@RequestParam("files") MultipartFile[] files) {
        return Arrays.asList(files)
                .stream()
                .map(file -> uploadFile(file))
                .collect(Collectors.toList());
    }

    // id will display in the playlist table
    @GetMapping("/downloadFile/{id}")
    public ResponseEntity<Resource> downloadFile(@PathVariable Long id) {
        // Load file from database
        Track track = dbFileStorageService.getFile(id);

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(track.getFileType()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + track.getFileName() + "\"")
                .body(new ByteArrayResource(track.getData()));
    }



}
