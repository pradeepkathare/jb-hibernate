package learning.hibernate.jb_hibernate.driver;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import learning.hibernate.jb_hibernate.dto.criteriaApi.UserDetails;;

public class C_29_DriverApp_CriteriaApi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SessionFactory sessionFactory = null;
		Session session = null;
		try {
			sessionFactory = new Configuration().configure().buildSessionFactory();
			session = sessionFactory.openSession();
			session.beginTransaction();
			Criteria criteria = session.createCriteria(UserDetails.class);
			//criteria.add(Restrictions.eq("name", "user 1"));
			
			List<UserDetails> list = criteria.list();
			System.out.println("list = "+list);
			
			//class 30 : more restrictions
			Criteria criteria2 = session.createCriteria(UserDetails.class);
			criteria2.add(Restrictions.eq("name", "User 5"));
			list = criteria2.list();
			System.out.println("restrict only particular userName = "+list);
			
			Criteria criteria3 = session.createCriteria(UserDetails.class);
			criteria3.add(Restrictions.like("name", "User%"))
			         .add(Restrictions.between("id", 2, 5));
			list = criteria3.list();
			System.out.println("restrict only userName starts with user and between 2,5 = "+list);
			
			//class 
			
		}catch(Exception ex) {
			System.err.println(ex);
		}finally {
			//session.close();
			sessionFactory.close();
		}
	}

}
