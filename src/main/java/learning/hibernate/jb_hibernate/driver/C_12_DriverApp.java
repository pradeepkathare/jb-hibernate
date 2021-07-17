package learning.hibernate.jb_hibernate.driver;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import learning.hibernate.jb_hibernate.dto.Address_Embeddable_Annotation2;
import learning.hibernate.jb_hibernate.dto.User_Collections_Join_Example;

/*
 * As of now,assume this as service layer
 * 
 * usecase : Lzay and eager loading
 * 
 * 
 */
public class C_12_DriverApp {

	public static void main(String[] args) {
		
		//Step to create user object
		User_Collections_Join_Example user = new User_Collections_Join_Example();
		
		Address_Embeddable_Annotation2 homeAddress = new Address_Embeddable_Annotation2();
		Address_Embeddable_Annotation2 officeAddress = new Address_Embeddable_Annotation2();
		
		//user.setUserName("1111fdifkd");
		homeAddress.setArea("kalisipalya");
		homeAddress.setCity("Hospet");
		homeAddress.setPincode("583201");
		homeAddress.setState("karnataka");
		
		officeAddress.setArea("Pavan  office");
		officeAddress.setCity("bangalore");
		officeAddress.setPincode("583205");
		officeAddress.setState("karnataka");
		
		user.setUserName("First User");
		
		user.getAddress().add(homeAddress);
		user.getAddress().add(officeAddress);
		
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
		
		//get method by lazy default behaviour
		
		User_Collections_Join_Example user1 = session.get(User_Collections_Join_Example.class, 1);
		session.close();
		System.out.println("User_Collections_Join_Example={}"+user1.toString());
		System.out.println(user1.getAddress().size());
		
		
		 //in real time there will be one session factory object throught application(Singleton)
		//so u should not close session factory
		sessionFactory.close(); //will close complete connection to DB
	}
}
