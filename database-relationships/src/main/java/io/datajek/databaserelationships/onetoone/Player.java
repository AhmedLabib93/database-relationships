package io.datajek.databaserelationships.onetoone;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import io.datajek.databaserelationships.onetomany.Registration;
import jakarta.persistence.*;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Player {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;
	private String name;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "profile_id", referencedColumnName = "id")
	private PlayerProfile profile;

	@OneToMany(mappedBy = "player", cascade = CascadeType.ALL)
	private List<Registration> registrations = new ArrayList<>();

	public Player() {
		// TODO Auto-generated constructor stub
	}

	public Player(int id, String name, PlayerProfile profile) {
		super();
		Id = id;
		this.name = name;
		this.profile = profile;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public PlayerProfile getProfile() {
		return profile;
	}

	public void setProfile(PlayerProfile profile) {
		this.profile = profile;
	}

	public List<Registration> getRegistrations() {
		return registrations;
	}

	public void setRegistrations(List<Registration> registrations) {
		this.registrations = registrations;
	}

	// set up bi-directional relationship with Registration class
	public void registerPlayer(Registration reg) {
		// add registration to the list
		registrations.add(reg);
		// set the player field in the registration
		reg.setPlayer(this);
	}

	public void removeRegistration(Registration reg) {
		if (registrations != null)
			registrations.remove(reg);
		// set the player field in the registration
		reg.setPlayer(null);
	}

	@Override
	public String toString() {
		return "Player [Id=" + Id + ", name=" + name + ", profile=" + profile + ", registrations=" + registrations
				+ "]";
	}

}
