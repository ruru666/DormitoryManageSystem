package bean;

public class Student {
	private int id;
	private String s_uname;
	private String s_name;
	private String s_pwd;
	private String s_tel;
	private String s_sex;
	private String s_building;//楼宇信息
	private String s_dormitory;//宿舍信息
	//学生被那一个楼宇管理员管
	private BuildingAdmin buildingAdmin;
	
	public String getS_uname() {
		return s_uname;
	}
	public void setS_uname(String s_uname) {
		this.s_uname = s_uname;
	}
	public BuildingAdmin getBuildingAdmin() {
		return buildingAdmin;
	}
	public void setBuildingAdmin(BuildingAdmin buildingAdmin) {
		this.buildingAdmin = buildingAdmin;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getS_name() {
		return s_name;
	}
	public void setS_name(String s_name) {
		this.s_name = s_name;
	}
	public String getS_pwd() {
		return s_pwd;
	}
	public void setS_pwd(String s_pwd) {
		this.s_pwd = s_pwd;
	}
	public String getS_tel() {
		return s_tel;
	}
	public void setS_tel(String s_tel) {
		this.s_tel = s_tel;
	}
	public String getS_sex() {
		return s_sex;
	}
	public void setS_sex(String s_sex) {
		this.s_sex = s_sex;
	}
	public String getS_building() {
		return s_building;
	}
	public void setS_building(String s_building) {
		this.s_building = s_building;
	}
	public String getS_dormitory() {
		return s_dormitory;
	}
	public void setS_dormitory(String s_dormitory) {
		this.s_dormitory = s_dormitory;
	}
	
}
