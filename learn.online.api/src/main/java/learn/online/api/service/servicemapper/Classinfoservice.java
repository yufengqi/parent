package learn.online.api.service.servicemapper;

import java.util.List;

import learn.online.api.service.BaseService;
import learn.online.common.vo.Classinfo;


public interface Classinfoservice extends BaseService{
	public List<Classinfo> AllClasses();
	public boolean insertclassserver(Classinfo an);
	public boolean delectclassserver(Classinfo an);
	public boolean updateclassserver(Classinfo an);
	public Classinfo selectupdateclassserver(int Tid);
	public boolean passclassserver(Classinfo ci);
	public List<Classinfo> passAllClasses();
	public List<Classinfo> allchooseClasses();
	public List<Classinfo> allapplyClasses();
	//public Classinfo selectaboutclassserver(Classinfo an);
}
