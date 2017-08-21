package learn.online.api.service.servicemapper;

import java.util.List;

import learn.online.api.service.BaseService;
import learn.online.common.vo.Teacherinfo;



public interface Teacherinfoservice extends BaseService{
	public List<Teacherinfo> AllNews();
	public boolean insertnewserver(Teacherinfo an);
	public boolean delectnewserver(Teacherinfo an);
	public boolean updatenewserver(Teacherinfo an);
	public Teacherinfo selectupdatenewserver(int Tid);
	
	
	public Teacherinfo selectintroducenewserver(int i);
}
