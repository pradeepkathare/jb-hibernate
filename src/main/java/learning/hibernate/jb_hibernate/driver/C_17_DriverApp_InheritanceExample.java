package learning.hibernate.jb_hibernate.driver;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import learning.hibernate.jb_hibernate.dto.inheritance.FourWheeler;
import learning.hibernate.jb_hibernate.dto.inheritance.TwoWheeler;
import learning.hibernate.jb_hibernate.dto.inheritance.Vehicle;
/*
 * # DTYPE, id, name, handling, Sterring
'Vehicle_inheritance', '3', 'Vehicle', NULL, NULL
'TwoWheeler', '2', NULL, 'two wheeler has handler', NULL
'FourWheeler', '1', NULL, NULL, 'Four wheeler has steering'

 */

public class C_17_DriverApp_InheritanceExample {

	public static void main(String[] args) {
		
		SessionFactory sessionFactory = null;
		Session session = null;
		
		try {
			Vehicle vehicle = new Vehicle();
			TwoWheeler twoWheeler = new TwoWheeler();
			FourWheeler fourWheeler = new FourWheeler();
			
			vehicle.setName("Vehicle");
			twoWheeler.setHandling("two wheeler has handler");
			fourWheeler.setSterring("Four wheeler has steering");
			
			sessionFactory = new Configuration().configure().buildSessionFactory();
			session = sessionFactory.openSession();
			session.beginTransaction();
			
			session.save(fourWheeler);
			session.save(twoWheeler);
			session.save(vehicle);
			
			session.getTransaction().commit();
		}catch(Exception e) {
			System.out.println(e);
		}finally {
			session.close();
			sessionFactory.close();
		}
	}
}
