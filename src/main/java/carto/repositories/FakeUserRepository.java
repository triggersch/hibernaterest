package carto.repositories;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import carto.config.HibernateUtil;
import carto.entities.User;

public class FakeUserRepository {
	
	private List<User> users = new ArrayList<>();
	
	SessionFactory sessionFactory = HibernateUtil.getSessionFactory(); 
	
	public FakeUserRepository() {
		this.users.add(new User(22l, "l877DF", "sohaib1") );
		this.users.add(new User(288l, "lfdkfgDF", "sohaib2") );
		this.users.add(new User(598l, "dfdkfldjf", "sohaib3") );
	}
	
	public List<User> getFakeUsers(){
		return this.users;
	}
	
	public List<User> getUsers(){
		Session session = sessionFactory.openSession();
		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		CriteriaQuery<User> criteria = criteriaBuilder.createQuery(User.class);
		Root<User> root = criteria.from(User.class);
		criteria.select(root);
		
        Query query = session.createQuery(criteria);
        
		List<User > allusers = query.getResultList();
	
		//sessionFactory.close();
		return allusers;
	}
	
	public User addRandomUser(){
		Session session = sessionFactory.openSession();
		
		Transaction transaction = session.beginTransaction();
		User user = new User("das" + Math.random(), "sohaib"+ Math.random());
		try{
			session.persist(user);
			transaction.commit();
			
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
		//sessionFactory.close();
		//HibernateUtil.shutdown();
		return user;
		
	}

}
