package learn.online.api.dao.daomapper;

import java.util.List;

import learn.online.api.dao.BaseDao;
import learn.online.common.vo.Publicnotice;


public interface Controlpublicnotice extends BaseDao
{

	public List<Publicnotice> queryAllpass();
	public List<Publicnotice> queryAllapply();
}