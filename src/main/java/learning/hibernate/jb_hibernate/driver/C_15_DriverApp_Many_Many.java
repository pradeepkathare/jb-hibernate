package learning.hibernate.jb_hibernate.driver;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import learning.hibernate.jb_hibernate.dto.UserDetails_Many_Many;
import learning.hibernate.jb_hibernate.dto.Vehicle_Many_Many;

public class C_15_DriverApp_Many_Many {

	static Logger log = LogManager.getLogger(C_15_DriverApp_Many_Many.class);
	public static void main(String[] args) {
		
		SessionFactory sessionFactory = null;
		Session session = null;
		
		try {
			
			UserDetails_Many_Many user = new UserDetails_Many_Many();
			Vehicle_Many_Many vehicle = new Vehicle_Many_Many();

			vehicle.setVehicleName("many-many");
			
			user.setName("pradeep");
			user.getVehicles().add(vehicle);
			
			vehicle.getUser().add(user);
			
			sessionFactory = new Configuration().configure().buildSessionFactory();
			session = sessionFactory.openSession();
			session.beginTransaction();
			session.save(user);
			session.save(vehicle);
			session.getTransaction().commit();
		}catch(Exception ex) {
			log.error("ex={}",ex);
		}finally {
			if(session != null) {
				session.close();
			}
			if(sessionFactory != null) {
				sessionFactory.close();
			}
		}
	}
}
