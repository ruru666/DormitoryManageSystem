package dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import bean.SleepRecords;
import bean.Student;
import dao.SleepRecordsDao;
import util.MySessionFactory;

public class SleepRecordsDaoImpl implements SleepRecordsDao{

	@Override
	public List<SleepRecords> FindAll() throws Exception {
		SessionFactory sessionFactory = MySessionFactory.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		List<SleepRecords> list = new ArrayList<SleepRecords>();
		list=null;
		Transaction ts =  null;
		try {
			ts = session.beginTransaction();
			String hql = "from SleepRecords";
			Query query = session.createQuery(hql);
		    list = query.list();
		    for(SleepRecords sr:list){
		    	System.out.println(sr.getUname()+sr.getState());
		    }
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return list;
	}
	/*
	 * 模糊查询
	 */
	public List<SleepRecords> FindByName(String str) throws Exception {
		SessionFactory sessionFactory = MySessionFactory.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		Transaction ts = null;
		List<SleepRecords> list = new ArrayList<SleepRecords>();
		list = null;
		try {
			ts = session.beginTransaction();
			String hql="from SleepRecords as s where s.stu.s_name like '%"+str+"%'";
			Query query = session.createQuery(hql);
			 list = query.list();
			for(SleepRecords s : list){
				System.out.println(s.getState()+s.getStu().getS_name());
			}
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			if(ts!=null){
				ts.rollback();
			}
			e.printStackTrace();
		}
		return list;
	}
	//--
	public static void main(String[] args) throws Exception {
		/*SleepRecords s = new SleepRecords();
		SleepRecordsDao d = new SleepRecordsDaoImpl();
		d.FindByName("一");*/
		SleepRecordsDao dao=new SleepRecordsDaoImpl();
		List<SleepRecords> list=dao.FindAllByid(2);
	}
	@Override
	//查找缺寝记录
	public List<SleepRecords> FindAllByid(int sid) throws Exception {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory=MySessionFactory.getSessionFactory();
		Session session=sessionFactory.getCurrentSession();
		List<SleepRecords> list=new ArrayList<SleepRecords>();
		Transaction ts=null;
		try {
			ts=session.beginTransaction();
			String hql="from SleepRecords where sid=?";
			
			Query q=session.createQuery(hql);
			q.setParameter(0, sid);
			list=q.list();
			for(SleepRecords sleepRecords :list) {
				System.out.println(sleepRecords.getUname()+"..."+sleepRecords.getTime());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
		
	}
	

}
