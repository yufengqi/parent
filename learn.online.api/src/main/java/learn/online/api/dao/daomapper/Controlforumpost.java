package learn.online.api.dao.daomapper;

import java.util.List;

import learn.online.api.dao.BaseDao;
import learn.online.common.vo.Forumpost;
import learn.online.common.vo.Forumrelation;
import learn.online.common.vo.Forumreview;


public interface Controlforumpost extends BaseDao
{

	
	public List<Forumpost> queryAllpassTeacher();
	public List<Forumpost> queryAllpassStudent();
	public List<Forumpost> queryAllpass();
	

	public Forumrelation selectByRid(int cid);
	//public Forumrelation selectByXid(Classinfo an);
	
	
	public boolean insertForumReview(Forumreview ci);
//	public List<Forumreview> queryAllreview();
	//public boolean delete(Forumreview ci);
}