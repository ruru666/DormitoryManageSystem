package service;

import java.util.List;

import bean.BuildingAdmin;
import bean.SleepRecords;
import bean.Student;

public interface LogAddService {

	public Student updateLog(int student_ID);

	public void add(SleepRecords sr);

	public List<SleepRecords> selectLogByBudId(String bid);

	
	public Student FindById(int id);
	public void addSr(SleepRecords sr);
	public BuildingAdmin FindByBid(int id);

	

}
