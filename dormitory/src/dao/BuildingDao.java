package dao;

import java.util.List;

import bean.Building;
import bean.Student;

public interface BuildingDao {
	public List<Building> FindAll()throws Exception;
	public void Upd(Building b) throws Exception;
	public void Del(int id) throws Exception;
	public Building findById(int id)throws Exception;
	public List<Building> FindByName(String str)throws Exception;
	public void Add(Building b)throws Exception;
}
