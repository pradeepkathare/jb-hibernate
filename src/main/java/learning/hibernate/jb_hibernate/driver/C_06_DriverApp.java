package learning.hibernate.jb_hibernate.driver;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import learning.hibernate.jb_hibernate.dto.User_MoreAnnotations;

/*
 * As of now,assume this as service layer,
 * 
 *o/p for user_info table
 *1 Hospet	Hello GM!!	2021-05-14 09:39:54	 First UserFROM GETTER  
2	Hospet	Hello GM!!	2021-05-14 09:44:05	 User 2FROM GETTER  
3	Hospet	Hello GM!!	2021-05-14 09:49:37	 User 3 FROM GETTER  
4	Hospet		        2021-05-14 09:53:52	 User 4 FROM GETTER  
5	Hospet		        2021-05-14 00:00:00	 User 5 FROM GETTER  
				
 * 	User_MoreAnnotations [userId=1, userName=First UserFROM GETTER 	, joinedDate=2021-05-14, address=Hospet, description=null]

 */
//Example : to get object from table
public class C_06_DriverApp {

	public static void main(String[] args) {
		
		int userId = 1;
		
		//Hibernate API steps 
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		//every request to db required to open one session and close as it finishes
		Session session = sessionFactory.openSession();
		
		//class name and primaryKey
		User_MoreAnnotations user = session.get(User_MoreAnnotations.class, userId);
		System.out.println(user.toString());

		 //in real time there will be one session factory object throught application(Singleton)
		//so u should not close session factory
		sessionFactory.close(); //will close complete connection to DB
	}
}
