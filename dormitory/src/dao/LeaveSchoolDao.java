package dao;

import java.util.List;

import bean.Building;
import bean.Dormitory;
import bean.LeaveSchool;

public interface LeaveSchoolDao {
	public List<LeaveSchool> FindAll()throws Exception;
	public void upd(LeaveSchool l)throws Exception;
}
