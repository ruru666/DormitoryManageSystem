package service;

import java.util.List;

import bean.LeaveSchool;

public interface LeaveSchoolService {
	public List<LeaveSchool> FindAll()throws Exception;
	public void upd(LeaveSchool l)throws Exception;

}
