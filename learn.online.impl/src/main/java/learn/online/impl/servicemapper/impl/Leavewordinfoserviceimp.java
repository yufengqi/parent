package learn.online.impl.servicemapper.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import learn.online.api.dao.daomapper.Controlleaveword;
import learn.online.api.service.servicemapper.Leavewordinfoservice;
import learn.online.common.util.PageBean;
import learn.online.common.vo.Classinfo;
import learn.online.common.vo.Learninfo;
import learn.online.common.vo.Leavewordinfo;
import learn.online.common.vo.Manage;
import learn.online.common.vo.Registertable;

import com.opensymphony.xwork2.ActionContext;



public class Leavewordinfoserviceimp implements Leavewordinfoservice
{
    private Controlleaveword fli;
	
	public void setFli(Controlleaveword fli) {
		this.fli = fli;
	}
	
	public Map<String, Object> getSessionnow()
	{
		Map<String, Object> session = ActionContext.getContext().getSession();
		return session;
	}
	
	public PageBean<Leavewordinfo> AllClasses(String sql,String coutsql,int pageSize,int page) {
		// TODO Auto-generated method stub
		int allRow = this.fli.getAllRowCount(coutsql);  //总记录数
		int totalPage = PageBean.countTatalPage(pageSize, allRow); //总页数
		final int offset = PageBean.countOffset(pageSize, page); //当前页开始记录
		final int length = pageSize; // 每页记录数
		final int currentPage = PageBean.countCurrentPage(page); // 当前页
		List list = this.fli.queryAll(sql,offset, length);//把分页信息保存到Bean当中
		PageBean<Leavewordinfo> pageBean  = new PageBean<Leavewordinfo>();
		pageBean.setPageSize(pageSize);
		pageBean.setCurrentPage(currentPage);
		pageBean.setAllRow(allRow);
		pageBean.setTotalPage(totalPage);
		pageBean.setList(list);
		//pageBean.init();
		System.out.print(pageBean.getList());
		return pageBean;
	}
	
	public List<Leavewordinfo> Allleavewordes() {
		// TODO Auto-generated method stub
		List<Leavewordinfo> list = fli.queryAll();
		return list;
	}
	
	public boolean insertleavewordserver(Leavewordinfo an){
		if(getSessionnow().get("register") == null)
		{
			an.setLeavewordman("游客");
		}
		else if(getSessionnow().get("register") instanceof Registertable)
		{
			Registertable rt = (Registertable)getSessionnow().get("register");
			an.setLeavewordman(rt.getYhm());
		}
		else if(getSessionnow().get("register") instanceof Manage)
		{
			Manage mm = (Manage)getSessionnow().get("register");
			an.setLeavewordman(mm.getYhm()+"管理员");
		}
		
		an.setLeavewordtime(new Date());
			fli.insert(an);
			return true;
	}
	
	public boolean delectleavewordserver(Leavewordinfo an) {
		// TODO Auto-generated method stub
		Leavewordinfo lwid = (Leavewordinfo)getSessionnow().get("Leavewordinfo");
		 an = fli.selectById(lwid.getLwid());
		  boolean flag = fli.delete(an);
		  if(flag == true)
		    return true;
		  return false;
	}

	public boolean updateleavewordserver(Leavewordinfo an) {
		// TODO Auto-generated method stub
		boolean flag = fli.update(an);
		  if(flag == true)
		    return true;
		  return false;
	}

	public Leavewordinfo selectupdateleavewordserver(int i) {
		// TODO Auto-generated method stub
		Leavewordinfo an = fli.selectById(i);
		return an;
	}

	public boolean passleavewordserver(Leavewordinfo ci) {
		// TODO Auto-generated method stub
		boolean flag = fli.update(ci);
		  if(flag == true)
		    return true;
		  return false;
	}

	public List<Leavewordinfo> passAllleavewordes() {
		// TODO Auto-generated method stub
		List<Leavewordinfo> list = fli.queryAllpass();
		return list;
	}

	
	
	//����
	public List<Learninfo> Alllearninfos() {
		// TODO Auto-generated method stub
		List<Learninfo> list = fli.queryAlllearninfo();
		return list;
	}

	public boolean insertlearninfoserver(Learninfo li) {
		// TODO Auto-generated method stub
		Classinfo ci = (Classinfo)getSessionnow().get("classinfoxssq");
		if(getSessionnow().get("register") == null)
		{
			li.setLeavewordman("游客");
		}
		else if(getSessionnow().get("register") instanceof Registertable)
		{
			Registertable rt = (Registertable)getSessionnow().get("register");
			li.setLeavewordman(rt.getYhm());
		}
		else if(getSessionnow().get("register") instanceof Manage)
		{
			Manage mm = (Manage)getSessionnow().get("register");
			li.setLeavewordman(mm.getYhm()+"管理员");
		}
		
		li.setLeavewordtime(new Date());
		li.setClassinfo(ci);
			fli.insertlearninfo(li);
			return true;
	}
}