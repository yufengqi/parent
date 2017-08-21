package learn.online.api.service.servicemapper;

import java.util.List;

import learn.online.api.service.BaseService;
import learn.online.common.vo.Replyinfo;



public interface Replyinfoservice extends BaseService{
	public List<Replyinfo> Allreplyinfoes();
	public boolean insertreplyinfoserver(Replyinfo an);
	public boolean delectreplyinfoserver(Replyinfo an);
	public boolean updatereplyinfoserver(Replyinfo an);
	public Replyinfo selectupdatereplyinfoserver(int Tid);
	
	
	public boolean passreplyinfoserver(Replyinfo ci);
	public List<Replyinfo> passAllreplyinfoes();
}
