package learning.hibernate.jb_hibernate.driver;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import learning.hibernate.jb_hibernate.dto.Address_Embeddable_Annotation;
import learning.hibernate.jb_hibernate.dto.User_Embedded_Annotation;

/*
 * As of now,assume this as service layer
 * 
 *   primary key auto generator
 *   o/p : for class 8 one entity all fields
 *   Hibernate: 
    
    create table user_embedded_annotation (
        userId integer not null auto_increment,
        area varchar(255),
        city varchar(255),
        pincode varchar(255),
        state varchar(255),
        userName varchar(255),
        primary key (userId)
    )
Hibernate: 
    insert 
    into
        user_embedded_annotation
        (area, city, pincode, state, userName) 
    values
        (?, ?, ?, ?, ?)
 */
public class C_08_DriverApp {

	public static void main(String[] args) {
		
		//Step to create user object
		User_Embedded_Annotation user = new User_Embedded_Annotation();
		
		Address_Embeddable_Annotation address = new Address_Embeddable_Annotation();
		
		address.setArea("kalisipalya");
		address.setCity("Hospet");
		address.setPincode("583201");
		address.setState("karnataka");
		user.setUserName("First User");
		
		user.setAddress(address);
		
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
