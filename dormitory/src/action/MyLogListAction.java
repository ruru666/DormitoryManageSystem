package action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import ServiceImpl.LogAddServiceImpl;
import bean.SleepRecords;
import service.LogAddService;

public class MyLogListAction extends ActionSupport {
	private List<SleepRecords> list;
	private LogAddService las = new LogAddServiceImpl();
	private String bid;
	
	public String execute() {
		list = las.selectLogByBudId(bid);
		return "mylog";
	}
	
	
	
	public List<SleepRecords> getList() {
		return list;
	}
	public void setList(List<SleepRecords> list) {
		this.list = list;
	}
	public LogAddService getLas() {
		return las;
	}
	public void setLas(LogAddService las) {
		this.las = las;
	}
	public String getBid() {
		return bid;
	}
	public void setBid(String bid) {
		this.bid = bid;
	}
	
	
	

}
