package service;

import java.util.List;

import bean.Building;
import bean.BuildingAdmin;
import bean.Student;

public interface BuildingAdminService {
	public BuildingAdmin Login(String uname,String pwd) throws Exception;
	public List<BuildingAdmin> FindAll()throws Exception;
	public void Upd(BuildingAdmin ba) throws Exception;
	public void Del(int id) throws Exception;
	public BuildingAdmin findById(int id)throws Exception;
	public List<BuildingAdmin> FindByName(String str)throws Exception;
	public void Add(BuildingAdmin ba)throws Exception;
	
	public Building selectBuildName(int id);

	public List<Student> selectStuByBudId(String bid);
	
	//修改密码
	public void UpdPwd(BuildingAdmin b);
}
