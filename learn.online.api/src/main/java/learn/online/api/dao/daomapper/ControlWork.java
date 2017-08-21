package learn.online.api.dao.daomapper;

import java.util.List;

import learn.online.api.dao.BaseDao;
import learn.online.common.vo.Workinfo;

public interface ControlWork extends BaseDao
{

	public List<Workinfo> queryAllpass();
	public List<Workinfo> queryAllchoose();
	public List<Workinfo> queryAllapply();
	//public Workinfo selectByXid(Workinfo an);
}