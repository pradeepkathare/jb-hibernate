package learning.hibernate.jb_hibernate.driver;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import learning.hibernate.jb_hibernate.dto.crud.UserDetails;
public class C_21_DriverApp_Crud {

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
			
			user.setAddress("address");
			user.setName("updated used 1"); //since i didnt close the session,it should do auto update
			//session.update(user); // not required manual update
			user.setName("updated again 1");
			
			session.delete(user); 
			session.getTransaction().commit();
			
			user.setName("updated user 1-"); //didnt updated because ,it should be within transaction
			session.delete(user);//should be within transaction or else not deleted
		}catch(Exception e) {
			System.out.println(e);
		}finally {
			session.close();
			sessionFactory.close();
		}
	}
	
	
}
