package learn.online.api.dao.daomapper;

import java.util.List;

import learn.online.api.dao.BaseDao;
import learn.online.common.vo.Learninfo;
import learn.online.common.vo.Leavewordinfo;


public interface Controlleaveword extends BaseDao
{
	public List<Leavewordinfo> queryAllpass();
	
	public List<Learninfo> queryAlllearninfo();
	public void insertlearninfo(Learninfo ci);
}