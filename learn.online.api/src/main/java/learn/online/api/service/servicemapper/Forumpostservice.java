package learn.online.api.service.servicemapper;

import java.util.List;

import learn.online.api.service.BaseService;
import learn.online.common.vo.Forumpost;
import learn.online.common.vo.Forumrelation;
import learn.online.common.vo.Forumreview;



public interface Forumpostservice extends BaseService{
	
	//����
	public List<Forumpost> Allforumposts();
	public boolean insertforumpostserver(Forumpost an);
	public boolean delectforumpostserver(Forumpost an);
	public boolean updateforumpostserver(Forumpost an);
	public Forumpost selectupdateforumpostserver(int Tid);
	public boolean passforumpostserver(Forumpost ci);
	public List<Forumpost> passAllforumposts();
	
	//����
	public List<Forumreview> Allforumreviewes();
	public boolean insertforumreviewserver(Forumreview ci);
	public boolean delectforumreviewserver(Forumreview ci);
	
	//��̳��ϵ
	public boolean insertralationserver(Forumrelation an);
	public boolean delectralationserver(Forumrelation an);
	public boolean updateralationserver(Forumrelation an);
	//public Forumrelation selectupdateralationserver(Classinfo classinfo);
}
