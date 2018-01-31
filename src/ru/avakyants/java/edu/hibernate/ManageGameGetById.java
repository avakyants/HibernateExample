package ru.avakyants.java.edu.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import ru.avakyants.java.edu.hibernate.HibernateUtil;
import ru.avakyants.java.edu.hibernate.model.*;

public class ManageGameGetById {

	public static void main(String[] args) {
		SessionFactory factory  = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();	
		
		Game game = session.get(Game.class, 1L);
		
		if(game!=null) {
			System.out.println(game.getName());
			game.setScoreHome((short)1);
			game.setScoreVisitor((short)2);
		}else
			System.out.println("Object not found");
		tx.commit();
		session.close();
		factory.close();
	}

}
