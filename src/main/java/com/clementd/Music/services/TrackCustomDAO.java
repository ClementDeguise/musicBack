package com.clementd.Music.services;

import com.clementd.Music.model.Track;

import java.util.List;

public interface TrackCustomDAO {
    List<Track> findTracks();
}
