package learning.hibernate.jb_hibernate.driver;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import learning.hibernate.jb_hibernate.dto.User_MoreAnnotations;

/*
 * As of now,assume this as service layer
 * 
 *o/p for user_info table
 *1 Hospet	Hello GM!!	2021-05-14 09:39:54	 First UserFROM GETTER  
2	Hospet	Hello GM!!	2021-05-14 09:44:05	 User 2FROM GETTER  
3	Hospet	Hello GM!!	2021-05-14 09:49:37	 User 3 FROM GETTER  
4	Hospet		        2021-05-14 09:53:52	 User 4 FROM GETTER  
5	Hospet		        2021-05-14 00:00:00	 User 5 FROM GETTER  
				
 * 	
 */
public class C_05_DriverApp {

	public static void main(String[] args) {
		
		//Step to create user object
		User_MoreAnnotations user = new User_MoreAnnotations();
		user.setId(5);
		user.setUserName(" User "+user.getId());
		user.setAddress("Hospet");
		user.setDescription("Hello GM!!");
		user.setJoinedDate(new Date());
		
		//Hibernate API steps 
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		//every request to db required to open one session and close as it finishes
		Session session = sessionFactory.openSession();
		
		session.beginTransaction();
		
		//save will save to local transaction but not to actual DB
		session.save(user);
		
		//this is where code get save to DB or u should enable auto commit for DDl to save without transactions
		//comment out and check
		session.getTransaction().commit(); 
		session.close();
		
		 //in real time there will be one session factory object throught application(Singleton)
		//so u should not close session factory
		sessionFactory.close(); //will close complete connection to DB
	}
}
