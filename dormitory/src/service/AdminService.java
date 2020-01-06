package service;

import bean.Admin;

public interface AdminService {
	public Admin Login(String uname,String pwd)throws Exception;
	public void UpdPwd(Admin a) throws Exception;
}
