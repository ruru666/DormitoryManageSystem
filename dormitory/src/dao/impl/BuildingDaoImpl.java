package dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import bean.Building;
import bean.Student;
import dao.BuildingDao;
import util.MySessionFactory;

public class BuildingDaoImpl implements BuildingDao {

	@Override
	/*
	 * 查询所有楼宇
	 */
	public List<Building> FindAll() throws Exception {
		SessionFactory sessionFactory = MySessionFactory.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		List<Building> list = new ArrayList<Building>();
		list=null;
		Transaction ts =  null;
		try {
			ts = session.beginTransaction();
			String hql = "from Building";
			Query query = session.createQuery(hql);
		    list = query.list();
		    for(Building b:list){
		    	System.out.println(b.getType()+"~~~"+b.getNum());
		    }
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return list;
	}
	

/*
 * 修改
 */
public void Upd(Building b) throws Exception {
	SessionFactory sessionFactory = MySessionFactory.getSessionFactory();
	Session session = sessionFactory.getCurrentSession();
	Transaction ts = null;
	
   try {
	   ts = session.beginTransaction();
	   String hql = "update Building set num=?,type=? where id =?";
	   Query query = session.createQuery(hql);
	   query.setParameter(0,b.getNum());
	   query.setParameter(1,b.getType());
	   query.setParameter(2,b.getId());
	   System.out.println("dao层要修改的楼宇id:"+b.getId());
	   System.out.println("后台"+"楼宇号"+b.getNum());
	   System.out.println("后台"+"楼宇类型"+b.getType());
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
 *根据id删除
 */
public void Del(int id) throws Exception {
	SessionFactory sessionFactory = MySessionFactory.getSessionFactory();
	Session session = sessionFactory.getCurrentSession();
	Transaction ts = null;
	try {
		ts = session.beginTransaction();
		String hql = "delete from Building where id=?";
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
/*
 * 根据id找到楼宇实体
 */
public Building findById(int id) throws Exception {
	SessionFactory sessionFactory = MySessionFactory.getSessionFactory();
	Session session = sessionFactory.getCurrentSession();
	Transaction ts = null;
	Building b = new Building();
	b=null;
	try {
		ts = session.beginTransaction();
		String hql = "from Building where id = ?";
		b = (Building) session.createQuery(hql).setParameter(0, id).uniqueResult();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		if(ts!=null){
			ts.rollback();
		}
		e.printStackTrace();
	}
	System.out.println(b.getNum());
	return b;
}
/*
	模糊查询
*/
public List<Building> FindByName(String str) throws Exception {
	SessionFactory sessionFactory = MySessionFactory.getSessionFactory();
	Session session = sessionFactory.getCurrentSession();
	Transaction ts = null;
	List<Building> list = new ArrayList<Building>();
	list = null;
	try {
		ts = session.beginTransaction();
		String hql="from Building as b where b.num like '%"+str+"%'";
		Query query = session.createQuery(hql);
		 list = query.list();
		for(Building b : list){
			System.out.println(b.getNum()+"~~"+b.getType());
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
/*
 *添加
 */
public void Add(Building b) throws Exception {
	// TODO Auto-generated method stub
		SessionFactory sessionFactory = MySessionFactory.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		Transaction ts = null;
		try {
			ts = session.beginTransaction();
			session.save(b);
			ts.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
}
public static void main(String[] args) throws Exception {
	BuildingDao b = new BuildingDaoImpl();
	List<Building> list = b.FindAll();
	b.FindByName("1");
}
}
