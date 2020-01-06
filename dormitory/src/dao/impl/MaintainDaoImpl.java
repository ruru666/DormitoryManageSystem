package dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import bean.Maintain;
import bean.Student;
import dao.MaintainDao;
import util.MySessionFactory;

public class MaintainDaoImpl implements MaintainDao {



	@Override
	public void add(Maintain maintain) throws Exception {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = MySessionFactory.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		Transaction ts = null;
		try {
			ts = session.beginTransaction();
			session.save(maintain);
			Student s = new Student();
			s.setId(1);

			session.save(maintain);

			System.out.println(maintain);
			ts.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}

	}

	@Override
	public List<Maintain> FindAllByid(int sid) throws Exception {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory=MySessionFactory.getSessionFactory();
		Session session=sessionFactory.getCurrentSession();
		List<Maintain> list=new ArrayList<Maintain>();
		Transaction ts=null;
		try {
			ts=session.beginTransaction();
			String hql="from Maintain where s_id=?";
			
			Query q=session.createQuery(hql);
			q.setParameter(0, sid);
			list=q.list();
			for(Maintain maintain:list) {
				System.out.println(maintain.getAddress()+"..."+maintain.getInfo());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public static void main(String[] args) throws Exception {
		MaintainDao dao=new MaintainDaoImpl();
		List<Maintain> list=dao.FindAllByid(1);
	}

}
