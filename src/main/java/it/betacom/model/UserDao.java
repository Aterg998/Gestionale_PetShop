package it.betacom.model;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.hibernate.Session;

import it.betacom.entity.User;

//interagisce con il db x crud x user
public class UserDao {

	private SessionFactory sessionFactory;

	public UserDao(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public User getUserByUsername(String username) {
		try (Session session = sessionFactory.openSession()) {
			Query<User> query = session.createQuery("FROM utenti WHERE username = :username", User.class);
			query.setParameter("username", username);
			return query.uniqueResult();
		}
	}

	public void updateUser(User user) {
		try(Session session = sessionFactory.openSession()) {
			Transaction transaction = session.beginTransaction();
			session.update(user);;
			transaction.commit();
		}
	}
	

}
