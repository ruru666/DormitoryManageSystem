package action;

import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.tomcat.jni.Mmap;
import org.hibernate.Session;

import ServiceImpl.MaintainServiceImpl;
import ServiceImpl.StudentServiceImpl;
import bean.Maintain;
import bean.Student;
import dao.impl.MaintainDaoImpl;
import service.MaintainService;
import service.StudentService;

public class MaintainAction extends BaseAction {
	private Maintain maintain = new Maintain();
	private MaintainService maintainservice = new MaintainServiceImpl();
	private StudentService service = new StudentServiceImpl();
	private int sid;
	private List mtlist;

	public Maintain getMaintain() {
		return maintain;
	}

	public void setMaintain(Maintain maintain) {
		this.maintain = maintain;
	}

	public MaintainService getMaintainservice() {
		return maintainservice;
	}

	public void setMaintainservice(MaintainService maintainservice) {
		this.maintainservice = maintainservice;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public List getMtlist() {
		return mtlist;
	}

	public void setMtlist(List mtlist) {
		this.mtlist = mtlist;
	}
//查找维修信息
	public String FindAllBySid() throws Exception {
		/*
		 * sid = (int) getSession().get("sid"); Student s = new Student();
		 * s=service.FindAllBySid(sid); maintain.setStudent(s);
		 * maintainservice.add(maintain);
		 */
		 sid = (int) getSession().get("sid"); 
		mtlist=maintainservice.FindAllByid(sid);
		return SUCCESS;

	}
	//添加维修信息
	public String add() throws Exception {
		// 解决乱码，用于页面输出
				HttpServletResponse response = null;
				response = ServletActionContext.getResponse();
				response.setContentType("text/html;charset=UTF-8");
				response.setCharacterEncoding("UTF-8");
				PrintWriter out = response.getWriter();
		 sid = (int) getSession().get("sid"); 
		 Student s = new Student();
		 s=service.FindAllBySid(sid);
		 Date date = new Date();
		 maintain.setStu(s);
		 maintain.setTime(date);
		 maintain.setState("未维修");
		 System.out.println("维修时间"+date);
		 maintainservice.add(maintain);
		 out.print("<script language='javascript'>alert('成功上报维修信息！');window.location='Index.jsp';</script>");
			out.flush();
			out.close();
			return null;

	}
	/*
	 * public String add() throws Exception { sid = (int) getSession().get("sid");
	 * System.out.println(sid); Student student = new Student();
	 * 
	 * maintain.setStudent(student); s.setId(id); maintain.getStudent().getId();
	 * 
	 * 
	 * maintain.setStudent(student);
	 * 
	 * 
	 * return SUCCESS;
	 * 
	 * }
	 */

	public StudentService getService() {
		return service;
	}

	public void setService(StudentService service) {
		this.service = service;
	}
}
