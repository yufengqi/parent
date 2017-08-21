package learn.online.action;

import java.util.List;
import java.util.Map;

import learn.online.api.service.servicemapper.Publicnoticeservice;
import learn.online.common.util.PageBean;
import learn.online.common.vo.Publicnotice;
import learn.online.common.vo.Registertable;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class PublicnoticeAction extends ActionSupport implements ModelDriven<Publicnotice>
{

	private List<Publicnotice> list;
	
	private Publicnotice ci = new Publicnotice();
	
	private  Publicnoticeservice pta;
	
	public void setPta(Publicnoticeservice pta)
	{
		this.pta = pta;
	}
	
	private PageBean<Publicnotice> pageBean; //封装了分页信息和数据内容的pageBean
	private int page = 1; //表示从网页中返回的当前页的值  默认为1 表示默认显示第一页内容
	
	public int getPage() {
	   return page;
	}
	
	public void setPage(int page) {
	     this.page = page;
	}
	
	public PageBean<Publicnotice> getPageBean() {
	    return pageBean;
	}
	
	public void setPageBean(PageBean<Publicnotice> pageBean) {
	     this.pageBean = pageBean;
	}
	
	public Publicnotice getModel() {
		// TODO Auto-generated method stub
		return ci;
	}
	
	public Map<String, Object> getSessionnow()
	{
		Map<String, Object> session = ActionContext.getContext().getSession();
		return session;
	}
	
	public String getAllpublicnoticees()
	{
		
		String sql = "from Publicnotice";
		this.pageBean = this.pta.AllClasses(sql,sql,10, page);//获取封装了分页信息和数据的pageBean
		this.list = this.pageBean.getList(); //获取数据
		
		//AllNewsservers pta = new AllNewsservers();
		//pta.setDao(new Controlci());
		//HttpServletRequest request = ServletActionContext.getRequest();
		//list=pta.Allpublicnoticees();
		ActionContext ctxt=ActionContext.getContext();
		ctxt.put("allpublicnotice", list);
		//request.setAttribute("list",list);
		return "success";
	}
	
	
	public String allapplypublicnoticees()
	{
		Registertable registertable = null;
		String hql = null;
		if(getSessionnow().get("register") instanceof Registertable)
		{
		     registertable = (Registertable)getSessionnow().get("register");
		     hql = "from Publicnotice publicnotice where publicnotice.right = 1 and publicnotice.registertable = " + registertable.getZcid();
		}
		else{
			  hql = "from Publicnotice publicnotice where publicnotice.right = 1 and publicnotice.registertable = null";
		}
		this.pageBean = this.pta.AllClasses(hql,hql,10, page);//获取封装了分页信息和数据的pageBean
		this.list = this.pageBean.getList(); //获取数据
		
	    //list =pta.allapplypublicnoticees();
	   // HttpServletRequest request = ServletActionContext.getRequest();
	   // request.setAttribute("list",list);
		ActionContext ctxt=ActionContext.getContext();
		ctxt.put("publicnoticees", list);
		return "success";
	}
	
	public String getAllpasspublicnoticees()  
	{
	    list =pta.passAllpublicnoticees();
		ActionContext ctxt=ActionContext.getContext();
		ctxt.put("passallpublicnotice", list);
		//request.setAttribute("list",list);                                                                                      
		return "success";
	}
	
	public String insertpublicnotice()
	{
		boolean flag = pta.insertpublicnoticeserver(ci);
		if(flag == true)
		   return "success";
		else
			return "fail";
	}
	
	public String deletepublicnotice()
	{
		boolean flag = pta.delectpublicnoticeserver(ci);
		if(flag == true)
		   return "success";
		else
			return "fail";
	}
	
	public String updatepublicnotice()
	{
		boolean flag = pta.updatepublicnoticeserver(ci);
		if(flag == true)
		   return "success";
		else
			return "fail";
	}
	
	public String selectupdatepublicnotice() //����һ����Ϣ
	{
		Publicnotice ci1 = pta.selectupdatepublicnoticeserver(ci.getGid());
		
		ActionContext ctxt1=ActionContext.getContext();
		ctxt1.put("selectpublicnotice", ci1);
		//getAllpublicnoticees();
		return "success";
	}
	
	public String passpublicnotice()  //ͨ���
	{
		Publicnotice ci1 = pta.selectupdatepublicnoticeserver(ci.getGid());
		boolean flag = pta.passpublicnoticeserver(ci1);
		if(flag == true)
		   return "success";
		else
			return "fail";
	}
}
