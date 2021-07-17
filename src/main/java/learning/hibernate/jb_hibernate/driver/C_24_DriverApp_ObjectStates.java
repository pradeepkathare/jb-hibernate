package learning.hibernate.jb_hibernate.driver;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import learning.hibernate.jb_hibernate.dto.objectstates.UserDetails;


public class C_24_DriverApp_ObjectStates {

	public static void main(String[] args) {
		
		SessionFactory sessionFactory = null;
		Session session = null;
		
		try {
			
			sessionFactory = new Configuration().configure().buildSessionFactory();
			session = sessionFactory.openSession();
			session.beginTransaction();
			
			for(int i=1;i<=10;i++) {
				UserDetails user = new UserDetails();
				user.setName("User "+i);
				session.save(user); //create/save
			}
			
			UserDetails user = session.get(UserDetails.class, 1); //select/reterive
			System.out.println("user="+user.toString());
			//user.setAddress("address buddy");
			
			session.update(user); // even if no change in state,blindly it will execute.to avoid this use selectBefore update annot
			session.getTransaction().commit();
			
			
		}catch(Exception e) {
			System.out.println(e);
		}finally {
			session.close();
			sessionFactory.close();
		}
	}
	
	
}
