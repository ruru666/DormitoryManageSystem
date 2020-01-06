package action;

import java.util.ArrayList;
import java.util.List;

import com.sun.org.apache.xalan.internal.xsltc.compiler.sym;

import ServiceImpl.DormitoryServiceImpl;
import bean.Dormitory;
import service.DormitoryService;

public class DormitoryAction extends BaseAction {
	private Dormitory dormitory = new Dormitory();
	private DormitoryService dormitoryService = new DormitoryServiceImpl();
	private List<Dormitory> dlist = new ArrayList<Dormitory>();
	private Integer did;
	private String SearchKey;

	
	public String tolist() throws Exception{
		dlist = dormitoryService.FindAll();
		System.out.println(dlist.get(0).getNum());
		System.out.println("111进来了");
		return "DormitoryList.jsp";
}
	public String toupd() throws Exception{
		System.out.println(did);
		dormitory = dormitoryService.findById(did);
		System.out.println("前台"+dormitory.getNum());
		return "DormitoryUpd.jsp";
		
	}
	public String del() throws Exception{
		dormitoryService.Del(did);
		return "tolist";
	}
	public String upd() throws Exception{
		dormitoryService.Upd(dormitory);
		return "tolist";
	}
	public String findByName() throws Exception{
		dlist = dormitoryService.FindByName(SearchKey);
		return "DormitoryList.jsp";
	}
	public String  add() throws Exception {
		dormitoryService.Add(dormitory);
		return "tolist";
		
	}
	//--
	public Dormitory getDormitory() {
		return dormitory;
	}
	public void setDormitory(Dormitory dormitory) {
		this.dormitory = dormitory;
	}
	public DormitoryService getDormitoryService() {
		return dormitoryService;
	}
	public void setDormitoryService(DormitoryService dormitoryService) {
		this.dormitoryService = dormitoryService;
	}
	public List<Dormitory> getDlist() {
		return dlist;
	}
	public void setDlist(List<Dormitory> dlist) {
		this.dlist = dlist;
	}
	public Integer getDid() {
		return did;
	}
	public void setDid(Integer did) {
		this.did = did;
	}
	public String getSearchKey() {
		return SearchKey;
	}
	public void setSearchKey(String searchKey) {
		SearchKey = searchKey;
	}
	
	

}
