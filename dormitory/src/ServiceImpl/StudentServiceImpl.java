package ServiceImpl;

import java.util.List;

import bean.Student;
import dao.StudentDao;
import dao.impl.StudentDaoImpl;
import service.StudentService;

public class StudentServiceImpl implements StudentService {
private StudentDao studentDao=new StudentDaoImpl();

public Student Login(String uname, String pwd) throws Exception {
	// TODO Auto-generated method stub
	return studentDao.Login(uname, pwd);
}

@Override
public List<Student> FindAll() throws Exception {
	// TODO Auto-generated method stub
	return studentDao.FindAll();
}

public void Upd(Student s) throws Exception {
	// TODO Auto-generated method stub
	studentDao.Upd(s);
}

@Override
public void Del(int id) throws Exception {
	// TODO Auto-generated method stub
	studentDao.Del(id);
}

@Override
public Student findById(int id) throws Exception {
	// TODO Auto-generated method stub
	return studentDao.findById(id);
}

@Override
public List<Student> FindByName(String str) throws Exception {
	// TODO Auto-generated method stub
	return studentDao.FindByName(str);
}

@Override
public void Add(Student s) throws Exception {
	// TODO Auto-generated method stub
	studentDao.Add(s);
}

public void Update(Student s) throws Exception {
	// TODO Auto-generated method stub
	studentDao.Update(s);
}

@Override
public Student findByUname(String uname) throws Exception {
	// TODO Auto-generated method stub
	return studentDao.findByUname(uname);
}

@Override
public Student FindAllBySid(int sid) throws Exception {
	// TODO Auto-generated method stub
	return studentDao.FindAllBySid(sid);
}

@Override
public void UpdatePassword(int id, String s_pwd) throws Exception {
	// TODO Auto-generated method stub
	studentDao.UpdatePassword(id, s_pwd);
	
}
	
}
