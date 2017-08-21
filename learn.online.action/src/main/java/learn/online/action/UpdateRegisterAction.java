package learn.online.action;

import java.util.List;
import java.util.Map;

import learn.online.api.service.servicemapper.RegisterLoginService;
import learn.online.common.util.PageBean;
import learn.online.common.vo.Registertable;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;



public class UpdateRegisterAction implements ModelDriven<Registertable>
{	
	private Registertable rtc = new Registertable();
	
	private List<Registertable>list;
	
	private RegisterLoginService ura ;
	
	public void setUra(RegisterLoginService ura)
	{
		this.ura = ura;
	}
	
	private PageBean<Registertable> pageBean; //封装了分页信息和数据内容的pageBean
	private int page = 1; //表示从网页中返回的当前页的值  默认为1 表示默认显示第一页内容
	
	public int getPage() {
	   return page;
	}
	
	public void setPage(int page) {
	     this.page = page;
	}
	
	public PageBean<Registertable> getPageBean() {
	    return pageBean;
	}
	
	public void setPageBean(PageBean<Registertable> pageBean) {
	     this.pageBean = pageBean;
	}
	
	//private HttpServletRequest request;
	
	public Registertable getModel() {
		// TODO Auto-generated method stub
		return rtc;
	}
	
	public String AGexecute()
	{
		String sql = "select * from Registertable";
		this.pageBean = this.ura.AllClasses(sql,sql,10, page);//获取封装了分页信息和数据的pageBean
		this.list = this.pageBean.getList(); //获取数据
		
		//list=ura.AllRegister();
		ActionContext ctxt=ActionContext.getContext();
		ctxt.put("allcustomers1", list);
		return "success";
	}
	
	public String delete()
	{
		boolean flag = ura.delectserver(rtc);
		if(flag == true)
		   return "success";
		else
			return "fail";
	}
	
	public String update()
	{
		boolean flag = ura.updateserver(rtc);
		System.out.print("action");
		if(flag == true)
		   return "success";
		else
			return "fail";
	}
	
	public String selectupdate()
	{
		Map<String, Object> session = ActionContext.getContext().getSession();
		rtc = (Registertable) (session.get("register"));
		Registertable rtc1 = ura.selectupdateserver(rtc.getZcid());
		ActionContext ctxt1=ActionContext.getContext();
		ctxt1.put("register", rtc1);
		return "success";
	}
}