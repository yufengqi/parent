package learn.online.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import learn.online.api.service.servicemapper.Replyinfoservice;
import learn.online.common.vo.Replyinfo;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class ReplyinfoAction extends ActionSupport implements ModelDriven<Replyinfo>
{

	private List<Replyinfo> list;
	
	private Replyinfo ci = new Replyinfo();
	
	private  Replyinfoservice ria;
	
	public void setRia(Replyinfoservice ria)
	{
		this.ria = ria;
	}
	
	public Replyinfo getModel() {
		// TODO Auto-generated method stub
		return ci;
	}
	
	public java.util.Map<String, Object> getSessionnow()
	{
		java.util.Map<String, Object> session = ActionContext.getContext().getSession();
		return session;
	}
	
	public String getAllreplyinfoes()
	{
		list=ria.Allreplyinfoes();
		ActionContext ctxt=ActionContext.getContext();
		ctxt.put("allreplyinfo", list);
		return "success";
	}
	
	public String passAllreplyinfoes()
	{
	    list =ria.passAllreplyinfoes();
	    HttpServletRequest request = ServletActionContext.getRequest();
		//ActionContext ctxt=ActionContext.getContext();
		//ctxt.put("passallreplyinfo", list);
		request.setAttribute("passallreplyinfo",list);
		return "success";
	}
	
	public String insertreplyinfo()  //�������������
	{
		boolean flag = ria.insertreplyinfoserver(ci);
		if(flag == true)
		   return "success";
		else
			return "fail";
	}
	
	public String deletereplyinfo()
	{
		boolean flag = ria.delectreplyinfoserver(ci);
		if(flag == true)
		   return "success";
		else
			return "fail";
	}
	
	public String updatereplyinfo()
	{
		boolean flag = ria.updatereplyinfoserver(ci);
		if(flag == true)
		   return "success";
		else
			return "fail";
	}
	
	public String selectupdatereplyinfo()
	{
		Replyinfo ci1 = ria.selectupdatereplyinfoserver(ci.getRpid());
		
		getSessionnow().put("Replyinfoxssq",ci1);
		
		
		ActionContext ctxt1=ActionContext.getContext();
		ctxt1.put("selectreplyinfo", ci1);
		getAllreplyinfoes();
		return "success";
	}
	
	public String passreplyinfo()
	{
		Replyinfo ci1 = ria.selectupdatereplyinfoserver(ci.getRpid());
		boolean flag = ria.passreplyinfoserver(ci1);
		if(flag == true)
		   return "success";
		else
			return "fail";
	}
}
