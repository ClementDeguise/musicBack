package com.clementd.Music.services;

import com.clementd.Music.model.Track;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/** Data Access Object, interface provides access to retrieving, saving, updating data into the database with native methods
 * (findById, ...)  that generates the queries.
 *
 *  The entity manager is created within the H2 implementation. The DAO will handle commons methods thanks to the Spring Data Interface,
 *  and a custom DAO can be linked with custom methods to create queries using traditional Hibernate entity manager
 *
 *  The Spring Data JPA allows conventions to avoid creating custom queries.
 */
@Repository
public interface TrackDAO extends JpaRepository<Track, Long>, TrackCustomDAO {

}
