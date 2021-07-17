package learning.hibernate.jb_hibernate.driver;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import learning.hibernate.jb_hibernate.dto.hql.UserDetails;




public class C_25_DriverApp_Hql {

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
			
		Query query = session.createQuery("from UserDetails where id>5");
		List<UserDetails> users = query.list();
		session.getTransaction().commit();
		System.out.println("list="+users);
		
		//class 26 :
		 query = session.createQuery("select id from UserDetails where id>5");
		 List<UserDetails> users_limited = query.list();
		 System.out.println("only id="+users_limited);
		 
		 //class 26 b:
		 query = session.createQuery("select id from UserDetails");
		 query.setFirstResult(2);
		 query.setMaxResults(4);
		 List<UserDetails> users_pagination = query.list();
		 System.out.println("only id from 2 and limited only for 4="+users_pagination);
		 
		}catch(Exception e) {
			System.out.println(e);
		}finally {
			session.close();
			sessionFactory.close();
		}
	}
	
	
}
