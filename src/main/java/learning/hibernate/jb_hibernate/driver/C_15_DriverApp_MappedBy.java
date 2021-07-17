package learning.hibernate.jb_hibernate.driver;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import learning.hibernate.jb_hibernate.dto.UserDetails_One_Many_Mappings_MappedBy;
import learning.hibernate.jb_hibernate.dto.Vehicle_Many_One_MappedBy;

public class C_15_DriverApp_MappedBy {

	
	static Logger log = LogManager.getLogger(C_15_DriverApp_MappedBy.class);
	public static void main(String[] args) {
		 SessionFactory sessionFactory = null;
		 Session session = null;
		try {
			UserDetails_One_Many_Mappings_MappedBy userDetailsMappedBy =
					new UserDetails_One_Many_Mappings_MappedBy();
			List<Vehicle_Many_One_MappedBy> vehicleList = new ArrayList<Vehicle_Many_One_MappedBy>();
			Vehicle_Many_One_MappedBy vehicle_Many_One_MappedBy = new Vehicle_Many_One_MappedBy();
			
			vehicle_Many_One_MappedBy.setVehicleName("Mapped BY Example vehicle");
			vehicle_Many_One_MappedBy.setUserDetails_One_Many_Mappings(userDetailsMappedBy);
			
			vehicleList.add(vehicle_Many_One_MappedBy);
			
			userDetailsMappedBy.setUserName("mapped by example user");
			userDetailsMappedBy.setVehicle(vehicleList);
			
			//create sessionFactory
			 sessionFactory = new Configuration().configure().buildSessionFactory();
			 session = sessionFactory.openSession();
			 
			 session.beginTransaction();
			 
			 
			 session.save(userDetailsMappedBy);
			 session.save(vehicle_Many_One_MappedBy);
			 
			 session.getTransaction().commit();
			 
		}catch(Exception ex) {
			log.error("error={}",ex);
		}finally {
			
			if(session != null) {
				session.close();
			}if(sessionFactory != null) {
				sessionFactory.close();
			}
			
		}
		
		

	}

}
