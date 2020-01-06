package ServiceImpl;

import java.util.List;

import bean.Building;
import bean.BuildingAdmin;
import bean.Student;
import dao.BuildingAdminDao;
import dao.impl.BuildingAdminDaoImpl;
import service.BuildingAdminService;

public class BuildingAdminServiceImpl implements BuildingAdminService {
	private BuildingAdminDao buildingAdminDao = new BuildingAdminDaoImpl();
	
	
	public BuildingAdmin Login(String uname, String pwd) throws Exception {
		// TODO Auto-generated method stub
		return buildingAdminDao.Login(uname, pwd);
	}

	@Override
	public List<BuildingAdmin> FindAll() throws Exception {
		// TODO Auto-generated method stub
		return buildingAdminDao.FindAll();
	}
//--

	@Override
	public void Upd(BuildingAdmin ba) throws Exception {
		buildingAdminDao.Upd(ba);
		
	}

	@Override
	public void Del(int id) throws Exception {
		// TODO Auto-generated method stub
		buildingAdminDao.Del(id);
	}

	@Override
	public BuildingAdmin findById(int id) throws Exception {
		// TODO Auto-generated method stub
		return buildingAdminDao.findById(id);
	}

	@Override
	public List<BuildingAdmin> FindByName(String str) throws Exception {
		// TODO Auto-generated method stub
		return buildingAdminDao.FindByName(str);
	}

	@Override
	public void Add(BuildingAdmin ba) throws Exception {
		// TODO Auto-generated method stub
		buildingAdminDao.Add(ba);
	}

	@Override
	public Building selectBuildName(int id) {
		return buildingAdminDao.selectBuildName(id);
	}

	@Override
	public List<Student> selectStuByBudId(String bid) {
		return buildingAdminDao.selectStuByBudId(bid);
	}

	@Override
	public void UpdPwd(BuildingAdmin b) {
		// TODO Auto-generated method stub
		buildingAdminDao.UpdPwd(b);
		
	}
	
}
