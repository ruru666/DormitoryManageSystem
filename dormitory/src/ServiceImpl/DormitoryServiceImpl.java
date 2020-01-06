package ServiceImpl;

import java.util.List;

import bean.Dormitory;
import dao.DormitoryDao;
import dao.impl.DormitoryDaoImpl;
import service.DormitoryService;

public class DormitoryServiceImpl implements DormitoryService{
	private DormitoryDao dormitoryDao = new DormitoryDaoImpl();

	@Override
	public List<Dormitory> FindAll() throws Exception {
		// TODO Auto-generated method stub
		return dormitoryDao.FindAll();
	}

	@Override
	public void Upd(Dormitory d) throws Exception {
		// TODO Auto-generated method stub
		dormitoryDao.Upd(d);
	}

	@Override
	public void Del(int id) throws Exception {
		// TODO Auto-generated method stub
		dormitoryDao.Del(id);
	}

	@Override
	public Dormitory findById(int id) throws Exception {
		// TODO Auto-generated method stub
		return dormitoryDao.findById(id);
	}

	@Override
	public List<Dormitory> FindByName(String str) throws Exception {
		// TODO Auto-generated method stub
		return dormitoryDao.FindByName(str);
	}

	@Override
	public void Add(Dormitory d) throws Exception {
		// TODO Auto-generated method stub
		dormitoryDao.Add(d);
	}

}
