package learn.online.api.dao.daomapper;

import java.util.List;

import learn.online.api.dao.BaseDao;
import learn.online.common.vo.StudentId;
import learn.online.common.vo.TeacherId;


public interface ControlView  extends BaseDao
{
	public List<TeacherId> queryAllteacher();
	public List<StudentId> queryAllclasses();
}
