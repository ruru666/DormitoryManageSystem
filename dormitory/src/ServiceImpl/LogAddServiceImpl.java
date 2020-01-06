package ServiceImpl;

import java.util.List;

import bean.BuildingAdmin;
import bean.SleepRecords;
import bean.Student;
import dao.LogAddDao;
import dao.impl.LogAddDaoImpl;
import service.LogAddService;

public class LogAddServiceImpl implements LogAddService {
private LogAddDao logAddDao =  new LogAddDaoImpl();
	

	public LogAddDao getLogAddDao() {
		return logAddDao;
	}

	public void setLogAddDao(LogAddDao logAddDao) {
		this.logAddDao = logAddDao;
	}


	public Student updateLog(int student_ID) {
		return logAddDao.updateLog(student_ID);
	}

	@Override
	public void add(SleepRecords sr) {
		logAddDao.add(sr);
		
	}

	@Override
	public List<SleepRecords> selectLogByBudId(String bid) {
		return logAddDao.selectLogByBudId(bid);
	}



	public Student FindById(int id) {
		// TODO Auto-generated method stub
		return logAddDao.FindById(id);
	}

	@Override
	public void addSr(SleepRecords sr) {
		// TODO Auto-generated method stub
		logAddDao.addSr(sr);
	}

	@Override
	public BuildingAdmin FindByBid(int id) {
		// TODO Auto-generated method stub
		return logAddDao.FindByBid(id);
	}

}
