package learn.online.action;

import java.util.List;

import learn.online.api.service.servicemapper.Viewservice;
import learn.online.common.util.PageBean;
import learn.online.common.vo.TeacherId;



import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class TeacherAction extends ActionSupport implements ModelDriven<TeacherId>
{

	private List<TeacherId> list;
	
	private TeacherId ci = new TeacherId();
	
	private  Viewservice ta;
	
	public void setTa(Viewservice ta)
	{
		this.ta = ta;
	}
	
	private PageBean<TeacherId> pageBean; //封装了分页信息和数据内容的pageBean
	private int page = 1; //表示从网页中返回的当前页的值  默认为1 表示默认显示第一页内容
	
	public int getPage() {
	   return page;
	}
	
	public void setPage(int page) {
	     this.page = page;
	}
	
	public PageBean<TeacherId> getPageBean() {
	    return pageBean;
	}
	
	public void setPageBean(PageBean<TeacherId> pageBean) {
	     this.pageBean = pageBean;
	}
	
	public TeacherId getModel() {
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
		
		String hql = "select DISTINCT * from Teacher ";
		this.pageBean = this.ta.AllClasses(hql,hql,10, page);//获取封装了分页信息和数据的pageBean
		this.list = this.pageBean.getList(); //获取数据
		
		//AllNewsservers ta = new AllNewsservers();
		//ta.setDao(new Controlci());
		//HttpServletRequest request = ServletActionContext.getRequest();
		//list=ta.AllTeacher();
		//ActionContext ctxt=ActionContext.getContext();
		//ctxt.put("allTeacherId", list);
		//request.setAttribute("list",list);
		
		getSessionnow().put("teacher", list);
		
		return "success";
	}
	
}
