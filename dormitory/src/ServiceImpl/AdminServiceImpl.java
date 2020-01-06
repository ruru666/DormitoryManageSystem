package ServiceImpl;

import bean.Admin;
import dao.AdminDao;
import dao.impl.AdminDaoImpl;
import service.AdminService;

public class AdminServiceImpl implements AdminService {
private AdminDao adminDao=new AdminDaoImpl();
	@Override
	public Admin Login(String uname, String pwd) throws Exception {
		// TODO Auto-generated method stub
		return adminDao.Login(uname, pwd);
	}
	@Override
	public void UpdPwd(Admin a) throws Exception {
		// TODO Auto-generated method stub
		adminDao.UpdPwd(a);
	}

}
