package service;

import java.util.List;

import bean.Maintain;

public interface MaintainService {
	public void add(Maintain maintain) throws Exception;
	 public List<Maintain> FindAllByid(int sid) throws Exception;
	 

}
