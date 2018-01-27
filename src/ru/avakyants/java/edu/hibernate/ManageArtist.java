package ru.avakyants.java.edu.hibernate;

import java.util.List;

import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import ru.avakyants.java.edu.hibernate.model.Artist;

public class ManageArtist {

	public static void main(String[] args) {
		
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		
		// INSERT OBJECT
		Transaction transaction = session.beginTransaction();		
		Artist a = new Artist();
		a.setName("2Pac");
		a.setGenre("rap");
		
		session.save(a);
		transaction.commit();
		System.out.println("Saved!");
		// INSERT OBJECT END
		
		
		//GET DATA BY OBJECT
		transaction = session.beginTransaction();
		CriteriaQuery<Artist> crq = session.getCriteriaBuilder().createQuery(Artist.class);
		crq.from(Artist.class);
		List<Artist> artistList = session.createQuery(crq).getResultList();
		
		for(Artist artist : artistList) {
			System.out.println("ID: "+artist.getId()+" NAME: "+artist.getName());
		}
		
		transaction.commit();
		System.out.println("Getted!");
		//GET DATA BY OBJECT END
		
		//EXECUTE SQL
		transaction = session.beginTransaction();
		Object res = session.createQuery("SELECT count(*) as cnt FROM Artist").getSingleResult();	
		System.out.println("Count: "+res.toString());
		transaction.commit();
		System.out.println("Executed query!");
		//EXECUTE SQL END
		
		session.close();		
		factory.close();
	}

}
