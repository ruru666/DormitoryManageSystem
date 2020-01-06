package action;

import java.util.List;

import ServiceImpl.BuildingAdminServiceImpl;
import bean.Student;
import service.BuildingAdminService;

public class MyStudentListAction {
	
	private List<Student> list;
	private BuildingAdminService buildingAdminService = new BuildingAdminServiceImpl();
	private String bid;//和mystudentjsp中跳转页面传的bid保持一致
	
	
	public String execute() {
		list = buildingAdminService.selectStuByBudId(bid);
		return "mylist";
	}


	public List<Student> getList() {
		return list;
	}


	public void setList(List<Student> list) {
		this.list = list;
	}


	public BuildingAdminService getBuildingAdminService() {
		return buildingAdminService;
	}


	public void setBuildingAdminService(BuildingAdminService buildingAdminService) {
		this.buildingAdminService = buildingAdminService;
	}


	public String getBid() {
		return bid;
	}


	public void setBid(String bid) {
		this.bid = bid;
	}
	
}
