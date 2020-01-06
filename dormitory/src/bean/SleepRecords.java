package bean;

import java.util.Date;

public class SleepRecords {
	private int id;
	private Student stu;
	private String uname;//学生的用户名。
	private BuildingAdmin buildingAdmin;
	private Date time;//查寝时间
	private  String state;//是否缺寝
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Student getStu() {
		return stu;
	}
	public void setStu(Student stu) {
		this.stu = stu;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public BuildingAdmin getBuildingAdmin() {
		return buildingAdmin;
	}
	public void setBuildingAdmin(BuildingAdmin buildingAdmin) {
		this.buildingAdmin = buildingAdmin;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	
	
}
