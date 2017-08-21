package learn.online.api.dao.daomapper;

import java.util.List;

import learn.online.api.dao.BaseDao;
import learn.online.common.vo.Registertable;
import learn.online.common.vo.Teacherinfo;

public interface ControlT extends BaseDao
{

	public Teacherinfo selectByXid(Teacherinfo an);
	public Teacherinfo selectByJId(int Tid);
	public List<Teacherinfo> queryAll(Registertable rt);
}