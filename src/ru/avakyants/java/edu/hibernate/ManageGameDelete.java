package ru.avakyants.java.edu.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import ru.avakyants.java.edu.hibernate.model.Game;
import ru.avakyants.java.edu.hibernate.model.Tournament;

public class ManageGameDelete {

	public static void main(String[] args) {
		
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		
		Game game = session.get(Game.class, 22L);
		
		if(game!=null) {
			System.out.println("Game:"+game.getId()+" found");
			session.delete(game);
			System.out.println("Game:"+game.getId()+" deleted!");
		}
		
		Tournament t = session.get(Tournament.class, 15L);
		
		if(t!=null)
			session.delete(t);//удаляет каскадно и все игры
		
		tx.commit();
		session.close();
		factory.close();

	}

}
