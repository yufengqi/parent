package learn.online.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import learn.online.common.util.PageBean;
import learn.online.common.vo.Foruminfo;
import learn.online.common.vo.Forumpost;
import learn.online.common.vo.Registertable;
import learn.online.impl.servicemapper.impl.Forumpostserviceimp;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class ForumPostAction extends ActionSupport implements ModelDriven<Forumpost>
{

	private List<Forumpost> list;
	
	private Forumpost ci = new Forumpost();
	
	private  Forumpostserviceimp fpa;
	
	public void setFpa(Forumpostserviceimp fpa)
	{
		this.fpa = fpa;
	}
	
	private PageBean<Forumpost> pageBean; //封装了分页信息和数据内容的pageBean
	private int page = 1; //表示从网页中返回的当前页的值  默认为1 表示默认显示第一页内容
	
	public int getPage() {
	   return page;
	}
	
	public void setPage(int page) {
	     this.page = page;
	}
	
	public PageBean<Forumpost> getPageBean() {
	    return pageBean;
	}
	
	public void setPageBean(PageBean<Forumpost> pageBean) {
	     this.pageBean = pageBean;
	}
	
	public Forumpost getModel() {
		// TODO Auto-generated method stub
		return ci;
	}
	
	public java.util.Map<String, Object> getSessionnow()
	{
		java.util.Map<String, Object> session = ActionContext.getContext().getSession();
		return session;
	}
	
	public String getAllforumposts()
	{
        Foruminfo fi = (Foruminfo)getSessionnow().get("Foruminfo");

		String sql  = "from Forumpost fp where fp.foruminfo = " + fi.getFid();
		this.pageBean = this.fpa.AllClasses(sql,sql,10, page);//获取封装了分页信息和数据的pageBean
		this.list = this.pageBean.getList(); //获取数据
		
		
		//list=fpa.Allforumposts();
		//HttpServletRequest request = ServletActionContext.getRequest();
		ActionContext ctxt=ActionContext.getContext();
		ctxt.put("allforumpost", list);
		//request.setAttribute("allforumpost",list);
		return "success";
	}
	
	public String passAllforumposts()
	{
		 String sql  = "";
		Foruminfo fi = (Foruminfo)getSessionnow().get("Foruminfo");
		Registertable rt = (Registertable)getSessionnow().get("register");
		HttpServletRequest request = ServletActionContext.getRequest();
	    list =fpa.passAllforumposts();
	    int manage = Integer.parseInt(request.getParameter("manage"));
	    
	    if(manage == 0)
		{
			sql = "from Forumpost fp where fp.right = 1 and fp.foruminfo = "+ fi.getFid()+"and fp.postman = "+ "'"+rt.getYhm()+"'";
		}
		else if(manage == 1)
		{
			sql = "from Forumpost fp where fp.right = 1 and fp.foruminfo = "+ fi.getFid()+"and fp.postman = "+"'"+rt.getYhm()+"'";
		}
		else if(manage == 2)
		{
			sql = "from Forumpost fp where fp.right = 1 and fp.foruminfo = "+ fi.getFid();
		}

		this.pageBean = this.fpa.AllClasses(sql,sql,10, page);//获取封装了分页信息和数据的pageBean
		this.list = this.pageBean.getList(); //获取数据
	    
	    
		ActionContext ctxt=ActionContext.getContext();
		ctxt.put("passallforumpost", list);
		//request.setAttribute("list",list);
		
		if(manage == 2)
		{
			return "success-allpost";
		}
		return "success";
		
	}
	
	public String insertforumpost()
	{
		boolean flag = fpa.insertforumpostserver(ci);
		if(flag == true)
		   return "success";
		else
			return "fail";
	}
	
	public String deleteforumpost()
	{
		boolean flag = fpa.delectforumpostserver(ci);
		if(flag == true)
		   return "success";
		else
			return "fail";
	}
	
	public String updateforumpost()
	{
		boolean flag = fpa.updateforumpostserver(ci);
		if(flag == true)
		   return "success";
		else
			return "fail";
	}
	
	public String selectupdateforumpost()
	{	
		Forumpost ci1 = fpa.selectupdateforumpostserver(ci.getFpid());
		HttpServletRequest request = ServletActionContext.getRequest();
		getSessionnow().put("Forumpost",ci1);
		request.setAttribute("selectforumpost",list);
		if(Integer.parseInt(request.getParameter("review"))==1)
		{
			return "success-reviewall";
		}
		
		//ActionContext ctxt1=ActionContext.getContext();
		//ctxt1.put("selectforumpost", ci1);
		//getAllforumposts();

		return "success";
	}
	
	public String passforumpost()
	{
		Forumpost ci1 = fpa.selectupdateforumpostserver(ci.getFpid());
		
		boolean flag = fpa.passforumpostserver(ci1);
		if(flag == true)
		   return "success";
		else
			return "fail";
	}
}
