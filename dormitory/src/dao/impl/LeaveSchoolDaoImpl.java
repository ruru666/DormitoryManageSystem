package dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import bean.LeaveSchool;
import bean.Student;
import dao.LeaveSchoolDao;
import util.MySessionFactory;

public class LeaveSchoolDaoImpl implements LeaveSchoolDao{

	/*
	 * 查询所有迁出记录
	 */
	public List<LeaveSchool> FindAll() throws Exception {
		SessionFactory sessionFactory = MySessionFactory.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		List<LeaveSchool> list = new ArrayList<LeaveSchool>();
		list=null;
		Transaction ts =  null;
		try {
			ts = session.beginTransaction();
			String hql = "from LeaveSchool";
			Query query = session.createQuery(hql);
		    list = query.list();
		    for(LeaveSchool l:list){
		    	System.out.println(l.getUname()+l.getStu().getS_name()+l.getState());
		    }
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return list;
	}
	/*
	 * 添加
	 */
	@Override
	public void upd(LeaveSchool l) throws Exception {
		SessionFactory sessionFactory = MySessionFactory.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		Transaction ts = null;
		try {
			ts = session.beginTransaction();
			session.save(l);
			ts.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void main(String[] args) throws Exception {
		LeaveSchoolDao l = new LeaveSchoolDaoImpl();
		l.FindAll();
	}
	
}
