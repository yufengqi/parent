package learn.online.api.service.servicemapper;

import java.util.List;

import learn.online.api.service.BaseService;
import learn.online.common.vo.Registertable;


public interface RegisterLoginService extends BaseService {
	public boolean login(String yhm,String pwd);
	public void register(Registertable rtc);//throws RegisterException;
	public List<Registertable> AllRegister();
	public boolean delectserver(Registertable rtc);
	public boolean updateserver(Registertable rtc);
	public Registertable selectupdateserver(int zcid);
	

}
