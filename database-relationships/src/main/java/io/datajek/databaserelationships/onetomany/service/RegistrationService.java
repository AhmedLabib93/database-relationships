package io.datajek.databaserelationships.onetomany.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.datajek.databaserelationships.onetomany.Registration;
import io.datajek.databaserelationships.onetomany.repository.RegistrationRepository;
import io.datajek.databaserelationships.onetoone.Player;
import jakarta.persistence.ManyToOne;

@Service
public class RegistrationService {
	
	@Autowired
	RegistrationRepository repo;
	
	public List<Registration> allRegistrations() {
		return repo.findAll();	    
	}

	public Registration getRegistration(int id){
		return repo.findById(id).get();
	}
	
    public Registration addRegistration(Registration registration) {
    	registration.setId(0);
		return repo.save(registration);
	}
    	
 	public void deleteRegistration(int id) {
		repo.deleteById(id);
	}
 	
}
