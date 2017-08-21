package learn.online.api.service.servicemapper;

import java.util.List;

import learn.online.api.service.BaseService;
import learn.online.common.vo.Foruminfo;



public interface Foruminfoservice extends BaseService{
	public List<Foruminfo> AllForumes();
	public boolean insertForumserver(Foruminfo an);
	public boolean delectForumserver(Foruminfo an);
	public boolean updateForumserver(Foruminfo an);
	public Foruminfo selectupdateForumserver(int Tid);
	public boolean passForumserver(Foruminfo ci);
	public List<Foruminfo> passAllForumes();
}
