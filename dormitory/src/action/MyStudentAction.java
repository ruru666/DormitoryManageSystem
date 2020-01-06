package action;

import com.opensymphony.xwork2.ActionSupport;

import ServiceImpl.BuildingAdminServiceImpl;
import bean.Building;
import service.BuildingAdminService;

public class MyStudentAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	
	private BuildingAdminService buildingAdminService = new BuildingAdminServiceImpl();
	private Building building;
	private int id;

	public BuildingAdminService getBuildingAdminService() {
		return buildingAdminService;
	}

	public void setBuildingAdminService(BuildingAdminService buildingAdminService) {
		this.buildingAdminService = buildingAdminService;
	}

	public Building getBuilding() {
		return building;
	}

	public void setBuilding(Building building) {
		this.building = building;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}
