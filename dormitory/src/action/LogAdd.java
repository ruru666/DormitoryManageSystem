package action;

import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import ServiceImpl.LogAddServiceImpl;
import bean.BuildingAdmin;
import bean.SleepRecords;
import bean.Student;
import service.LogAddService;

public class LogAdd extends ActionSupport {
	private int Student_ID;
	private LogAddService logAddService = new LogAddServiceImpl();
	private Student student;
	private Date time = new Date();
    private String state;
    private BuildingAdmin buildingAdmin = new BuildingAdmin();
    private String s_name;
    private SleepRecords sr = new SleepRecords();
	
	
	
	@Override
	public String execute() throws Exception {
		//解决乱码，用于页面输出
		HttpServletResponse response=null;
		response=ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		//查找到学生表里的id
		student = logAddService.updateLog(Student_ID);
		System.out.println("sadsadasdad1111111111111111"+student.getS_dormitory());
	
		student = logAddService.FindById(Student_ID);
		System.out.println("这是前台的缺勤学生名字"+student.getS_name());
		sr.setStu(student);
		sr.setUname(student.getS_name());
		sr.setTime(time);
		System.out.println(time);
		int id = (int) ServletActionContext.getRequest().getSession().getAttribute("bid");
		System.out.println("管理员id"+id);
		buildingAdmin = logAddService.FindByBid(id);
		sr.setBuildingAdmin(buildingAdmin);
		sr.setState("缺勤");
		logAddService.addSr(sr);
		
		//跳转
		out.print("<script language='javascript'>alert('缺寝登记成功！');window.location='Index.jsp';</script>");
		out.flush();
		out.close();
		
		return null;
		
		
	}
	public SleepRecords getSr() {
		return sr;
	}
	public void setSr(SleepRecords sr) {
		this.sr = sr;
	}
	public BuildingAdmin getBuildingAdmin() {
		return buildingAdmin;
	}

	public void setBuildingAdmin(BuildingAdmin buildingAdmin) {
		this.buildingAdmin = buildingAdmin;
	}
	public int getStudent_ID() {
		return Student_ID;
	}
	public void setStudent_ID(int student_ID) {
		Student_ID = student_ID;
	}
	public LogAddService getLogAddService() {
		return logAddService;
	}
	public void setLogAddService(LogAddService logAddService) {
		this.logAddService = logAddService;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public String getS_name() {
		return s_name;
	}
	public void setS_name(String s_name) {
		this.s_name = s_name;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
}
