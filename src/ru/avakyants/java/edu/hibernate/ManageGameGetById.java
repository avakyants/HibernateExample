package ru.avakyants.java.edu.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import ru.avakyants.java.edu.hibernate.HibernateUtil;
import ru.avakyants.java.edu.hibernate.model.*;

public class ManageGameGetById {

	public static void main(String[] args) {
		SessionFactory factory  = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		
		Game game = session.get(Game.class, 1L);
		
		if(game!=null)
			System.out.println(game.getName());
		else
			System.out.println("Object not found");
		
		session.close();
		factory.close();
	}

}
