package it.betacom.model;

import org.hibernate.SessionFactory;

import it.betacom.entity.User;

//logica di business
public class UserService {

	private UserDao userDao;
	
	public UserService() {
		this.userDao = userDao;
	}
	
	public User getUserByUsername(String username) {
		return userDao.getUserByUsername(username);
	}
	
	public void loginAttemptFailed(User user) {
		user.setLogin_rimanenti(user.getLogin_rimanenti() -1);
		
		if (user.getLogin_rimanenti() == 0) {
			user.setStato('D'); //disabilita l'account dopo 3 tentativi
		}
		
		userDao.updateUser(user);
	}
	
	public void resetLogingAttempt(User user) {
		user.setLogin_rimanenti(3); //reimposta attempt a 3 dopo ingresso riuscito
		 userDao.updateUser(user);
	}
	
	
	public boolean isAccountDisabled(User user) {
		return user.getStato() == 'D';
	}
	
}
