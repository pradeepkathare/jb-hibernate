package learning.hibernate.jb_hibernate.driver;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import learning.hibernate.jb_hibernate.dto.UserDetails;

/*
 * As of now,assume this as service layer
 */
public class C_03_DriverApp {

	public static void main(String[] args) {
		
		//Step to create user object
		UserDetails userDetails = new UserDetails();
		userDetails.setId(2);
		userDetails.setUserName("Second User");
		
		//Hibernate API steps 
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		//every request to db required to open one session and close as it finishes
		Session session = sessionFactory.openSession();
		
		session.beginTransaction();
		
		//save will save to local transaction but not to actual DB
		session.save(userDetails);
		
		//this is where code get save to DB or u should enable auto commit for DDl to save without transactions
		//comment out and check
		session.getTransaction().commit(); 
		session.close();
		
		 //in real time there will be one session factory object throught application(Singleton)
		//so u should not close session factory
		sessionFactory.close(); //will close complete connection to DB
	}
}
