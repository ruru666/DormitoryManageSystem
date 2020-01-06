package action;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import ServiceImpl.BuildingSericeImpl;
import ServiceImpl.StudentServiceImpl;
import bean.Building;
import bean.Student;
import service.BuildingService;
import service.StudentService;

public class StudentAction extends BaseAction {
	private StudentService studentService = new StudentServiceImpl();
	private List<Student> list = new ArrayList<Student>();
	private Student student = new Student();
	private BuildingService buildingService = new BuildingSericeImpl();
	private List<Building> blist = new ArrayList<Building>();
	private int sid;
	private String SearchKey;
	private String Password;
	private String Password2;
	private String Msg;

	
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getPassword2() {
		return Password2;
	}
	public void setPassword2(String password2) {
		Password2 = password2;
	}
	public String getMsg() {
		return Msg;
	}
	public void setMsg(String msg) {
		Msg = msg;
	}
	public String dh() throws Exception{
		// 解决乱码，用于页面输出
					HttpServletResponse response = null;
					response = ServletActionContext.getResponse();
					response.setContentType("text/html;charset=UTF-8");
					response.setCharacterEncoding("UTF-8");
					PrintWriter out = response.getWriter();
		studentService.Update(student);
		System.out.println("进来了~~~修改");
		//跳转
				out.print("<script language='javascript'>alert('寝室调换成功！');window.location='Index.jsp';</script>");
				out.flush();
				out.close();
		return null;
	}
	public String RuZhu() throws Exception{
		// 解决乱码，用于页面输出
		HttpServletResponse response = null;
		response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		studentService.Add(student);
		/* getOut().println("<script>alert('成功入住');location='Login.jsp';</script>");*/
		out.print("<script language='javascript'>alert('学生入住成功！');window.location='Index.jsp';</script>");
		out.flush();
		out.close();
		return null;
		
	}
	public String tolist() throws Exception{
		list = studentService.FindAll();
		return "StudentList.jsp";
	}
	
	public String toupd() throws Exception {
		student=studentService.findById(sid);
		return "StudentUpd.jsp";
	}
	public String del() throws Exception{
		studentService.Del(sid);
		return "tolist";
	}
	public String upd() throws Exception{
		studentService.Upd(student);
		return "tolist";
	}
	public String findByName() throws Exception {
		System.out.println(SearchKey);
		list = studentService.FindByName(SearchKey);
		return "StudentList.jsp";
		
	}
	public String toadd() throws Exception{
		blist=buildingService.FindAll();
		System.out.println("进来了");
		return "StudentAdd.jsp";
	}
	public String add() throws Exception{
		
		studentService.Add(student);
		return "tolist";
		
	}
	
//--修改学生密码
	public String PasswordUpdate() throws Exception {
		
		// 解决乱码，用于页面输出
		HttpServletResponse response = null;
		response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		sid= (int) getSession().get("sid");
		studentService.UpdatePassword(sid, Password);
		
		out.print("<script language='javascript'>alert('密码修改成功！');window.location='Index.jsp';</script>");
		out.flush();
		out.close();
		return null;
			
		}


	public StudentService getStudentService() {
		return studentService;
	}


	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}


	public List<Student> getList() {
		return list;
	}


	public void setList(List<Student> list) {
		this.list = list;
	}


	public Student getStudent() {
		return student;
	}


	public void setStudent(Student student) {
		this.student = student;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getSearchKey() {
		return SearchKey;
	}

	public void setSearchKey(String searchKey) {
		SearchKey = searchKey;
	}

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
	
	
	
}
