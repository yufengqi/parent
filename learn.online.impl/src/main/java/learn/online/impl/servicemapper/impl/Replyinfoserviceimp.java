package learn.online.impl.servicemapper.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import learn.online.api.dao.daomapper.Controlreplyinfo;
import learn.online.api.service.servicemapper.Replyinfoservice;
import learn.online.common.util.PageBean;
import learn.online.common.vo.Leavewordinfo;
import learn.online.common.vo.Manage;
import learn.online.common.vo.Registertable;
import learn.online.common.vo.Replyinfo;

import com.opensymphony.xwork2.ActionContext;

public class Replyinfoserviceimp implements Replyinfoservice
{
    private Controlreplyinfo rfi;
	
	public void setRfi(Controlreplyinfo rfi) {
		this.rfi = rfi;
	}
	
	public Map<String, Object> getSessionnow()
	{
		Map<String, Object> session = ActionContext.getContext().getSession();
		return session;
	}
	
	public List<Replyinfo> Allreplyinfoes() {
		// TODO Auto-generated method stub
		List<Replyinfo> list = rfi.queryAll();
		return list;
	}
	
	public PageBean<Replyinfo> AllClasses(String sql,String coutsql,int pageSize,int page) {
		// TODO Auto-generated method stub
		int allRow = this.rfi.getAllRowCount(coutsql);  //总记录数
		int totalPage = PageBean.countTatalPage(pageSize, allRow); //总页数
		final int offset = PageBean.countOffset(pageSize, page); //当前页开始记录
		final int length = pageSize; // 每页记录数
		final int currentPage = PageBean.countCurrentPage(page); // 当前页
		List list = this.rfi.queryAll(sql,offset, length);//把分页信息保存到Bean当中
		PageBean<Replyinfo> pageBean  = new PageBean<Replyinfo>();
		pageBean.setPageSize(pageSize);
		pageBean.setCurrentPage(currentPage);
		pageBean.setAllRow(allRow);
		pageBean.setTotalPage(totalPage);
		pageBean.setList(list);
		//pageBean.init();
		return pageBean;
	}
	
	public boolean insertreplyinfoserver(Replyinfo an){
		 
		Leavewordinfo lwid = (Leavewordinfo)getSessionnow().get("Leavewordinfo");
		if(getSessionnow().get("register") == null)
		{
			an.setReplyman("�ο�");
		}
		else if(getSessionnow().get("register") instanceof Registertable)
		{
			Registertable rt = (Registertable)getSessionnow().get("register");
			an.setReplyman(rt.getYhm());
		}
		else if(getSessionnow().get("register") instanceof Manage)
		{
			Manage mm = (Manage)getSessionnow().get("register");
			an.setReplyman(mm.getYhm());
		}
		
		an.setReplytime(new Date());
		an.setLeavewordinfo(lwid);
			rfi.insert(an);
			return true;
	}

	public boolean delectreplyinfoserver(Replyinfo an) {
		// TODO Auto-generated method stub
		  boolean flag = rfi.delete(an);
		  if(flag == true)
		    return true;
		  return false;
	}

	public boolean updatereplyinfoserver(Replyinfo an) {
		// TODO Auto-generated method stub
		boolean flag = rfi.update(an);
		  if(flag == true)
		    return true;
		  return false;
	}

	public Replyinfo selectupdatereplyinfoserver(int i) {
		// TODO Auto-generated method stub
		Replyinfo an = rfi.selectById(i);
		return an;
	}

	public boolean passreplyinfoserver(Replyinfo ci) {
		// TODO Auto-generated method stub
		boolean flag = rfi.update(ci);
		  if(flag == true)
		    return true;
		  return false;
	}

	public List<Replyinfo> passAllreplyinfoes() {
		// TODO Auto-generated method stub
		List<Replyinfo> list = rfi.queryAllpass();
		return list;
	}
}