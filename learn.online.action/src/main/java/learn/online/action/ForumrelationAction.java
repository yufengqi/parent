package learn.online.action;

import java.util.List;
import java.util.Map;

import learn.online.common.vo.Classinfo;
import learn.online.common.vo.Forumrelation;
import learn.online.impl.servicemapper.impl.Forumpostserviceimp;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class ForumrelationAction extends ActionSupport implements ModelDriven<Forumrelation>
{

	private List<Forumrelation> list;
	
	private Forumrelation cr = new Forumrelation();
	
	private Forumpostserviceimp fra;
	
	public void setFra(Forumpostserviceimp fra)
	{
		this.fra = fra;
	}
	
	public Forumrelation getModel() {
		// TODO Auto-generated method stub
		return cr;
	}
	
	
	public String insertralation()
	{
		boolean flag = fra.insertralationserver(cr);
		if(flag == true)
		   return "success";
		else
			return "fail";
	}
	
	public String deleteralation()
	{
		
		boolean flag = fra.delectralationserver(cr);
		if(flag == true)
		   return "success";
		else
			return "fail";
	}
	
	
	
	public String updateralation()
	{
		boolean flag = fra.updateralationserver(cr);
		if(flag == true)
		   return "success";
		else
			return "fail";
	}
	
	public String selectupdateralation()
	{
		 Map<String, Object> session = ActionContext.getContext().getSession();
	     Classinfo ci = (Classinfo)session.get("classinfoxssq");
			
		//Forumrelation cr1 = fra.selectupdateralationserver(ci);
		
		
		java.util.Map<String, Object> session1 = ActionContext.getContext().getSession();
	//	session1.put("selectralation",cr1);
		return "success";
	}
}
