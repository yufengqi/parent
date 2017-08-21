package learn.online.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import learn.online.api.service.servicemapper.Leavewordinfoservice;
import learn.online.common.vo.Learninfo;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class LearninfoAction extends ActionSupport implements ModelDriven<Learninfo>
{

	private List<Learninfo> list;
	
	private Learninfo ci = new Learninfo();
	
	private  Leavewordinfoservice lia;
	
	public void setLia(Leavewordinfoservice lia)
	{
		this.lia = lia;
	}
	
	public Learninfo getModel() {
		// TODO Auto-generated method stub
		return ci;
	}
	
	public java.util.Map<String, Object> getSessionnow()
	{
		java.util.Map<String, Object> session = ActionContext.getContext().getSession();
		return session;
	}
	
	public String getAlllearninfo()
	{
		list=lia.Alllearninfos();
		HttpServletRequest request = ServletActionContext.getRequest();
		ActionContext ctxt=ActionContext.getContext();
		ctxt.put("allleaveword", list);
		request.setAttribute("allleaveword",list);
		return "success";
	}
	
	public String insertlearninfo()
	{
		boolean flag = lia.insertlearninfoserver(ci);
		if(flag == true)
		   return "success";
		else
			return "fail";
	}
}
