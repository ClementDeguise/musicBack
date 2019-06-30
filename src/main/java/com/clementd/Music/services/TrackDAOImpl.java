package com.clementd.Music.services;

import com.clementd.Music.model.Track;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class TrackDAOImpl implements TrackCustomDAO {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Track> findTracks() {
        String jpql = "select tr from Track where tr.artist = :value";
        return em.createQuery(jpql,Track.class)
                .setParameter("value","john")
                .getResultList();
    }
}
