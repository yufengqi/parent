package learn.online.api.service.servicemapper;

import java.util.List;

import learn.online.api.service.BaseService;
import learn.online.common.vo.Learninfo;
import learn.online.common.vo.Leavewordinfo;



public interface Leavewordinfoservice extends BaseService{
	
	//����
	public List<Leavewordinfo> Allleavewordes();
	public boolean insertleavewordserver(Leavewordinfo an);
	public boolean delectleavewordserver(Leavewordinfo an);
	public boolean updateleavewordserver(Leavewordinfo an);
	public Leavewordinfo selectupdateleavewordserver(int Tid);
	
	
	
	public boolean passleavewordserver(Leavewordinfo ci);
	public List<Leavewordinfo> passAllleavewordes();
	
	
	
	//���߻���
	public List<Learninfo> Alllearninfos();
	public boolean insertlearninfoserver(Learninfo ci);
}
