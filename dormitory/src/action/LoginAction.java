package action;


import ServiceImpl.AdminServiceImpl;
import ServiceImpl.BuildingAdminServiceImpl;
import ServiceImpl.StudentServiceImpl;
import bean.Admin;
import bean.Building;
import bean.BuildingAdmin;
import bean.Student;
import service.AdminService;
import service.BuildingAdminService;
import service.StudentService;

public class LoginAction extends BaseAction{
private String uname;
private String pwd;
private String Type;
private Admin admin=new Admin();
private Student student=new Student();
private BuildingAdmin buildingAdmin = new BuildingAdmin();

public String execute() throws Exception{
	System.out.println(Type);
	System.out.println(uname+pwd);
	if(Type.equals("系统管理员"))
	{
		 AdminService adminService = new AdminServiceImpl();
		admin = adminService.Login(uname, pwd);
		if(admin==null){
			    getOut().println("<script>alert('用户名或密码输入错误！请重新登录');location='Login.jsp';</script>");
			    return "error";
			   
		}else{
		getSession().put("type", "1");//前面名字，后面是值
		getSession().put("aid", admin.getId());
		return "success";
		}
		}else if(Type.equals("楼宇管理员"))
		{
			 BuildingAdminService buildingAdminService = new BuildingAdminServiceImpl();
			 buildingAdmin = buildingAdminService.Login(uname, pwd);
			if(buildingAdmin==null){
				    getOut().println("<script>alert('用户名或密码输入错误！请重新登录');location='Login.jsp';</script>");
				    return "error";
				   
			}else{
				//在登陆时根据楼层管理员判断楼号
			Building building = buildingAdminService.selectBuildName(buildingAdmin.getId());
				
			getSession().put("type", "2");//前面名字，后面是值
			getSession().put("bid",buildingAdmin.getId());
			getSession().put("building", building);
			return "success";
			}
			}
	else if(Type.equals("学生"))
	{
	StudentService studentService = new StudentServiceImpl();
		student =studentService.Login(uname, pwd);
		if(student==null){
			    getOut().println("<script>alert('用户名或密码输入错误！请重新登录');location='Login.jsp';</script>");
			    return "error";
			   
		}else{
		getSession().put("type", "3");//前面名字，后面是值
		getSession().put("sid", student.getId());
		return "success";
		}
	}
	return null;
}
//--

public String getUname() {
	return uname;
}
public BuildingAdmin getBuildingAdmin() {
	return buildingAdmin;
}

public void setBuildingAdmin(BuildingAdmin buildingAdmin) {
	this.buildingAdmin = buildingAdmin;
}

public void setUname(String uname) {
	this.uname = uname;
}
public String getPwd() {
	return pwd;
}
public void setPwd(String pwd) {
	this.pwd = pwd;
}
public String getType() {
	return Type;
}
public void setType(String type) {
	Type = type;
}

public Admin getAdmin() {
	return admin;
}
public void setAdmin(Admin admin) {
	this.admin = admin;
}
public Student getStudent() {
	return student;
}
public void setStudent(Student student) {
	this.student = student;
}




}
