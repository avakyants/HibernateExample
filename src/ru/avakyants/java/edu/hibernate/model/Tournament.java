package ru.avakyants.java.edu.hibernate.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name="tmp_tournament")
public class Tournament {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private String id;
	
	@Column(name="title")
	private String title;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "tournament")
	private List<Game> games = new ArrayList<>();
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public List<Game> getGames(){
		return games;
	}
	
	public void setGames(List<Game> games) {
		this.games = games;
	}
	
	public void addGame(Game game) {
		this.games.add(game);
	}
	
	public boolean removeGame(Game game) {
		return this.games.remove(game);
	}

}