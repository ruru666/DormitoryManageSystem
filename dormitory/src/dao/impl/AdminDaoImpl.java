package dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import bean.Admin;
import dao.AdminDao;
import util.MySessionFactory;

public class AdminDaoImpl implements AdminDao {

	@Override
	public Admin Login(String uname, String pwd)throws Exception {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = MySessionFactory.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		Transaction ts =  null;
		Admin a = null;
		try {
			ts = session.beginTransaction();
			//创建query对象
			 a = (Admin) session.createQuery("from Admin where a_uname = ? and a_pwd = ?").setParameter(0, uname).setParameter(1, pwd).uniqueResult();
			//设置条件的值
			//调用方法得到结果
			 System.out.println("111"+a);
		
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return a;
	}
	/*
	 * 修改密码
	 */
	public void UpdPwd(Admin a) throws Exception {
		SessionFactory sessionFactory = MySessionFactory.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		Transaction ts = null;
		
	   try {
		   ts = session.beginTransaction();
		   String hql = "update Admin set a_pwd=? where id =?";
		   Query query = session.createQuery(hql);
		   query.setParameter(0,a.getA_pwd());
		   query.setParameter(1,a.getId());
		   System.out.println("dao层要修改的Admin的id:"+a.getId());
		   System.out.println("后台"+"密码"+a.getA_pwd());
		   
		   query.executeUpdate();
		   ts.commit();
	} catch (Exception e) {
		// TODO Auto-generated catch block
	   if(ts!=null){
			ts.rollback();
		}
		e.printStackTrace();
	}
		
		
	}
	public static void main(String[] args) throws Exception {
		AdminDao adminDao = new AdminDaoImpl();
		Admin a = new Admin();
	
	a.setId(1);
	a.setA_pwd("1234");
	adminDao.UpdPwd(a);
	
	System.out.println(a);
	}


}
