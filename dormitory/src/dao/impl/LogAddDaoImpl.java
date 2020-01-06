package dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import bean.BuildingAdmin;
import bean.SleepRecords;
import bean.Student;
import dao.LogAddDao;
import util.MySessionFactory;

public class LogAddDaoImpl implements LogAddDao {

	@Override
	public Student updateLog(int student_ID) {
		SessionFactory sessionFactory = MySessionFactory.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		Transaction ts =  null;
		Student student = null;
		try {
			ts = session.beginTransaction();
			//创建query对象
			student =  (Student) session.createQuery("from Student where  id= ?").setParameter(0, student_ID).uniqueResult();
			//设置条件的值
			//调用方法得到结果
			 //System.out.println("111"+student.getB_uname());
		
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return student;
	}

	@Override
	public void add(SleepRecords sr) {
		SessionFactory sessionFactory = MySessionFactory.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		Transaction ts =  null;
		//Student student = null;
		try {
			ts = session.beginTransaction();
			//创建query对象
			Query query =   session.createQuery("update SleepRecords s set s.time=? , s.state=?  where s.id=? ")
					//.setParameter(0, sr.getUname())
					.setParameter(0, sr.getTime())
					//.setParameter(2, sr.getBuildingAdmin())
					.setParameter(1, sr.getState())
					//.setParameter(4, sr.getStu())
					.setParameter(2, sr.getId());
			//设置条件的值
			//调用方法得到结果
			 System.out.println("111"+sr.getState());
			query.executeUpdate();
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public List<SleepRecords> selectLogByBudId(String bid) {
		SessionFactory sessionFactory = MySessionFactory.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		Transaction ts =  null;
		List<SleepRecords> list = null;
		try {
			ts = session.beginTransaction();
			//创建query对象
			list = session.createQuery("from SleepRecords where b_id = ?").setParameter(0, bid).list();
			//设置条件的值
			//调用方法得到结果
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Student FindById(int id) {
		SessionFactory sessionFactory = MySessionFactory.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		Transaction ts =  null;
		Student student = new Student();
		student= null;
		try {
			ts = session.beginTransaction();
			//创建query对象
			student =   (Student) session.createQuery("from Student where id = ?").setParameter(0, id).uniqueResult();
					//.setParameter(0, sr.getUname())
					
			//设置条件的值
			//调用方法得到结果111
			 System.out.println("111111111111111111111"+student.getS_name());
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return student;
	}

	@Override
	public void addSr(SleepRecords sr) {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = MySessionFactory.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		Transaction ts =  null;
		try {
			ts = session.beginTransaction();
			session.save(sr);
			ts.commit();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			if(ts!=null)
				ts.rollback();
			e.printStackTrace();
		}
		
	}

	@Override
	public BuildingAdmin FindByBid(int id) {
		SessionFactory sessionFactory = MySessionFactory.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		Transaction ts =  null;
		BuildingAdmin b = new BuildingAdmin();
		b= null;
		try {
			ts = session.beginTransaction();
			//创建query对象
			b =   (BuildingAdmin) session.createQuery("from BuildingAdmin where id = ?").setParameter(0, id).uniqueResult();
					//.setParameter(0, sr.getUname())
					
			//设置条件的值
			//调用方法得到结果111
			 System.out.println("111111111111111111111"+b.getB_name());
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return b;
	}

}
