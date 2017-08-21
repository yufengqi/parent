package learn.online.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import learn.online.api.service.servicemapper.Classinfoservice;
import learn.online.common.util.PageBean;
import learn.online.common.vo.Classinfo;
import learn.online.common.vo.Registertable;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class ClassInfoAction extends ActionSupport implements ModelDriven<Classinfo>
{

	private List<Classinfo> list;
	private Classinfo ci = new Classinfo();
	
	private  Classinfoservice cia;
	private PageBean<Classinfo> pageBean; //封装了分页信息和数据内容的pageBean
	private int page = 1; //表示从网页中返回的当前页的值  默认为1 表示默认显示第一页内容
	
	public int getPage() {
	   return page;
	}
	
	public void setPage(int page) {
	     this.page = page;
	}
	
	public PageBean<Classinfo> getPageBean() {
	    return pageBean;
	}
	
	public void setPageBean(PageBean<Classinfo> pageBean) {
	     this.pageBean = pageBean;
	}
	
	public List<Classinfo> getList() {
		return list;
	}
	public void setList(List<Classinfo> list) {
		this.list = list;
	}
	
	public void setCia(Classinfoservice cia)
	{
		this.cia = cia;
	}
	
	public Map<String, Object> getSession1()
	{
		Map<String, Object> session1 = ActionContext.getContext().getSession();
		return session1;
	}
	
	public Classinfo getModel() {
		// TODO Auto-generated method stub
		return ci;
	}
	
	public java.util.Map<String, Object>  getSessionnow()
	{
		java.util.Map<String, Object> session = ActionContext.getContext().getSession();
		return session;
	}
	
	
	public String getAllclasses()
	{
		String sql = "select * from Classinfo";
		this.pageBean = this.cia.AllClasses(sql,sql,10, page);//获取封装了分页信息和数据的pageBean
		this.list = this.pageBean.getList(); //获取数据

		//AllNewsservers cia = new AllNewsservers();
		//cia.setDao(new Controlci());
		//HttpServletRequest request = ServletActionContext.getRequest();
		//list=cia.AllClasses();
		ActionContext ctxt=ActionContext.getContext();
		ctxt.put("allclass", list);
		//request.setAttribute("list",list);
		return "success";
	}
	
	
	public String allapplyclasses()
	{
		
		Registertable registertable = (Registertable)getSession1().get("register");
	    String sql = "select distinct Classinfo.cid, Classinfo.classname, Classinfo.classtime, Classinfo.classplan, Classinfo.classbook, Classinfo.classexam, Classinfo.classneedbase, Classinfo.classwork, Classinfo.classimage, Classinfo.classlink,Classinfo.right from Classinfo,Cwrration where Classinfo.cid = Cwrration.cid and Classinfo.right = 1 and Cwrration.tclassidentity = 1 and Cwrration.jid = "+registertable.getZcid();
		
		this.pageBean = this.cia.AllClasses(sql,sql,5, page);//获取封装了分页信息和数据的pageBean
		this.list = this.pageBean.getList(); //获取数据
		
	   // list =cia.allapplyClasses();
	   // HttpServletRequest request = ServletActionContext.getRequest();
	   // request.setAttribute("list",list);
		ActionContext ctxt=ActionContext.getContext();
		ctxt.put("listteacher", list);
		return "success";
	}
	
	public String allchooseclasses()
	{
		
		Registertable registertable = (Registertable)getSession1().get("register");
	    String sql = "select distinct Classinfo.cid, Classinfo.classname, Classinfo.classtime, Classinfo.classplan, Classinfo.classbook, Classinfo.classexam, Classinfo.classneedbase, Classinfo.classwork, Classinfo.classimage,  Classinfo.classlink ,Classinfo.right from Classinfo,Cwrration where Classinfo.cid = Cwrration.cid and Classinfo.right = 1 and Cwrration.sclassindentity = 1 and Cwrration.sid = "+registertable.getZcid();
		
		this.pageBean = this.cia.AllClasses(sql,sql,5, page);//获取封装了分页信息和数据的pageBean
		this.list = this.pageBean.getList(); //获取数据
		
	    list =cia.allchooseClasses();
	   // HttpServletRequest request = ServletActionContext.getRequest();
	   // request.setAttribute("list",list);
		ActionContext ctxt=ActionContext.getContext();
		ctxt.put("list", list);
		return "success";
	}
	
	public String passAllclasses()
	{
		String sql = "select * from Classinfo classinfo where classinfo.right = 1";
		this.pageBean = this.cia.AllClasses(sql,sql,6, page);//获取封装了分页信息和数据的pageBean
		this.list = this.pageBean.getList(); //获取数据
	   // list =cia.passAllClasses();
		ActionContext ctxt=ActionContext.getContext();
		ctxt.put("passallclass", list);
		//request.setAttribute("list",list);                                                                                      
		return "success";
	}
	
	public String insertclass()
	{
		boolean flag = cia.insertclassserver(ci);
		if(flag == true)
		   return "success";
		else
			return "fail";
	}
	
	public String deleteclass()
	{
		boolean flag = cia.delectclassserver(ci);
		if(flag == true)
		   return "success";
		else
			return "fail";
	}
	
	public String updateclass()
	{
		boolean flag = cia.updateclassserver(ci);
		if(flag == true)
		   return "success";
		else
			return "fail";
	}
	
	public String selectupdateclass()
	{
		Classinfo ci1 = null;
		if(ci.getCid()!=0)
		{
			ci1 = cia.selectupdateclassserver(ci.getCid());
		}
		else 
		{  
			Classinfo ci2 = (Classinfo) getSessionnow().get("classinfoxssq");
			ci1 = cia.selectupdateclassserver(ci2.getCid());
		}
		   
		    
		getSessionnow().put("classinfoxssq",ci1);
		
		
		ActionContext ctxt1=ActionContext.getContext();
		ctxt1.put("selectclass", ci1);
		
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("selectclass",ci1);
		return "success";
	}
	
	public String passclass()
	{
		Classinfo ci1 = cia.selectupdateclassserver(ci.getCid());
		boolean flag = cia.passclassserver(ci1);
		if(flag == true)
		   return "success";
		else
			return "fail";
	}
	
	/*public String selectaboutclass()//û������
	{
		Classinfo ci1 = cia.selectaboutclassserver(ci);
		ActionContext ctxt1=ActionContext.getContext();
		ctxt1.put("selectaboutclass", ci1);
		return "success";
	}
	
	public String getstyleclasss()//�������ܣ���ʱ����
	{
		List<Classinfo> list = null;
		HttpServletRequest request = ServletActionContext.getRequest();
		String style = request.getParameter("style");
		list = cia.getstyle(style);
		ActionContext ctxt1=ActionContext.getContext();
		ctxt1.put("styleclass", list);
		return "success";
	}*/
}
