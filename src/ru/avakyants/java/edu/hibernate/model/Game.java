package ru.avakyants.java.edu.hibernate.model;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="tmp_game")
public class Game {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private long id;
	
	@Column(name="name", nullable = false)
	private String name;
	
	@ManyToOne
	@JoinColumn(name="tournament")
	private Tournament tournament;
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Tournament getTournament() {
		return this.tournament;
	}
	
	public void setTournament(Tournament tournament) {
		this.tournament = tournament;
	}

}
