package bean;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import util.MySessionFactory;

public class test {
	public static void main(String[] args) {
		SessionFactory sessionFactory = MySessionFactory.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		Transaction ts =  null;
		try {
			ts = session.beginTransaction();
		/*Admin a = new Admin();
		a.setA_name("zahngsan");
		a.setA_uname("171530311");
		a.setA_pwd("123");*/
			Maintain n = new Maintain();
			Student s = new Student();
			s.setS_name("刘一");
		/*	n.setStu(s);*/
			n.setStu(s);
			session.save(n);
			
		/*Query query = session.createQuery("from Bu");
		List<Admin> list = query.list();
		for( Admin s:list ){
			System.out.println(s.getA_name());
		}*/
		ts.commit();
		
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			if(ts!=null)
			{
				ts.rollback();
			}
			e.printStackTrace();
		}
	}
}
