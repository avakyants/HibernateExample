package ru.avakyants.java.edu.hibernate.model;

import javax.persistence.*;


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
	@JoinColumn(name="tournament", nullable = true)
	private Tournament tournament;
	
	@Column(name="score_home")
	private short scoreHome = 0;
	
	@Column(name="score_visitor")
	private short scoreVisitor = 0;
	
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

	public short getScoreHome() {
		return scoreHome;
	}

	public void setScoreHome(short scoreHome) {
		this.scoreHome = scoreHome;
	}

	public short getScoreVisitor() {
		return scoreVisitor;
	}

	public void setScoreVisitor(short scoreVisitor) {
		this.scoreVisitor = scoreVisitor;
	}

}
