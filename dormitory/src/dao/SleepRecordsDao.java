package dao;

import java.util.List;

import bean.SleepRecords;
import bean.Student;

public interface SleepRecordsDao {
	public List<SleepRecords> FindAll()throws Exception;
	public List<SleepRecords> FindByName(String str)throws Exception;
	 public List<SleepRecords> FindAllByid(int sid) throws Exception;
}
