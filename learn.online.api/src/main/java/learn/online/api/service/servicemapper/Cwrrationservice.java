package learn.online.api.service.servicemapper;

import java.util.List;

import learn.online.api.service.BaseService;
import learn.online.common.vo.Classinfo;
import learn.online.common.vo.Cwrration;



public interface Cwrrationservice extends BaseService{
	public List<Cwrration> Allralationes();
	public boolean insertralationserver(Cwrration an);
	public boolean delectralationserver(Cwrration an);
	public boolean updateralationserver(Cwrration an);
	public Cwrration selectupdateralationserver(Classinfo classinfo);
	public boolean passralationserver(Cwrration ci);
	public List<Cwrration> passAllralationes();
	//public Cwrration selectaboutralationserver(Cwrration an);
}
