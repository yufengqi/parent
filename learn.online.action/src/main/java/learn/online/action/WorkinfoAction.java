package learn.online.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import learn.online.api.dao.daomapper.HibernateSessionFactory;
import learn.online.api.service.servicemapper.Workinfoservice;
import learn.online.common.util.PageBean;
import learn.online.common.vo.Registertable;
import learn.online.common.vo.Workinfo;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Session;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class WorkinfoAction extends ActionSupport implements ModelDriven<Workinfo>
{

	private List<Workinfo> list; 
	
	private Workinfo ci = new Workinfo();
	
	private  Workinfoservice wia;
	
	public void setWia(Workinfoservice wia)
	{
		this.wia = wia;
	}
	
	private PageBean<Workinfo> pageBean; //封装了分页信息和数据内容的pageBean
	private int page = 1; //表示从网页中返回的当前页的值  默认为1 表示默认显示第一页内容
	
	public int getPage() {
	   return page;
	}
	
	public void setPage(int page) {
	     this.page = page;
	}
	
	public PageBean<Workinfo> getPageBean() {
	    return pageBean;
	}
	
	public void setPageBean(PageBean<Workinfo> pageBean) {
	     this.pageBean = pageBean;
	}
	
	
	public Workinfo getModel() {
		// TODO Auto-generated method stub
		return ci;
	}
	
	public java.util.Map<String, Object> getSessionnow()
	{
		java.util.Map<String, Object> session = ActionContext.getContext().getSession();
		return session;
	}
	
	public String getAllworkes()
	{
		Registertable register = (Registertable) getSessionnow().get("register");
		HttpServletRequest request = ServletActionContext.getRequest();
		
		String cid = request.getParameter("cid");
		getSessionnow().put("cidzy", cid);

		String hql = null;
		if(register.getIdentity() == 0)
		{
		   hql = "select Workinfo.zyid,Workinfo.worktitle,Workinfo.other,Workinfo.reviewgrand,Workinfo.reviewtext,Workinfo.reviewtime,Workinfo.studentname,Workinfo.teachername,Workinfo.worktext from Workinfo,Cwrration where Workinfo.zyid = Cwrration.zyid and Cwrration.jid = "+register.getZcid()+" and Cwrration.cid = "+cid;
		}
		else if(register.getIdentity() == 1)
		{
			hql = "select Workinfo.zyid,Workinfo.worktitle,Workinfo.other,Workinfo.reviewgrand,Workinfo.reviewtext,Workinfo.reviewtime,Workinfo.studentname,Workinfo.teachername,Workinfo.worktext from Workinfo,Cwrration where Workinfo.zyid = Cwrration.zyid and Cwrration.sid = "+register.getZcid()+" and Cwrration.cid = "+cid;
		}
		
		//AllNewsservers wia = new AllNewsservers();
		//wia.setDao(new Controlci());
		
		this.pageBean = this.wia.AllClasses(hql,hql,5, page);//获取封装了分页信息和数据的pageBean
		this.list = this.pageBean.getList(); //获取数据

		//list=wia.Allworkes();
		ActionContext ctxt=ActionContext.getContext();
		ctxt.put("allwork", list);
		//request.setAttribute("list",list);
		return "success";
	}
	
	
	public String allapplyworkes()
	{
	    list =wia.allapplyworkes();
	   // HttpServletRequest request = ServletActionContext.getRequest();
	   // request.setAttribute("list",list);
		ActionContext ctxt=ActionContext.getContext();
		ctxt.put("listteacher", list);
		return "success";
	}
	
	public String allchooseworkes()
	{
	    list =wia.allchooseworkes();
	   // HttpServletRequest request = ServletActionContext.getRequest();
	   // request.setAttribute("list",list);
		ActionContext ctxt=ActionContext.getContext();
		ctxt.put("list", list);
		return "success";
	}
	
	public String passAllworkes()
	{
	    list =wia.passAllworkes();
		ActionContext ctxt=ActionContext.getContext();
		ctxt.put("passallwork", list);
		//request.setAttribute("list",list);                                                                                      
		return "success";
	}
	
	public String insertwork()
	{
		
		int cid = Integer.parseInt((String) getSessionnow().get("cidzy"));
		
		boolean flag = wia.insertworkserver(ci);
		if(flag == true)
		   return "success";
		else
			return "fail";
	}
	
	public String deletework()
	{
		
		boolean flag = wia.delectworkserver(ci);
		if(flag == true)
		   return "success";
		else
			return "fail";
	}
	
	public String updatework()
	{
		boolean flag = wia.updateworkserver(ci);
		if(flag == true)
		   return "success";
		else
			return "fail";
	}
	
	public String selectupdatework()
	{
		Workinfo ci1 = wia.selectupdateworkserver(ci.getZyid());
		
		//java.util.Map<String, Object> session = ActionContext.getContext().getSession();
		//session.put("Workinfoxssq",ci1);
		
		
		ActionContext ctxt1=ActionContext.getContext();
		ctxt1.put("selectwork", ci1);
		//getAllworkes();
		return "success";
	}
	
	public String passwork()
	{
		Workinfo ci1 = wia.selectupdateworkserver(ci.getZyid());
		boolean flag = wia.passworkserver(ci1);
		if(flag == true)
		   return "success";
		else
			return "fail";
	}
	
	/*public String selectaboutwork()//û������
	{
		Workinfo ci1 = wia.selectaboutworkserver(ci);
		ActionContext ctxt1=ActionContext.getContext();
		ctxt1.put("selectaboutwork", ci1);
		return "success";
	}
	
	public String getstyleworks()//�������ܣ���ʱ����
	{
		List<Workinfo> list = null;
		HttpServletRequest request = ServletActionContext.getRequest();
		String style = request.getParameter("style");
		list = wia.getstyle(style);
		ActionContext ctxt1=ActionContext.getContext();
		ctxt1.put("stylework", list);
		return "success";
	}*/
}
