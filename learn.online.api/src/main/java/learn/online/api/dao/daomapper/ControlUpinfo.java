package learn.online.api.dao.daomapper;

import java.util.List;

import learn.online.api.dao.BaseDao;
import learn.online.common.vo.Upinfo;


public interface ControlUpinfo extends BaseDao
{
	public List<Upinfo> queryAllpass();
	public List<Upinfo> queryAllchoose();
	public List<Upinfo> queryAllapply();
	//public Upinfo selectByXid(Upinfo an);
}