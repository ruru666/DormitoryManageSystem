package service;

import java.util.List;

import bean.SleepRecords;

public interface SleepRecordsService {
	public List<SleepRecords> FindAll()throws Exception;
	public List<SleepRecords> FindByName(String str)throws Exception;
	 public List<SleepRecords> FindAllByid(int sid) throws Exception;

	
}
