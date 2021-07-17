package learning.hibernate.jb_hibernate.driver;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import learning.hibernate.jb_hibernate.dto.Address_Embeddable_Annotation;
import learning.hibernate.jb_hibernate.dto.User_AttributeOverrides_Annotation;

/*
 * As of now,assume this as service layer
 * 
 * usecase : 2 address type fields,conflicts to create column only once.so use attribute-override to rename fields and
 * columns wll be created
 */
public class C_09_DriverApp {

	public static void main(String[] args) {
		
		//Step to create user object
		User_AttributeOverrides_Annotation user = new User_AttributeOverrides_Annotation();
		
		Address_Embeddable_Annotation homeAddress = new Address_Embeddable_Annotation();
		Address_Embeddable_Annotation officeAddress = new Address_Embeddable_Annotation();
		
		homeAddress.setArea("kalisipalya");
		homeAddress.setCity("Hospet");
		homeAddress.setPincode("583201");
		homeAddress.setState("karnataka");
		
		officeAddress.setArea("Pavan  office");
		officeAddress.setCity("bangalore");
		officeAddress.setPincode("583205");
		officeAddress.setState("karnataka");
		
		user.setUserName("First User");
		user.setHomeAddress(homeAddress);
		user.setOfficeAddress(officeAddress);
		
		
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
