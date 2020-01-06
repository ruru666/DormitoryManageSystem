package dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import bean.Building;
import bean.Dormitory;
import bean.Student;
import dao.DormitoryDao;
import util.MySessionFactory;

public class DormitoryDaoImpl implements DormitoryDao{

	@Override/*
	* 查询所有宿舍
	*/
	public List<Dormitory> FindAll() throws Exception {
		SessionFactory sessionFactory = MySessionFactory.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		List<Dormitory> list = new ArrayList<Dormitory>();
		list=null;
		Transaction ts =  null;
		try {
			ts = session.beginTransaction();
			String hql = "from Dormitory";
			Query query = session.createQuery(hql);
		    list = query.list();
		    for(Dormitory d:list){
		    	System.out.println(d.getNum()+"~~"+d.getType());
		    }
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return list;
	}

@Override
/*
 * 修改
 */
public void Upd(Dormitory d) throws Exception {
	SessionFactory sessionFactory = MySessionFactory.getSessionFactory();
	Session session = sessionFactory.getCurrentSession();
	Transaction ts = null;
	
   try {
	   ts = session.beginTransaction();
	   String hql = "update Dormitory set num=?,type=? where id =?";
	   Query query = session.createQuery(hql);
	   query.setParameter(0,d.getNum());
	   query.setParameter(1,d.getType());
	   query.setParameter(2,d.getId());
	   System.out.println("dao层要修改的楼宇id:"+d.getId());
	   System.out.println("后台"+"楼宇号"+d.getNum());
	   System.out.println("后台"+"楼宇类型"+d.getType());
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
@Override
/*
 * 删除
 */
public void Del(int id) throws Exception {
	SessionFactory sessionFactory = MySessionFactory.getSessionFactory();
	Session session = sessionFactory.getCurrentSession();
	Transaction ts = null;
	try {
		ts = session.beginTransaction();
		String hql = "delete from Dormitory where id=?";
		Query query = session.createQuery(hql);
		query.setParameter(0, id);
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
@Override
/*
 *根据id找到实体
 */
public Dormitory findById(int id) throws Exception {
	SessionFactory sessionFactory = MySessionFactory.getSessionFactory();
	Session session = sessionFactory.getCurrentSession();
	Transaction ts = null;
	Dormitory d = new Dormitory();
	d=null;
	try {
		ts = session.beginTransaction();
		String hql = "from Dormitory where id = ?";
		d = (Dormitory) session.createQuery(hql).setParameter(0, id).uniqueResult();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		if(ts!=null){
			ts.rollback();
		}
		e.printStackTrace();
	}
	System.out.println(d.getNum());
	return d;
}
/*
 * 模糊查询
 */
public List<Dormitory> FindByName(String str) throws Exception {
	SessionFactory sessionFactory = MySessionFactory.getSessionFactory();
	Session session = sessionFactory.getCurrentSession();
	Transaction ts = null;
	List<Dormitory> list = new ArrayList<Dormitory>();
	list = null;
	try {
		ts = session.beginTransaction();
		String hql="from Dormitory as d where d.num like '%"+str+"%'";
		Query query = session.createQuery(hql);
		 list = query.list();
		for(Dormitory d : list){
			System.out.println(d.getNum()+"~~"+d.getType());
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
@Override
/*
 * 添加
 */
public void Add(Dormitory d) throws Exception {
	SessionFactory sessionFactory = MySessionFactory.getSessionFactory();
	Session session = sessionFactory.getCurrentSession();
	Transaction ts = null;
	try {
		ts = session.beginTransaction();
		session.save(d);
		ts.commit();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	
}

public static void main(String[] args) throws Exception {
	DormitoryDao d = new DormitoryDaoImpl();
	Dormitory dd = new Dormitory();
	dd.setId(1);
	dd.setNum("16425");
	dd.setType("3");
	d.Upd(dd);
}
}
