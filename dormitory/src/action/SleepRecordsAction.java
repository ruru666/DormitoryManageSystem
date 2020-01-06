package action;

import java.util.ArrayList;
import java.util.List;

import ServiceImpl.SleepRecordsServiceImpl;
import bean.SleepRecords;
import service.SleepRecordsService;

public class SleepRecordsAction extends BaseAction {
	private SleepRecordsService sleepRecordsService = new SleepRecordsServiceImpl();
	private List<SleepRecords> slist = new ArrayList<SleepRecords>();
	private SleepRecords sleepRecords = new SleepRecords();
	private SleepRecordsService recordsService=new SleepRecordsServiceImpl();
	private String SearchKey;
	int sid;
	private List<SleepRecords> srlist=new ArrayList<SleepRecords>();
	
	public SleepRecordsService getRecordsService() {
		return recordsService;
	}
	public void setRecordsService(SleepRecordsService recordsService) {
		this.recordsService = recordsService;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public List<SleepRecords> getSrlist() {
		return srlist;
	}
	public void setSrlist(List<SleepRecords> srlist) {
		this.srlist = srlist;
	}
	public String tolist() throws Exception{
		slist = sleepRecordsService.FindAll();
		return "SleepRecordsList.jsp";
	}
	public String findByUname() throws Exception{
		slist = sleepRecordsService.FindByName(SearchKey);
		return "SleepRecordsList.jsp";
	}
	//--
	public SleepRecordsService getSleepRecordsService() {
		return sleepRecordsService;
	}
	public void setSleepRecordsService(SleepRecordsService sleepRecordsService) {
		this.sleepRecordsService = sleepRecordsService;
	}
	public List<SleepRecords> getSlist() {
		return slist;
	}
	public void setSlist(List<SleepRecords> slist) {
		this.slist = slist;
	}
	public SleepRecords getSleepRecords() {
		return sleepRecords;
	}
	public void setSleepRecords(SleepRecords sleepRecords) {
		this.sleepRecords = sleepRecords;
	}
	public String getSearchKey() {
		return SearchKey;
	}
	public void setSearchKey(String searchKey) {
		SearchKey = searchKey;
	}
	
	public String FindAllBySid() throws Exception {
		/*
		 * sid = (int) getSession().get("sid"); Student s = new Student();
		 * s=service.FindAllBySid(sid); maintain.setStudent(s);
		 * maintainservice.add(maintain);
		 */
	
		 sid = (int) getSession().get("sid"); 
		srlist=recordsService.FindAllByid(sid);
		return SUCCESS;

	}
	

}
