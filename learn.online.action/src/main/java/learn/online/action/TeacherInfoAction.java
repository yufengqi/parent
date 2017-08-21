package learn.online.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import learn.online.api.service.servicemapper.Teacherinfoservice;
import learn.online.common.util.PageBean;
import learn.online.common.vo.Registertable;
import learn.online.common.vo.Teacherinfo;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class TeacherInfoAction extends ActionSupport implements ModelDriven<Teacherinfo>
{
	private List<Teacherinfo> list;
	
	private Teacherinfo an = new Teacherinfo();
	
	private  Teacherinfoservice ans;
	
	public void setAns(Teacherinfoservice ans)
	{
		this.ans = ans;
	}
	
	private PageBean<Teacherinfo> pageBean; //封装了分页信息和数据内容的pageBean
	private int page = 1; //表示从网页中返回的当前页的值  默认为1 表示默认显示第一页内容
	
	public int getPage() {
	   return page;
	}
	
	public void setPage(int page) {
	     this.page = page;
	}
	
	public PageBean<Teacherinfo> getPageBean() {
	    return pageBean;
	}
	
	public void setPageBean(PageBean<Teacherinfo> pageBean) {
	     this.pageBean = pageBean;
	}
	
	public Teacherinfo getModel() {
		// TODO Auto-generated method stub
		return an;
	}
	
	public String getAllNews()
	{
		Map<String, Object> session = ActionContext.getContext().getSession();
		Registertable rt = (Registertable)session.get("register");
		String hql = "from Teacherinfo t where t.registertable = "+rt.getZcid();
		this.pageBean = this.ans.AllClasses(hql,hql,10, page);//获取封装了分页信息和数据的pageBean
		this.list = this.pageBean.getList(); //获取数据
		
		//AllNewsservers ans = new AllNewsservers();
		//ans.setDao(new ControlAN());
		//HttpServletRequest request = ServletActionContext.getRequest();
		//list=ans.AllNews();
		ActionContext ctxt=ActionContext.getContext();
		ctxt.put("allnews", list);
		//request.setAttribute("list",list);
		return "success";
	}
	
	public String insertnew()
	{
		boolean flag = ans.insertnewserver(an);
		if(flag == true)
		   return "success";
		else
			return "fail";
	}
	
	public String deletenew()
	{
		boolean flag = ans.delectnewserver(an);
		if(flag == true)
		   return "success";
		else
			return "fail";
	}
	
	public String updatenew()
	{
		boolean flag = ans.updatenewserver(an);
		System.out.print("action");
		if(flag == true)
		   return "success";
		else
			return "fail";
	}
	
	public String selectupdatenewbyJid()
	{
		HttpServletRequest request = ServletActionContext.getRequest();
		int jid = Integer.parseInt(request.getParameter("jid"));
		//System.out.println(an.getTid() + an.getNewstitle());///////
		Teacherinfo an1 = ans.selectintroducenewserver(jid);
		
		request.setAttribute("selectshow",an1);
		return "success";
	}
	
	public String selectupdatenew()
	{
		//System.out.println(an.getTid() + an.getNewstitle());///////
		Teacherinfo an1 = ans.selectupdatenewserver(an.getTid());
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("selectshow",an1);
		return "success";
	}
	
}
