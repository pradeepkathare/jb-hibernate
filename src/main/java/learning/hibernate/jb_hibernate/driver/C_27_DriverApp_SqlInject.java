package learning.hibernate.jb_hibernate.driver;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import learning.hibernate.jb_hibernate.dto.sqlinjection.UserDetails;

public class C_27_DriverApp_SqlInject {

	public static void main(String[] args) {

		SessionFactory sessionFactory = null;
		Session session = null;

		try {

			sessionFactory = new Configuration().configure().buildSessionFactory();
			session = sessionFactory.openSession();
			session.beginTransaction();

			for (int i = 1; i <= 10; i++) {
				UserDetails user = new UserDetails();
				user.setName("User " + i);
				session.save(user); // create/save
			}

			// sql injection
			String query_sql_inject = "5 or 1=1"; // suppose this is coming from user-input,he can send this input
			// i,e he can fetch his record along with others example in aadharcard-details
			// and etc
			Query query = session.createQuery("from UserDetails where id=" + query_sql_inject);
			List<UserDetails> users = query.list();
			System.out.println("list sql-injection=" + users);

			//postioned parameter to avoid injection
			 query = session.createQuery("from UserDetails where id=?");
			 query.setString(0, query_sql_inject);
			users = query.list();
			System.out.println("list postion-param=" + users);
			
			//named parameter to avoid injection
			 query = session.createQuery("from UserDetails where id=:userId");
			 query.setString("userId", query_sql_inject);
			users = query.list();
			System.out.println("list named-param=" + users);
			
			
			//class 28 named queries and namedNativeQueries
			query = session.getNamedQuery("UserDetails.byId");
			query.setString(0, query_sql_inject);
			users = query.list();
			System.out.println("list by named-query=" + users);
			
			query = session.getNamedQuery("UserDetails.byNativeQuery");
			query.setString(0, query_sql_inject);
			users = query.list();
			System.out.println("list by native-query=" + users);
			
			session.getTransaction().commit();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			session.close();
			sessionFactory.close();
		}
	}

}
