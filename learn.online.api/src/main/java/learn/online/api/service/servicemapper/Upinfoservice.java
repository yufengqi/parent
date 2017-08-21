package learn.online.api.service.servicemapper;

import java.util.List;

import learn.online.api.service.BaseService;
import learn.online.common.vo.Upinfo;



public interface Upinfoservice extends BaseService{
	
	public List<Upinfo> Allupinfoes();
	public boolean insertupinfoserver(Upinfo an);
	public boolean delectupinfoserver(Upinfo an);
	public boolean updateupinfoserver(Upinfo an);
	public Upinfo selectupdateupinfoserver(int Tid);
	
	
	public boolean passupinfoserver(Upinfo ci);
	public List<Upinfo> passAllupinfoes();
	public List<Upinfo> allchooseupinfoes();
	public List<Upinfo> allapplyupinfoes();
	//public Upinfo selectaboutupinfoserver(Upinfo an);
}
