package io.datajek.databaserelationships.onetoone.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.datajek.databaserelationships.onetoone.PlayerProfile;
import io.datajek.databaserelationships.onetoone.repository.PlayerProfileRepository;

@Service
public class PlayerProfileService {

	@Autowired
	PlayerProfileRepository repo;

	public List<PlayerProfile> allPlayerProfiles() {
		return repo.findAll();
	}

	public PlayerProfile getPlayerProfile(int id) {
		return repo.findById(id).get();
	}

	public PlayerProfile addPlayerProfile(PlayerProfile profile) {
		profile.setId(0);
		if(profile.getPlayer()!=null) {
			profile.getPlayer().setProfile(profile);	
		}	
		return repo.save(profile);
	}

	public void deletePlayerProfile(int id) {
		PlayerProfile tempPlayerProfile = repo.findById(id).get(); 
		tempPlayerProfile.getPlayer().setProfile(tempPlayerProfile);
		tempPlayerProfile.setPlayer(null);
		repo.save(tempPlayerProfile);
		repo.delete(tempPlayerProfile); 
	}
}
