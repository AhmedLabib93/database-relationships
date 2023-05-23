package io.datajek.databaserelationships.onetomany.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.datajek.databaserelationships.onetomany.Tournament;

@Repository
public interface TournamentRepository extends JpaRepository<Tournament, Integer>{

}
