package dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import bean.Admin;
import bean.BuildingAdmin;
import bean.Student;
import dao.StudentDao;
import service.StudentService;
import util.MySessionFactory;

public  class StudentDaoImpl implements StudentDao {

	@Override
	/*
	 * 验证登录
	 */
	public Student Login(String uname, String pwd)throws Exception {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = MySessionFactory.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		Transaction ts =  null;
		Student s = null;
		try {
			ts = session.beginTransaction();
			//创建query对象
			 s = (Student)session.createQuery("from Student where s_uname=? and s_pwd=?").setParameter(0, uname).setParameter(1, pwd).uniqueResult();
			//设置条件的值
			//调用方法得到结果
			 System.out.println("111"+s);
		
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return s;
	}
	
/*
 * 查询所有学生
 */
	@Override
	public List<Student> FindAll() throws Exception {
		SessionFactory sessionFactory = MySessionFactory.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		List<Student> list = new ArrayList<Student>();
		list=null;
		Transaction ts =  null;
		try {
			ts = session.beginTransaction();
			String hql = "from Student";
			Query query = session.createQuery(hql);
		    list = query.list();
		    for(Student s:list){
		    	System.out.println(s.getS_uname()+"~~"+s.getS_name()+"~~~"+s.getS_building()+"~~"+s.getS_dormitory());
		    }
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return list;
	}


@Override/*
* 修改学生信息
*/
public void Upd(Student s) throws Exception {
	SessionFactory sessionFactory = MySessionFactory.getSessionFactory();
	Session session = sessionFactory.getCurrentSession();
	Transaction ts = null;
	
   try {
	   ts = session.beginTransaction();
	   String hql = "update Student set s_uname=?,s_name=?,s_sex=?,s_tel=? where id =?";
	   Query query = session.createQuery(hql);
	   query.setParameter(0,s.getS_uname());
	   query.setParameter(1,s.getS_name());
	   query.setParameter(2,s.getS_sex());
	   query.setParameter(3,s.getS_tel());
	   query.setParameter(4,s.getId());
	   System.out.println("dao层要修改的学生id:"+s.getId());
	   System.out.println("后台"+"学生用户名"+s.getS_uname());
	   System.out.println("后台"+"学生姓名"+s.getS_name());
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
  根据id删除学生信息
 */
public void Del(int id) throws Exception {
	SessionFactory sessionFactory = MySessionFactory.getSessionFactory();
	Session session = sessionFactory.getCurrentSession();
	Transaction ts = null;
	try {
		ts = session.beginTransaction();
		String hql = "delete from Student where id=?";
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
 *根据id查询学生实体
 */
public Student findById(int id) throws Exception {
	SessionFactory sessionFactory = MySessionFactory.getSessionFactory();
	Session session = sessionFactory.getCurrentSession();
	Transaction ts = null;
	Student s = new Student();
	s=null;
	try {
		ts = session.beginTransaction();
		String hql = "from Student where id = ?";
		s = (Student) session.createQuery(hql).setParameter(0, id).uniqueResult();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		if(ts!=null){
			ts.rollback();
		}
		e.printStackTrace();
	}
	System.out.println(s.getS_name());
	return s;
}

@Override
/*
 *模糊查询姓名
 */
public List<Student> FindByName(String str) throws Exception {
	SessionFactory sessionFactory = MySessionFactory.getSessionFactory();
	Session session = sessionFactory.getCurrentSession();
	Transaction ts = null;
	List<Student> list = new ArrayList<Student>();
	list = null;
	try {
		ts = session.beginTransaction();
		String hql="from Student as s where s.s_name like '%"+str+"%'";
		Query query = session.createQuery(hql);
		 list = query.list();
		for(Student s : list){
			System.out.println(s.getS_name()+"~~"+s.getS_dormitory()+"~~~~"+s.getS_tel());
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
 * 添加学生
 */
public void Add(Student s) throws Exception {
	// TODO Auto-generated method stub
	SessionFactory sessionFactory = MySessionFactory.getSessionFactory();
	Session session = sessionFactory.getCurrentSession();
	Transaction ts = null;
	try {
		ts = session.beginTransaction();
		session.save(s);
		ts.commit();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

//调换寝室
public void Update(Student s) throws Exception {
	SessionFactory sessionFactory = MySessionFactory.getSessionFactory();
	Session session = sessionFactory.getCurrentSession();
	Transaction ts = null;
	
   try {
	   ts = session.beginTransaction();
	   String hql = "update Student set s_building=?,s_dormitory=? where s_uname=?,";
	   Query query = session.createQuery(hql);
	   
	   query.setParameter(0,s.getS_building());
	   query.setParameter(1,s.getS_dormitory());
	   query.setParameter(2,s.getS_uname());;
	 
	   System.out.println("后台"+"学生用户名"+s.getS_uname());
	   System.out.println("后台"+"学生调换的宿舍号"+s.getS_dormitory());
	   System.out.println("后台"+"学生调换的楼号"+s.getS_building());
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
 * 根据学号查询学生实体
 */
@Override
public Student findByUname(String uname) throws Exception {
	SessionFactory sessionFactory = MySessionFactory.getSessionFactory();
	Session session = sessionFactory.getCurrentSession();
	Transaction ts = null;
	Student s = new Student();
	s=null;
	try {
		ts = session.beginTransaction();
		String hql = "from Student where s_uname = ?";
		s = (Student) session.createQuery(hql).setParameter(0, uname).uniqueResult();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		if(ts!=null){
			ts.rollback();
		}
		e.printStackTrace();
	}
	System.out.println(s.getS_name());
	return s;
}
//---
public static void main(String[] args) throws Exception {
	/*StudentDao d = new StudentDaoImpl();
	Student s = new Student();
	
	d.findByUname("171530311");*/
	StudentDao d = new StudentDaoImpl();
	Student s = new Student();
	
	d.UpdatePassword(1, "222");
}

@Override
//根据sid查找
public Student FindAllBySid(int sid) throws Exception {
	// TODO Auto-generated method stub
	SessionFactory sessionFactory = MySessionFactory.getSessionFactory();
	Session session = sessionFactory.getCurrentSession();
	Student s = new Student();
	s = null;
	Transaction ts = null;
	try {
		ts = session.beginTransaction();
		String hql = "from 	Student where id=?";
		s = (Student) session.createQuery(hql).setParameter(0, sid).uniqueResult();
		System.out.println(s.getId());
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();

	}

	return s;
	
}

@Override
public void UpdatePassword(int id, String s_pwd) throws Exception {
	// TODO Auto-generated method stub
	SessionFactory sessionFactory = MySessionFactory.getSessionFactory();
	Session session = sessionFactory.getCurrentSession();
	Transaction ts = null;
	try {
		ts = session.beginTransaction();
		String hql = "update Student set s_pwd=? where s_id=?";
		Query q = session.createQuery(hql);
		q.setParameter(0, s_pwd);
		q.setParameter(1, id);
		q.executeUpdate();
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





}
