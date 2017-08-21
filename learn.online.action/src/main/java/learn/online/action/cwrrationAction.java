package learn.online.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import learn.online.api.service.servicemapper.Cwrrationservice;
import learn.online.common.vo.Classinfo;
import learn.online.common.vo.Cwrration;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class cwrrationAction extends ActionSupport implements ModelDriven<Cwrration>
{

	private List<Cwrration> list;
	
	private Cwrration cr = new Cwrration();
	
	private Cwrrationservice cra;
	
	public void setCra(Cwrrationservice cra)
	{
		this.cra = cra;
	}
	
	public Cwrration getModel() {
		// TODO Auto-generated method stub
		return cr;
	}
	
	public Map<String, Object> getSessionnow()
	{
		Map<String, Object> session = ActionContext.getContext().getSession();
		return session;
	}
	
	public String getAllralationes()  //û��
	{
		//AllNewsservers cra = new AllNewsservers();
		//cra.setDao(new Controlcr());
		//HttpServletRequest request = ServletActionContext.getRequest();
		list=cra.Allralationes();
		ActionContext ctxt=ActionContext.getContext();
		ctxt.put("allralation", list);
		//request.setAttribute("list",list);
		return "success";
	}
	
	public String passAllralationes()//û��
	{
		list=cra.passAllralationes();
		ActionContext ctxt=ActionContext.getContext();
		ctxt.put("passallralation", list);
		//request.setAttribute("list",list);
		return "success";
	}
	
	public String insertralation()
	{
		boolean flag = cra.insertralationserver(cr);
		if(flag == true)
		   return "success";
		else
			return "fail";
	}
	
	public String deleteralation()
	{
		boolean flag = cra.delectralationserver(cr);
		if(flag == true)
		   return "success";
		else
			return "fail";
	}
	
	
	
	public String updateralation()
	{
		HttpServletRequest request = ServletActionContext.getRequest();
		String zyid = request.getParameter("zyid");
		getSessionnow().put("zyid",zyid);
		
		
		boolean flag = cra.updateralationserver(cr);
		if(flag == true)
		   return "success";
		else
			return "fail";
	}
	
	public String selectupdateralation()
	{
		
	    Classinfo ci = (Classinfo)getSessionnow().get("classinfoxssq");
			
		Cwrration cr1 = cra.selectupdateralationserver(ci);
		
		getSessionnow().put("selectralation",cr1);
		return "success";
	}
	
	/*public String passralation()
	{
		Cwrration cr1 = cra.selectupdateralationserver(cr.getRid());
		boolean flag = cra.passralationserver(cr1);
		if(flag == true)
		   return "success";
		else
			return "fail";
	}*/
	
	/*public String selectaboutclass()//û������
	{
		Cwrration ci1 = cis.selectaboutclassserver(ci);
		ActionContext ctxt1=ActionContext.getContext();
		ctxt1.put("selectaboutclass", ci1);
		return "success";
	}
	
	public String getstyleclasss()//�������ܣ���ʱ����
	{
		List<Cwrration> list = null;
		HttpServletRequest request = ServletActionContext.getRequest();
		String style = request.getParameter("style");
		list = cis.getstyle(style);
		ActionContext ctxt1=ActionContext.getContext();
		ctxt1.put("styleclass", list);
		return "success";
	}*/
}
