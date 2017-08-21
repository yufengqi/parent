package learn.online.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import learn.online.api.service.servicemapper.Foruminfoservice;
import learn.online.common.util.PageBean;
import learn.online.common.vo.Classinfo;
import learn.online.common.vo.Foruminfo;
import learn.online.common.vo.Registertable;

import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;

import java.util.List;
import java.util.Map;


public class ForumInfoAction extends ActionSupport implements ModelDriven<Foruminfo>
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7581057430938326030L;

	private List<Foruminfo> list;
	
	private Foruminfo ci = new Foruminfo();
	
	private  Foruminfoservice fia;
	
	private int tag ;
	
	private PageBean<Foruminfo> pageBean; //封装了分页信息和数据内容的pageBean
	private int page = 1; //表示从网页中返回的当前页的值  默认为1 表示默认显示第一页内容
	
	public int getTag() {
		return tag;
	}

	public void setTag(int tag) {
		this.tag = tag;
	}
	
	public int getPage() {
	   return page;
	}
	
	public void setPage(int page) {
	     this.page = page;
	}
	
	public PageBean<Foruminfo> getPageBean() {
	    return pageBean;
	}
	
	public void setPageBean(PageBean<Foruminfo> pageBean) {
	     this.pageBean = pageBean;
	}
	
	
	public Foruminfoservice getFia() {
		return fia;
	}

	public void setFia(Foruminfoservice fia) {
		this.fia = fia;
	}

	public Foruminfo getModel() {
		// TODO Auto-generated method stub
		return ci;
	}
	
	public Map<String, Object> getSession1()
	{
		Map<String, Object> session1 = ActionContext.getContext().getSession();
		return session1;
	}
	
	public String getAllForumes()
	{
		String sql  = "select * from Foruminfo";
		this.pageBean = this.fia.AllClasses(sql,sql,10, page);//获取封装了分页信息和数据的pageBean
		this.list = this.pageBean.getList(); //获取数据
		//list=fia.AllForumes();
		ActionContext ctxt=ActionContext.getContext();
		ctxt.put("allForum", list);
		return "success";
	}
	
	public String passAllForumes()
	{
		String sql = "";
		Registertable registertable = (Registertable)getSession1().get("register");
		if(tag == 0)
		{
			sql = "select distinct Foruminfo.fid, Foruminfo.forumman, Foruminfo.forumtitle, Foruminfo.forumtext, Foruminfo.forumtime, Foruminfo.right from Foruminfo,Forumrelation where Foruminfo.fid = Forumrelation.fid and Foruminfo.right = 1 and Forumrelation.tforumidentity = 1 and Forumrelation.jid = "+registertable.getZcid();
		}
		else if(tag == 1)
		{
			//list = ffi.queryAllpassstudent();
			sql = "select distinct Foruminfo.fid, Foruminfo.forumman, Foruminfo.forumtitle, Foruminfo.forumtext, Foruminfo.forumtime, Foruminfo.right from Foruminfo,Forumrelation where Foruminfo.fid = Forumrelation.fid and Foruminfo.right = 1 and Forumrelation.sforumidentity = 1 and Forumrelation.sid = " +registertable.getZcid();
		}
		else if(tag == 3 || tag == 4)
		{
			//list = ffi.queryAllpass();
			sql = "select * from Foruminfo f where f.right = 1";
		}
		
		this.pageBean = this.fia.AllClasses(sql,sql,10, page);//获取封装了分页信息和数据的pageBean
		this.list = this.pageBean.getList(); //获取数据
		
	   //list =fia.passAllForumes();
		ActionContext ctxt=ActionContext.getContext();
		ctxt.put("passallForum", list);
		//request.setAttribute("list",list);
		
		HttpServletRequest request = ServletActionContext.getRequest();
		int tag = Integer.parseInt(request.getParameter("tag"));
		
		if(tag == 0)
		{
			return "success";
		}
		else if(tag == 3)
	    {
	    	return "success-studentapply";
	    }
		else if(tag == 4)
		{
			return "success-forumfirst";
		}
        return "success";
	}
	
	public String insertForum()
	{
		boolean flag = fia.insertForumserver(ci);
		if(flag == true)
		   return "success";
		else
			return "fail";
	}
	
	public String deleteForum()
	{
		boolean flag = fia.delectForumserver(ci);
		if(flag == true)
		   return "success";
		else
			return "fail";
	}
	
	public String updateForum()
	{
		boolean flag = fia.updateForumserver(ci);
		if(flag == true)
		   return "success";
		else
			return "fail";
	}
	
	public String selectupdateForum()
	{
		
		Foruminfo ci1 = fia.selectupdateForumserver(ci.getFid());
		
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("selectForum", ci1);
		
		java.util.Map<String, Object> session = ActionContext.getContext().getSession();
		session.put("Foruminfo",ci1);
		
		if(Integer.parseInt(request.getParameter("first")) == 1)
		{
			return "success-forumfisrtdetailsall";
		}
		else if(Integer.parseInt(request.getParameter("first")) == 2)
		{
			return "success-forumpostall";
		}
		else if(Integer.parseInt(request.getParameter("first")) == 3)
		{
			return "success-forumpostpassTeacher";
			//request.setAttribute("manage", "y");
		}
		else if(Integer.parseInt(request.getParameter("first")) == 4)
		{
			return "success-forumpostpassStudent";
		}
		else if(Integer.parseInt(request.getParameter("first")) == 5)
		{
			return "success-insertforumpost";
		}
		if(Integer.parseInt(request.getParameter("first")) == 6)
		{
			return "success-forumfisrtdetails";
		}
		//ActionContext ctxt1=ActionContext.getContext();
		//ctxt1.put("selectForum", ci1);
		//getAllForumes();
		return "success";
	}
	
	public String passForum()
	{
		Foruminfo ci1 = fia.selectupdateForumserver(ci.getFid());
		boolean flag = fia.passForumserver(ci1);
		if(flag == true)
		   return "success";
		else
			return "fail";
	}
	
	/*public String selectaboutForum()//û������
	{
		Foruminfo ci1 = fia.selectaboutForumserver(ci);
		ActionContext ctxt1=ActionContext.getContext();
		ctxt1.put("selectaboutForum", ci1);
		return "success";
	}
	
	public String getstyleForums()//�������ܣ���ʱ����
	{
		List<Foruminfo> list = null;
		HttpServletRequest request = ServletActionContext.getRequest();
		String style = request.getParameter("style");
		list = fia.getstyle(style);
		ActionContext ctxt1=ActionContext.getContext();
		ctxt1.put("styleForum", list);
		return "success";
	}*/
}
