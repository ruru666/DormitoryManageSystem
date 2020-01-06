package action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import ServiceImpl.AdminServiceImpl;
import bean.Admin;
import service.AdminService;

public class AdminAction extends BaseAction {
	private Admin admin=new Admin();
	private AdminService adminService = new AdminServiceImpl();
	
	public String upaPwd() throws Exception{
		// 解决乱码，用于页面输出
		HttpServletResponse response = null;
		response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		int id = (int) getSession().get("aid");
		admin.setId(id);
		adminService.UpdPwd(admin);
		//跳转
				out.print("<script language='javascript'>alert('密码修改成功！');window.location='Index.jsp';</script>");
				out.flush();
				out.close();
		return null;
		
	}
	public Admin getAdmin() {
		return admin;
	}
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	public AdminService getAdminService() {
		return adminService;
	}
	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}
	
	//--
	

}
