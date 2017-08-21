package learn.online.api.dao.daomapper;

import java.util.List;

import learn.online.api.dao.BaseDao;
import learn.online.common.vo.Foruminfo;

public interface ControlForum  extends BaseDao
{

	public List<Foruminfo> queryAllpassteacher();
	public List<Foruminfo> queryAllpassstudent();
	public List<Foruminfo> queryAllpass();
}