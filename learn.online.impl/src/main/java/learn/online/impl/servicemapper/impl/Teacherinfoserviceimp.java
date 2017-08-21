package learn.online.impl.servicemapper.impl;

import java.util.List;
import java.util.Map;

import learn.online.api.dao.daomapper.ControlT;
import learn.online.api.service.servicemapper.Teacherinfoservice;
import learn.online.common.util.PageBean;
import learn.online.common.vo.Registertable;
import learn.online.common.vo.Teacherinfo;

import com.opensymphony.xwork2.ActionContext;



public class Teacherinfoserviceimp implements Teacherinfoservice
{
    private ControlT cis;
    
    Map<String, Object> session = ActionContext.getContext().getSession();
	
	public void setCis(ControlT cis) {
		this.cis = cis;
	}
	
	public List<Teacherinfo> AllNews() {
		// TODO Auto-generated method stub
		Registertable rt = (Registertable)session.get("register");
		List<Teacherinfo> list = cis.queryAll(rt);
		return list;
	}
	
	public PageBean<Teacherinfo> AllClasses(String sql,String coutsql,int pageSize,int page) {
		// TODO Auto-generated method stub
		int allRow = this.cis.getAllRowCount(coutsql);  //总记录数
		int totalPage = PageBean.countTatalPage(pageSize, allRow); //总页数
		final int offset = PageBean.countOffset(pageSize, page); //当前页开始记录
		final int length = pageSize; // 每页记录数
		final int currentPage = PageBean.countCurrentPage(page); // 当前页
		List list = this.cis.queryAll(sql,offset, length);//把分页信息保存到Bean当中
		PageBean<Teacherinfo> pageBean  = new PageBean<Teacherinfo>();
		pageBean.setPageSize(pageSize);
		pageBean.setCurrentPage(currentPage);
		pageBean.setAllRow(allRow);
		pageBean.setTotalPage(totalPage);
		pageBean.setList(list);
		//pageBean.init();
		return pageBean;
	}
	
	public boolean insertnewserver(Teacherinfo an){
		
		an.setRegistertable((Registertable)session.get("register"));
			cis.insert(an);
			return true;
	}

	public boolean delectnewserver(Teacherinfo an) {
		// TODO Auto-generated method stub
		 an = cis.selectById(an.getTid());
		  boolean flag = cis.delete(an);
		  if(flag == true)
		    return true;
		  return false;
	}

	public boolean updatenewserver(Teacherinfo an) {
		// TODO Auto-generated method stub
		Teacherinfo t = cis.selectById(an.getTid());
		an.setRegistertable(t.getRegistertable());
		boolean flag = cis.update(an);
		  if(flag == true)
		    return true;
		  return false;
	}

	public Teacherinfo selectupdatenewserver(int i) {
		// TODO Auto-generated method stub
		Teacherinfo an = cis.selectById(i);
		return an;
	}
	
	public Teacherinfo selectintroducenewserver(int i) {
		// TODO Auto-generated method stub
		Teacherinfo an = cis.selectByJId(i);
		return an;
	}

}