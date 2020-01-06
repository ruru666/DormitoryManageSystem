package ServiceImpl;

import java.util.List;

import bean.LeaveSchool;
import dao.LeaveSchoolDao;
import dao.impl.LeaveSchoolDaoImpl;
import service.LeaveSchoolService;

public class LeaveSchoolServiceImpl implements LeaveSchoolService{
	private LeaveSchoolDao leaveSchool = new LeaveSchoolDaoImpl();

	@Override
	public List<LeaveSchool> FindAll() throws Exception {
		// TODO Auto-generated method stub
		return leaveSchool.FindAll();
	}

	@Override
	public void upd(LeaveSchool l) throws Exception {
		// TODO Auto-generated method stub
		leaveSchool.upd(l);
	}

}
