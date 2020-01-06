package dao;


import java.util.List;

import bean.BuildingAdmin;
import bean.Student;

public interface StudentDao {
	public Student Login(String uname,String pwd) throws Exception;
	public List<Student> FindAll()throws Exception;
	public void Upd(Student s) throws Exception;
	public void Del(int id) throws Exception;
	public Student findById(int id)throws Exception;
	public List<Student> FindByName(String str)throws Exception;
	public void Add(Student s)throws Exception;
	public void Update(Student s) throws Exception;
	public Student findByUname(String uname)throws Exception;
	public Student FindAllBySid(int sid) throws Exception;
	public void UpdatePassword(int id, String s_pwd) throws Exception;
}
