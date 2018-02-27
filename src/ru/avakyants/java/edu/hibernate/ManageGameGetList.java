package ru.avakyants.java.edu.hibernate;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import ru.avakyants.java.edu.hibernate.model.Game;

public class ManageGameGetList {

	public static void main(String[] args) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session= factory.openSession();
		Transaction tx = session.beginTransaction();	
		
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Game> criteria = builder.createQuery(Game.class);
		//criteria.from(Game.class);
		Root<Game> rootGame = criteria.from(Game.class);
		//criteria.where(builder.gt(rootGame.get("id"), 1L));
		criteria.where(builder.equal(builder.lower(rootGame.get("name")), "cska - khimki"));
		
		List<Game> games = session.createQuery(criteria).getResultList();
		
		games.forEach((g)->{ g.setScoreHome((short)5); session.merge(g);});
		tx.commit();
		System.out.println(games.size());
		
		session.close();
		factory.close();
	}

}
