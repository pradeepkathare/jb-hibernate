package learning.hibernate.jb_hibernate.driver;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import learning.hibernate.jb_hibernate.dto.UserDetails_One_One_Mappings;
import learning.hibernate.jb_hibernate.dto.Vehicle;

public class C_13_DriverApp {

	static Logger logger = LogManager.getLogger(C_13_DriverApp.class);
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Session session = null;
		SessionFactory sessionFactory = null;
		try {
			//step 1 : create objects
			Vehicle vehicle = new Vehicle();
			UserDetails_One_One_Mappings userDetails_Mappings = new UserDetails_One_One_Mappings();
			
			vehicle.setVehicleName("BMW");
			userDetails_Mappings.setUserName("kathare");
			userDetails_Mappings.setVehicle(vehicle);
			
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
			logger.error("exception ex={}",ex.getCause());
			if(session != null) {
				session.close();
				sessionFactory.close();
			}
		}
		
		
	}

}
