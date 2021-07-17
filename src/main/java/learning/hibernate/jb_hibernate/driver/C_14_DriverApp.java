package learning.hibernate.jb_hibernate.driver;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import learning.hibernate.jb_hibernate.dto.UserDetails_One_Many_Mappings;
import learning.hibernate.jb_hibernate.dto.Vehicle;

public class C_14_DriverApp {

	static Logger logger = LogManager.getLogger(C_14_DriverApp.class);
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Session session = null;
		SessionFactory sessionFactory = null;
		try {
			//step 1 : create objects
			Vehicle vehicle = new Vehicle();
			UserDetails_One_Many_Mappings userDetails_Mappings = new UserDetails_One_Many_Mappings();
			
			vehicle.setVehicleName("BENEZ");
			userDetails_Mappings.getVehicle().add(vehicle);
			
			userDetails_Mappings.setUserName("kathare");
			//userDetails_Mappings.setVehicle();
			
			//create hibernate session from sessionfactory
			sessionFactory = new Configuration().configure().buildSessionFactory();
			session = sessionFactory.openSession();
			
			session.beginTransaction();
			session.save(vehicle);
			session.save(userDetails_Mappings);
			
			session.getTransaction().commit();
			
			sessionFactory.close();
			logger.debug("=======closed========");
		}catch(Exception ex) {
			logger.error("exception ex=",ex);
			if(session != null) {
				session.close();
				sessionFactory.close();
			}
		}
		
		
	}

}
