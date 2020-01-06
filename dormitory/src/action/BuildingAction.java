package action;

import java.util.ArrayList;
import java.util.List;

import ServiceImpl.BuildingSericeImpl;
import bean.Building;
import service.BuildingService;

public class BuildingAction extends BaseAction{
	private BuildingService buildingService = new BuildingSericeImpl();
	private List<Building> blist = new ArrayList<Building>();
	private Building building = new Building();
	private int bid;
	private String SearchKey;
	
	public String findByName() throws Exception{
		blist = buildingService.FindByName(SearchKey);
		System.out.println(SearchKey);
		return "BuildingList.jsp";
	}
	public String tolist() throws Exception{
		blist = buildingService.FindAll();
		return "BuildingList.jsp";
		
	}
	public String toupd() throws Exception {
		building = buildingService.findById(bid);
		System.out.println("前~~"+building.getNum());
		return "BuildingUpd.jsp";
	}
	public String del() throws Exception{
		buildingService.Del(bid);
		return "tolist";
	}
	public String upd() throws Exception{
		System.out.println("前台楼宇类型"+building.getType());
		System.out.println("前台楼宇号"+building.getNum());
		buildingService.Upd(building);
		return "tolist";
	}
	public String add() throws Exception{
	buildingService.Add(building);
	return "tolist";
	}
	
	//--
	public BuildingService getBuildingService() {
		return buildingService;
	}
	public void setBuildingService(BuildingService buildingService) {
		this.buildingService = buildingService;
	}
	public List<Building> getBlist() {
		return blist;
	}
	public void setBlist(List<Building> blist) {
		this.blist = blist;
	}

	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public Building getBuilding() {
		return building;
	}
	public void setBuilding(Building building) {
		this.building = building;
	}
	public String getSearchKey() {
		return SearchKey;
	}
	public void setSearchKey(String searchKey) {
		SearchKey = searchKey;
	}
	
	
}
