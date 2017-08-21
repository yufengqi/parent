package learn.online.api.dao.daomapper;

import java.util.List;

import learn.online.api.dao.BaseDao;
import learn.online.common.vo.Classinfo;

public interface ControlClass extends BaseDao
{
	
	
	public List<Classinfo> queryAllpass();
	public List<Classinfo> queryAllchoose();
	public List<Classinfo> queryAllapply();
	
	//public Classinfo selectByXid(Classinfo an);
}