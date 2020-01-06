package dao;

import java.util.List;

import bean.Maintain;

public interface MaintainDao {

 public void add(Maintain maintain) throws Exception; 

 public List<Maintain> FindAllByid(int sid) throws Exception;

	

}
