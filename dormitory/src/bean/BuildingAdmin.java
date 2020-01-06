package bean;


import java.util.HashSet;
import java.util.Set;

public class BuildingAdmin {
	private int id;
	private String b_uname;
	private String b_name;
	private String b_pwd;
	private String b_tel;
	private String b_sex;
	//一个楼宇管理员管多个学生
	private Set<Student> student = new HashSet<Student>();
	
	

	public Set<Student> getStudent() {
		return student;
	}
	public void setStudent(Set<Student> student) {
		this.student = student;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getB_uname() {
		return b_uname;
	}
	public void setB_uname(String b_uname) {
		this.b_uname = b_uname;
	}
	public String getB_name() {
		return b_name;
	}
	public void setB_name(String b_name) {
		this.b_name = b_name;
	}
	public String getB_pwd() {
		return b_pwd;
	}
	public void setB_pwd(String b_pwd) {
		this.b_pwd = b_pwd;
	}
	public String getB_tel() {
		return b_tel;
	}
	public void setB_tel(String b_tel) {
		this.b_tel = b_tel;
	}
	public String getB_sex() {
		return b_sex;
	}
	public void setB_sex(String b_sex) {
		this.b_sex = b_sex;
	}
	
}
