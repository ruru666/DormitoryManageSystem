package dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import bean.Building;
import bean.BuildingAdmin;
import bean.Student;
import dao.BuildingAdminDao;
import util.MySessionFactory;

public  class BuildingAdminDaoImpl implements BuildingAdminDao{

	/*
	 * 
	 * 登录验证
	 */
	public  BuildingAdmin Login(String uname, String pwd)throws Exception {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = MySessionFactory.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		Transaction ts =  null;
		BuildingAdmin b = null;
		try {
			ts = session.beginTransaction();
			//创建query对象
			 b = (BuildingAdmin) session.createQuery("from BuildingAdmin where b_uname = ? and b_pwd = ?").setParameter(0, uname).setParameter(1, pwd).uniqueResult();
			//设置条件的值
			//调用方法得到结果
			 System.out.println("111"+b.getB_uname());
		
		
		} catch (Exception e) {  
			e.printStackTrace();
		}
		return b;
	}
	
	@Override
	/*
	 * 
	 * 查询所有楼宇管理员
	 */
	public List<BuildingAdmin> FindAll() throws Exception {
		SessionFactory sessionFactory = MySessionFactory.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		List<BuildingAdmin> list = new ArrayList<BuildingAdmin>();
		list=null;
		Transaction ts =  null;
		try {
			ts = session.beginTransaction();
			String hql = "from BuildingAdmin";
			Query query = session.createQuery(hql);
		    list = query.list();
		    for(BuildingAdmin b:list){
		    	System.out.println(b.getB_uname()+"~~"+b.getB_name()+"~~~"+b.getB_tel()+"~~"+b.getB_sex());
		    }
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return list;
	}
	
	
/*
 * (non-Javadoc)
 * 修改楼宇管理员的信息
 */
	@Override
	public void Upd(BuildingAdmin ba) throws Exception {
		SessionFactory sessionFactory = MySessionFactory.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		Transaction ts = null;
		
	   try {
		   ts = session.beginTransaction();
		   String hql = "update BuildingAdmin set b_uname=?,b_name=?,b_sex=?,b_tel=? where id =?";
		   Query query = session.createQuery(hql);
		   query.setParameter(0,ba.getB_uname());
		   query.setParameter(1,ba.getB_name());
		   query.setParameter(2,ba.getB_sex());
		   query.setParameter(3,ba.getB_tel());
		   query.setParameter(4,ba.getId());
		   System.out.println("dao层要修改的楼宇id:"+ba.getId());
		   System.out.println("后台"+"用户名"+ba.getB_uname());
		   System.out.println("后台"+"姓名"+ba.getB_name());
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
	 * 根据楼宇管理员 id删除用户
	 */
	@Override
	public void Del(int id) throws Exception {
		SessionFactory sessionFactory = MySessionFactory.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		Transaction ts = null;
		try {
			ts = session.beginTransaction();
			String hql = "delete from BuildingAdmin where id=?";
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
	 * 根据id查找到楼宇管理员的实体
	 */
	@Override
	public BuildingAdmin findById(int id) throws Exception {
		SessionFactory sessionFactory = MySessionFactory.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		Transaction ts = null;
		BuildingAdmin ba = new BuildingAdmin();
		ba=null;
		try {
			ts = session.beginTransaction();
			String hql = "from BuildingAdmin where id = ?";
			ba = (BuildingAdmin) session.createQuery(hql).setParameter(0, id).uniqueResult();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			if(ts!=null){
				ts.rollback();
			}
			e.printStackTrace();
		}
		/*System.out.println(ba.getB_name());*/
		return ba;
	}
	/*
	 * 模糊查询根据名字
	 */
	@Override
	public List<BuildingAdmin> FindByName(String str) throws Exception {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = MySessionFactory.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		Transaction ts = null;
		List<BuildingAdmin> list = new ArrayList<BuildingAdmin>();
		list = null;
		try {
			ts = session.beginTransaction();
			String hql="from BuildingAdmin as ba where ba.b_name like '%"+str+"%'";
			Query query = session.createQuery(hql);
			 list = query.list();
			for(BuildingAdmin b : list){
				System.out.println(b.getB_name()+"~~"+b.getB_sex()+"~~~~"+b.getB_tel());
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
	 * 添加楼宇管理员
	 */
	@Override
	public void Add(BuildingAdmin ba) throws Exception {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = MySessionFactory.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		Transaction ts = null;
		try {
			ts = session.beginTransaction();
			session.save(ba);
			ts.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
//---main
	public static void main(String[] args) throws Exception {
		BuildingAdminDao buildingAdminDao = new BuildingAdminDaoImpl();
		BuildingAdmin ba = new BuildingAdmin();
		ba.setB_name("123");
		ba.setB_uname("12");
		ba.setB_tel("150");
		ba.setB_pwd("123123");
		ba.setB_sex("nv");
		buildingAdminDao.Add(ba);
}
	//查询楼名字
	@Override
	public Building selectBuildName(int id) {
		SessionFactory sessionFactory = MySessionFactory.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		Transaction ts =  null;
		Building b = null;
		try {
			ts = session.beginTransaction();
			//创建query对象
			 b = (Building) session.createQuery("from Building where id = ?").setParameter(0, id).uniqueResult();
			//设置条件的值
			//调用方法得到结果
		} catch (Exception e) {
			e.printStackTrace();
		}
		return b;
	}

	//查询所属楼的学生
		@Override
		public List<Student> selectStuByBudId(String bid) {
			SessionFactory sessionFactory = MySessionFactory.getSessionFactory();
			Session session = sessionFactory.getCurrentSession();
			Transaction ts =  null;
			List<Student> list = null;
			try {
				ts = session.beginTransaction();
				//创建query对象
				list = session.createQuery("from Student where s_building = ?").setParameter(0, bid).list();
				//设置条件的值
				//调用方法得到结果
			} catch (Exception e) {
				e.printStackTrace();
			}
			return list;
		}

		@Override
		public void UpdPwd(BuildingAdmin b) {
			SessionFactory sessionFactory = MySessionFactory.getSessionFactory();
			Session session = sessionFactory.getCurrentSession();
			Transaction ts = null;
			
		   try {
			   ts = session.beginTransaction();
			   String hql = "update BuildingAdmin set b_pwd=? where id =?";
			   Query query = session.createQuery(hql);
			   query.setParameter(0,b.getB_pwd());
			   query.setParameter(1,b.getId());
			   System.out.println("dao层要修改的Admin的id:"+b.getId());
			   System.out.println("后台"+"密码"+b.getB_pwd());
			   
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

	}
