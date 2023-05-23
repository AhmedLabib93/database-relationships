package io.datajek.databaserelationships.onetomany.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.datajek.databaserelationships.onetomany.Registration;

@Repository
public interface RegistrationRepository extends JpaRepository<Registration, Integer> {

}
