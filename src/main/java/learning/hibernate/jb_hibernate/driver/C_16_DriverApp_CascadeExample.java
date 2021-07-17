package learning.hibernate.jb_hibernate.driver;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import learning.hibernate.jb_hibernate.dto.C_16_UserDetails_Cascade;
import learning.hibernate.jb_hibernate.dto.C_16_Vehicle_Cascade;

//comment-didnt able to reproduce as of nw ignore this example
/*
 * insert into user_details_notFound (userName, id) values (?, ?)
 * Hibernate: insert into vehicle_NotFound (name, user_id, id) values (?, ?, ?)
 */
public class C_16_DriverApp_CascadeExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SessionFactory sessionFactory = null;
		Session session = null;
		try {
			
			C_16_Vehicle_Cascade vehicle1 = new C_16_Vehicle_Cascade();
			C_16_Vehicle_Cascade vehicle2 = new C_16_Vehicle_Cascade();
			
			
			
			C_16_UserDetails_Cascade user = new C_16_UserDetails_Cascade();
			user.setUserName("pradeep");
			user.getVehicle().add(vehicle1);
			
			vehicle1.setName("vehicle 1");
			vehicle1.setUser(user);
			
			vehicle2.setName("vehicle2");
			
			//hibernate steps
			sessionFactory = new Configuration().configure().buildSessionFactory();
			session = sessionFactory.openSession();
			session.beginTransaction();
			session.persist(user);
			//if we didnt save vehicle  then it throws exception transient
			//session.save(vehicle1);
			//session.save(vehicle2);
			
			//user = session.get(C_16_UserDetails_Cascade.class, 43);
			System.out.println("ve");
			session.getTransaction().commit();
		}catch (Exception e) {
			// TODO: handle exception
		}finally {
			
			session.close();
			sessionFactory.close();
		}
	}

}
