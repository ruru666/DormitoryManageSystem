package action;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.mysql.fabric.xmlrpc.base.Array;

import ServiceImpl.BuildingAdminServiceImpl;
import bean.BuildingAdmin;
import service.BuildingAdminService;

public class BuildingAdminAction extends BaseAction {
	private BuildingAdminService buildingAdminService = new BuildingAdminServiceImpl();
	private BuildingAdmin buildingAdmin = new BuildingAdmin();
	private List<BuildingAdmin> list = new ArrayList<BuildingAdmin>();
	private int baid;
	private int id;
	private String SearchKey;

	public String add() throws Exception {
		buildingAdminService.Add(buildingAdmin);
		return "tolist";
	}

	public String UpdBySelete() throws Exception {
		System.out.println(SearchKey);
		list = buildingAdminService.FindByName(SearchKey);
		return "BuildingAdminList.jsp";
	}

	public String tolist() throws Exception {
		list = buildingAdminService.FindAll();

		return "BuildingAdminList.jsp";
	}

	public String toupd() throws Exception {
		buildingAdmin = buildingAdminService.findById(baid);
		System.out.println(baid);
		return "BuildingAdminUpd.jsp";
	}

	public String del() throws Exception {
		buildingAdminService.Del(baid);
		return "tolist";
	}

	public String upd() throws Exception {
		buildingAdminService.Upd(buildingAdmin);

		return "tolist";
	}

	public String UpdPwd() throws Exception {

		// 解决乱码，用于页面输出
		HttpServletResponse response = null;
		response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();

		int id = (int) getSession().get("bid");
		buildingAdmin.setId(id);
		buildingAdminService.UpdPwd(buildingAdmin);
		// 跳转
		out.print("<script language='javascript'>alert('修改密码成功！');window.location='Index.jsp';</script>");
		out.flush();
		out.close();

		return null;
	}
	// ---

	public BuildingAdminService getBuildingAdminService() {
		return buildingAdminService;
	}

	public void setBuildingAdminService(BuildingAdminService buildingAdminService) {
		this.buildingAdminService = buildingAdminService;
	}

	public BuildingAdmin getBuildingAdmin() {
		return buildingAdmin;
	}

	public void setBuildingAdmin(BuildingAdmin buildingAdmin) {
		this.buildingAdmin = buildingAdmin;
	}

	public List<BuildingAdmin> getList() {
		return list;
	}

	public void setList(List<BuildingAdmin> list) {
		this.list = list;
	}

	public int getBaid() {
		return baid;
	}

	public void setBaid(int baid) {
		this.baid = baid;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSearchKey() {
		return SearchKey;
	}

	public void setSearchKey(String searchKey) {
		SearchKey = searchKey;
	}

}
