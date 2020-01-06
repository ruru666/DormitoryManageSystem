package dao;

import bean.Admin;
import bean.BuildingAdmin;

public interface AdminDao {
	public Admin Login(String uname,String pwd) throws Exception;
	public void UpdPwd(Admin a) throws Exception;
}
