package learn.online.api.dao.daomapper;

import learn.online.api.dao.BaseDao;
import learn.online.common.vo.Manage;
import learn.online.common.vo.Registertable;

public interface ControlYH extends BaseDao
{
	public Registertable selectByNamePwd(String custname,String pwd,int identity);
	public Registertable selectByName(String custname);
	public Manage selectByNamePwdmanagement(String custname,String pwd);
}
