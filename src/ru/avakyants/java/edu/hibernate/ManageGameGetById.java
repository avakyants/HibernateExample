package ru.avakyants.java.edu.hibernate;

import java.time.ZoneId;
import java.util.Set;

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
		
		Game game = session.get(Game.class, 31L);
		
		if(game!=null) {
			Set<String> zones = ZoneId.getAvailableZoneIds();
			ZoneId zone = ZoneId.of("Europe/London");
			System.out.println("ZID: "+zone);
			
			/*for(String z : zones) {
				System.out.println(z);
			}*/
			
			System.out.println(game.getDateTime());
			//game.setScoreHome((short)1);
			//game.setScoreVisitor((short)2);
		}else
			System.out.println("Object not found");
		tx.commit();
		session.close();
		factory.close();
	}

}
