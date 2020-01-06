package bean;

public class Building {
	private int id;
	private String type;//楼宇类型
	private String num;//楼宇号
	private BuildingAdmin buildingAdmin;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public BuildingAdmin getBuildingAdmin() {
		return buildingAdmin;
	}
	public void setBuildingAdmin(BuildingAdmin buildingAdmin) {
		this.buildingAdmin = buildingAdmin;
	}
	
	
}
