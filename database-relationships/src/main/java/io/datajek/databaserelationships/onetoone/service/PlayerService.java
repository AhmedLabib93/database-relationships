package io.datajek.databaserelationships.onetoone.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.datajek.databaserelationships.onetomany.Registration;
import io.datajek.databaserelationships.onetoone.Player;
import io.datajek.databaserelationships.onetoone.PlayerProfile;
import io.datajek.databaserelationships.onetoone.repository.PlayerRepository;

@Service
public class PlayerService {

	@Autowired
	private PlayerRepository repo;

	public List<Player> getAllPlayers() {
		return repo.findAll();
	}

	public Player getPlayer(int id) {
		return repo.findById(id).get();
	}

	public Player addPlayer(Player player) {
		player.setId(0);
		if (player.getProfile() != null) {
			player.getProfile().setPlayer(player);
		}
		return repo.save(player);
	}

	public void deletePlayer(int id) {
		repo.deleteById(id);
	}

	public Player assignProfile(int id, PlayerProfile profile) {
		Player player = repo.findById(id).get();
		player.setProfile(profile);
		player.getProfile().setPlayer(player);
		return repo.save(player);
	}

	public Player assignRegistration(int id, Registration registration) {
		Player player = repo.findById(id).get();
		player.registerPlayer(registration);
		return repo.save(player);
	}

	public Player removeRegistration(int id, Registration registration) {
		Player player = repo.findById(id).get();
		player.removeRegistration(registration);
		return repo.save(player);
	}
}
