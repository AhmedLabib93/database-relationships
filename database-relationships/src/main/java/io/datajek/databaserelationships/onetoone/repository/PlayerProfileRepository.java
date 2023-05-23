package io.datajek.databaserelationships.onetoone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.datajek.databaserelationships.onetoone.PlayerProfile;

@Repository
public interface PlayerProfileRepository extends JpaRepository<PlayerProfile, Integer> {

}
