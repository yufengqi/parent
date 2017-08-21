package learn.online.action;

import java.util.List;

import learn.online.api.service.servicemapper.Viewservice;
import learn.online.common.vo.StudentId;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class StudentAction extends ActionSupport implements ModelDriven<StudentId>
{

	private List<StudentId> list;
	
	private StudentId ci = new StudentId();
	
	private  Viewservice sa;
	
	public void setSa(Viewservice sa)
	{
		this.sa = sa;
	}
	
	public StudentId getModel() {
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
		//AllNewsservers sa = new AllNewsservers();
		//sa.setDao(new Controlci());
		//HttpServletRequest request = ServletActionContext.getRequest();
		list=sa.AllClasses();
		//ActionContext ctxt=ActionContext.getContext();
		//ctxt.put("allclass", list);
		
		getSessionnow().put("Student", list);
		
		return "success";
	}
	
}
