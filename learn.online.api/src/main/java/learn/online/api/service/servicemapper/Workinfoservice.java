package learn.online.api.service.servicemapper;

import java.util.List;

import learn.online.api.service.BaseService;
import learn.online.common.vo.Workinfo;

public interface Workinfoservice extends BaseService{
	public List<Workinfo> Allworkes();
	public boolean insertworkserver(Workinfo an);
	public boolean delectworkserver(Workinfo an);
	public boolean updateworkserver(Workinfo an);
	public Workinfo selectupdateworkserver(int Tid);
	
	
	
	public boolean passworkserver(Workinfo ci);
	public List<Workinfo> passAllworkes();
	public List<Workinfo> allchooseworkes();
	public List<Workinfo> allapplyworkes();
	//public Workinfo selectaboutworkserver(Workinfo an);
}
