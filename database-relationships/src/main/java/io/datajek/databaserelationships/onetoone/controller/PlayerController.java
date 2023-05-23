package io.datajek.databaserelationships.onetoone.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.datajek.databaserelationships.onetomany.Registration;
import io.datajek.databaserelationships.onetomany.service.RegistrationService;
import io.datajek.databaserelationships.onetoone.Player;
import io.datajek.databaserelationships.onetoone.PlayerProfile;
import io.datajek.databaserelationships.onetoone.service.PlayerProfileService;
import io.datajek.databaserelationships.onetoone.service.PlayerService;

@RestController
@RequestMapping("/players")
public class PlayerController {

	@Autowired
	PlayerService service;

	@Autowired
	PlayerProfileService profileService;

	@Autowired
	RegistrationService registrationService;

	@GetMapping
	public List<Player> getPlayers() {
		return service.getAllPlayers();
	}

	@GetMapping("/{id}")
	public Player getPlayer(@PathVariable int id) {
		return service.getPlayer(id);
	}

	@PostMapping
	public Player addPlayer(@RequestBody Player player) {
		return service.addPlayer(player);
	}

	@DeleteMapping("/{id}")
	public void deletePlayer(int id) {
		service.deletePlayer(id);
	}

	@PutMapping("/{id}/profiles/{profile_id}")
	public Player assinDetail(@PathVariable int id, @PathVariable int profile_id) {
		PlayerProfile profile = profileService.getPlayerProfile(profile_id);
		return service.assignProfile(id, profile);
	}

	@PutMapping("/{id}/registrations/{registration_id}")
	public Player assignRegistration(@PathVariable int id, @PathVariable int registration_id) {
		Registration registration = registrationService.getRegistration(registration_id);
		return service.assignRegistration(id, registration);
	}

	@PutMapping("/{id}/remove_registrations/{registration_id}")
	public Player removeRegistration(@PathVariable int id, @PathVariable int registration_id) {
		Registration registration = registrationService.getRegistration(registration_id);
		return service.removeRegistration(id, registration);
	}
}
