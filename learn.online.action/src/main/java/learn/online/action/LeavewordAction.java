package learn.online.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import learn.online.api.service.servicemapper.Leavewordinfoservice;
import learn.online.common.util.PageBean;
import learn.online.common.vo.Leavewordinfo;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class LeavewordAction extends ActionSupport implements ModelDriven<Leavewordinfo>
{

	private List<Leavewordinfo> list;
	
	private Leavewordinfo ci = new Leavewordinfo();
	
	private  Leavewordinfoservice la;
	
	private PageBean<Leavewordinfo> pageBean; //封装了分页信息和数据内容的pageBean
	private int page = 1; //表示从网页中返回的当前页的值  默认为1 表示默认显示第一页内容
	
	public int getPage() {
	   return page;
	}
	
	public void setPage(int page) {
	     this.page = page;
	}
	
	public PageBean<Leavewordinfo> getPageBean() {
	    return pageBean;
	}
	
	public void setPageBean(PageBean<Leavewordinfo> pageBean) {
	     this.pageBean = pageBean;
	}
	
	public void setLa(Leavewordinfoservice la)
	{
		this.la = la;
	}
	
	public Leavewordinfo getModel() {
		// TODO Auto-generated method stub
		return ci;
	}
	
	public java.util.Map<String, Object> getSessionnow()
	{
		java.util.Map<String, Object> session = ActionContext.getContext().getSession();
		return session;
	}
	
	public String getAllleavewordes()
	{
		
		String sql = "select * from Leavewordinfo";
		this.pageBean = this.la.AllClasses(sql,sql,2, page);//获取封装了分页信息和数据的pageBean
		this.list = this.pageBean.getList(); //获取数据
		//list=la.Allleavewordes();
		HttpServletRequest request = ServletActionContext.getRequest();
		ActionContext ctxt=ActionContext.getContext();
		ctxt.put("allleaveword", list);
		request.setAttribute("allleaveword",list);
		return "success";
	}
	
	public String passAllleavewordes()
	{
	    list =la.passAllleavewordes();
	    
	    getSessionnow().put("Leavewordinfo",list);
	    
	    
		ActionContext ctxt=ActionContext.getContext();
		ctxt.put("passallleaveword", list);
		//request.setAttribute("list",list);
		return "success";
	}
	
	public String insertleaveword()
	{
		boolean flag = la.insertleavewordserver(ci);
		if(flag == true)
		   return "success";
		else
			return "fail";
	}
	
	public String deleteleaveword()
	{
		boolean flag = la.delectleavewordserver(ci);
		if(flag == true)
		   return "success";
		else
			return "fail";
	}
	
	public String updateleaveword()
	{
		boolean flag = la.updateleavewordserver(ci);
		if(flag == true)
		   return "success";
		else
			return "fail";
	}
	
	public String selectupdateleaveword()
	{
		Leavewordinfo ci1 = la.selectupdateleavewordserver(ci.getLwid());
		
		getSessionnow().put("Leavewordinfo",ci1);
		
		ActionContext ctxt1=ActionContext.getContext();
		ctxt1.put("selectleaveword", ci1);
		//getAllleavewordes();
		return "success";
	}
	
	public String passleaveword()
	{
		Leavewordinfo ci1 = la.selectupdateleavewordserver(ci.getLwid());
		
		boolean flag = la.passleavewordserver(ci1);
		if(flag == true)
		   return "success";
		else
			return "fail";
	}
}
