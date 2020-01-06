package ServiceImpl;

import java.util.List;

import bean.Building;
import dao.BuildingDao;
import dao.impl.BuildingDaoImpl;
import service.BuildingService;

public class BuildingSericeImpl implements BuildingService{
private BuildingDao buildingDao = new BuildingDaoImpl();

	public List<Building> FindAll() throws Exception {
		// TODO Auto-generated method stub
		return buildingDao.FindAll();
	}

	@Override
	public void Upd(Building b) throws Exception {
		// TODO Auto-generated method stub
		buildingDao.Upd(b);
	}

	@Override
	public void Del(int id) throws Exception {
		// TODO Auto-generated method stub
		buildingDao.Del(id);
	}

	@Override
	public Building findById(int id) throws Exception {
		// TODO Auto-generated method stub
		return buildingDao.findById(id);
	}

	@Override
	public List<Building> FindByName(String str) throws Exception {
		// TODO Auto-generated method stub
		return buildingDao.FindByName(str);
	}

	@Override
	public void Add(Building b) throws Exception {
		// TODO Auto-generated method stub
		buildingDao.Add(b);
	}

}
