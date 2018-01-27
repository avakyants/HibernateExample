package ru.avakyants.java.edu.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import ru.avakyants.java.edu.hibernate.model.Game;
import ru.avakyants.java.edu.hibernate.model.Tournament;

public class ManageGame {

	public static void main(String[] args) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		
		Tournament tournament = new Tournament();
		tournament.setTitle("Euroleague");
		
		Game g1 = new Game();
		g1.setName("CSKA - KHIMKI");
		g1.setTournament(tournament);
		tournament.addGame(g1);
		
		Game g2 = new Game();
		g2.setName("KHIMKI - REAL");
		g2.setTournament(tournament);
		tournament.addGame(g2);
		
		Game g3 = new Game();
		g3.setName("KHIMKI - OLY");
		g3.setTournament(tournament);
		tournament.addGame(g3);
		
		session.save(tournament);
		/*session.save(g1);
		session.save(g2);
		session.save(g3);*/
		
		session.close();		
		factory.close();
	}

}
