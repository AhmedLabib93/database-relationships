package io.datajek.databaserelationships.onetomany;

import java.util.Date;

import io.datajek.databaserelationships.onetoone.Player;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Registration {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH })
	@JoinColumn(name = "player_id", referencedColumnName = "id")
	private Player player;

	public Registration() {
		// TODO Auto-generated constructor stub 
	}

	public Registration(int id, Player player) {
		super();
		this.id = id;
		this.player = player;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	@Override
	public String toString() {
		return "Registration [id=" + id + ", player=" + player + "]";
	}

}
