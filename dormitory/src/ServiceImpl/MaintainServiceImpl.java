package ServiceImpl;

import java.util.List;

import bean.Maintain;
import dao.MaintainDao;
import dao.impl.MaintainDaoImpl;
import service.MaintainService;

public class MaintainServiceImpl implements MaintainService {


	MaintainDao maindao=new MaintainDaoImpl();
	
	public void add(Maintain maintain) throws Exception {
		// TODO Auto-generated method stub
		maindao.add(maintain);
	}

	@Override
	public List<Maintain> FindAllByid(int sid) throws Exception {
		// TODO Auto-generated method stub
		return maindao.FindAllByid(sid);
	}

	

	
}
