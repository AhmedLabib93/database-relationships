package io.datajek.databaserelationships.onetoone;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToOne;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class PlayerProfile {

	@jakarta.persistence.Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;
	private String twitter;

	@OneToOne(mappedBy = "profile", cascade = CascadeType.ALL)
	private Player player;

	public PlayerProfile() {
		// TODO Auto-generated constructor stub
	}

	public PlayerProfile(int id, String twitter) {
		super();
		Id = id;
		this.twitter = twitter;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getTwitter() {
		return twitter;
	}

	public void setTwitter(String twitter) {
		this.twitter = twitter;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	@Override
	public String toString() {
		return "PlayerProfile [Id=" + Id + ", twitter=" + twitter + ", name=" + player.getName() + "]";
	}

}
