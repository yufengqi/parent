package learn.online.api.dao.daomapper;

import java.util.List;
import learn.online.api.dao.BaseDao;
import learn.online.common.vo.Classinfo;
import learn.online.common.vo.Cwrration;

public interface Controlralation extends BaseDao
{

	public List<Cwrration> queryAllpass();
	public Cwrration selectByRid(int set,int cid, int zyid);
	public Cwrration selectByRidall(int cid);
	public Cwrration selectByRiddelete(int zcid, int cid, int identity);
	public Cwrration selectById(Classinfo classinfo);
}