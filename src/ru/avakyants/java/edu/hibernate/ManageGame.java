package ru.avakyants.java.edu.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import ru.avakyants.java.edu.hibernate.model.Game;
import ru.avakyants.java.edu.hibernate.model.Tournament;

public class ManageGame {

	public static void main(String[] args) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		
		Transaction tx = session.beginTransaction();	
		
		Tournament tournament = new Tournament();
		tournament.setId(15);
		tournament.setTitle("NBA");
		session.merge(tournament);
		//tx.commit();		
		
		//session.persist(tournament);
		//tx = session.beginTransaction();
		
		Game g1 = new Game();
		g1.setName("CSKA - KHIMKI");
		g1.setTournament(tournament);
		g1.setScoreHome((short) 87);
		g1.setScoreVisitor((short)85);
		tournament.addGame(g1);
		session.merge(g1);
		
		Game g2 = new Game();
		g2.setName("KHIMKI - REAL");
		g2.setTournament(tournament);
		tournament.addGame(g2);
		session.merge(g2);
		
		Game g3 = new Game();
		g3.setName("KHIMKI - OLY");
		g3.setTournament(tournament);
		tournament.addGame(g3);
		session.merge(g3);
		
		
		//session.merge(tournament);
		
		//session.update(tournament);
		/*session.save(g1);
		session.save(g2);
		session.save(g3);*/
		tx.commit();
		session.close();		
		factory.close();
	}

}
