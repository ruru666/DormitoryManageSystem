package action;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import ServiceImpl.LeaveSchoolServiceImpl;
import ServiceImpl.StudentServiceImpl;
import bean.LeaveSchool;
import bean.Student;
import service.LeaveSchoolService;
import service.StudentService;

public class LeaveSchoolAction extends BaseAction{
	private LeaveSchoolService leaveSchoolService = new LeaveSchoolServiceImpl();
	private List<LeaveSchool> lslist = new ArrayList<LeaveSchool>();
	private LeaveSchool leaveSchool = new LeaveSchool();
	private StudentService studentService = new StudentServiceImpl();
	private Student student = new Student();
	private String uname;
	
	 public String tolist() throws Exception{
		 lslist = leaveSchoolService.FindAll();
		return "LeaveSchoolList.jsp";
		 
	 }
	 public String upd() throws Exception{
		// 解决乱码，用于页面输出
			HttpServletResponse response = null;
			response = ServletActionContext.getResponse();
			response.setContentType("text/html;charset=UTF-8");
			response.setCharacterEncoding("UTF-8");
			PrintWriter out = response.getWriter();
		 student = studentService.findByUname(uname);
		 leaveSchool.setStu(student);
		 leaveSchool.setState("迁出");
		 Date date = new Date(); 
		 leaveSchool.setTime(date);
		 leaveSchool.setUname(student.getS_name());
		 leaveSchoolService.upd(leaveSchool);
		 System.out.println(leaveSchool.getTime());
			//跳转
			out.print("<script language='javascript'>alert('迁出成功！');window.location='Index.jsp';</script>");
			out.flush();
			out.close();
			return null;
	 }
	 //--
	public LeaveSchoolService getLeaveSchoolService() {
		return leaveSchoolService;
	}
	public void setLeaveSchoolService(LeaveSchoolService leaveSchoolService) {
		this.leaveSchoolService = leaveSchoolService;
	}
	public List<LeaveSchool> getLslist() {
		return lslist;
	}
	public void setLslist(List<LeaveSchool> lslist) {
		this.lslist = lslist;
	}
	public LeaveSchool getLeaveSchool() {
		return leaveSchool;
	}
	public void setLeaveSchool(LeaveSchool leaveSchool) {
		this.leaveSchool = leaveSchool;
	}
	public StudentService getStudentService() {
		return studentService;
	}
	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	
	 
}
