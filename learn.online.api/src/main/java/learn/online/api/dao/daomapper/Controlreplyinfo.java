package learn.online.api.dao.daomapper;

import java.util.List;

import learn.online.api.dao.BaseDao;
import learn.online.common.vo.Replyinfo;


public interface Controlreplyinfo extends BaseDao
{
	public List<Replyinfo> queryAllpass();
}