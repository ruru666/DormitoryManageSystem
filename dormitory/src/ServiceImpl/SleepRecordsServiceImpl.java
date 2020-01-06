package ServiceImpl;

import java.util.List;

import bean.SleepRecords;
import dao.SleepRecordsDao;
import dao.impl.SleepRecordsDaoImpl;
import service.SleepRecordsService;

public class SleepRecordsServiceImpl implements SleepRecordsService{
	private SleepRecordsDao sleepRecordsDao = new SleepRecordsDaoImpl();

	@Override
	public List<SleepRecords> FindAll() throws Exception {
		// TODO Auto-generated method stub
		return sleepRecordsDao.FindAll();
	}

	public List<SleepRecords> FindByName(String str) throws Exception {
		// TODO Auto-generated method stub
		return sleepRecordsDao.FindByName(str);
	}

	@Override
	public List<SleepRecords> FindAllByid(int sid) throws Exception {
		// TODO Auto-generated method stub
	SleepRecordsDao sleepRecordsDao=new SleepRecordsDaoImpl();
		
		return sleepRecordsDao.FindAllByid(sid);
		
	}

}
