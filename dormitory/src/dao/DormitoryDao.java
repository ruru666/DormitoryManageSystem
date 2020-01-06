package dao;

import java.util.List;

import bean.Building;
import bean.Dormitory;

public interface DormitoryDao {
	public List<Dormitory> FindAll()throws Exception;
	public void Upd(Dormitory d) throws Exception;
	public void Del(int id) throws Exception;
	public Dormitory findById(int id)throws Exception;
	public List<Dormitory> FindByName(String str)throws Exception;
	public void Add(Dormitory d)throws Exception;

}
