package learn.online.api.service.servicemapper;

import java.util.List;

import learn.online.api.service.BaseService;
import learn.online.common.vo.Publicnotice;



public interface Publicnoticeservice extends BaseService{
	public List<Publicnotice> Allpublicnoticees();
	public boolean insertpublicnoticeserver(Publicnotice an);
	public boolean delectpublicnoticeserver(Publicnotice an);
	public boolean updatepublicnoticeserver(Publicnotice an);
	public Publicnotice selectupdatepublicnoticeserver(int Tid);
	
	
	
	public boolean passpublicnoticeserver(Publicnotice ci);
	public List<Publicnotice> passAllpublicnoticees();
	public List<Publicnotice> allapplypublicnoticees();
}
