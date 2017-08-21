package learn.online.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import learn.online.common.util.PageBean;
import learn.online.common.vo.Forumpost;
import learn.online.common.vo.Forumreview;
import learn.online.impl.servicemapper.impl.Forumpostserviceimp;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class ForumreviewAction extends ActionSupport implements ModelDriven<Forumreview>
{

	private List<Forumreview> list;
	
	private Forumreview ci = new Forumreview();
	
	private  Forumpostserviceimp fma;
	
	public void setFma(Forumpostserviceimp fma)
	{
		this.fma = fma;
	}
	
	private PageBean<Forumreview> pageBean; //封装了分页信息和数据内容的pageBean
	private int page = 1; //表示从网页中返回的当前页的值  默认为1 表示默认显示第一页内容
	
	public int getPage() {
	   return page;
	}
	
	public void setPage(int page) {
	     this.page = page;
	}
	
	public PageBean<Forumreview> getPageBean() {
	    return pageBean;
	}
	
	public void setPageBean(PageBean<Forumreview> pageBean) {
	     this.pageBean = pageBean;
	}
	
	public Forumreview getModel() {
		// TODO Auto-generated method stub
		return ci;
	}
	
	public java.util.Map<String, Object> getSessionnow()
	{
		java.util.Map<String, Object> session = ActionContext.getContext().getSession();
		return session;
	}
	
	public String getAllforumreviewes()
	{
		Forumpost fp = (Forumpost)getSessionnow().get("Forumpost");
		String sql = "from Forumreview fr where fr.forumpost = " + fp.getFpid();
		
		this.pageBean = this.fma.AllClassesreview(sql,sql,10, page);//获取封装了分页信息和数据的pageBean
		this.list = this.pageBean.getList(); //获取数据
		
		HttpServletRequest request = ServletActionContext.getRequest();
		//int i = Integer.parseInt(request.getParameter("fpid"));
		//list=fma.Allforumreviewes();
		//ActionContext ctxt=ActionContext.getContext();
		//ctxt.put("allforumreview", list);
		request.setAttribute("allforumreview",list);
		return "success";
	}
	
	public String insertforumreview()
	{
		boolean flag = fma.insertforumreviewserver(ci);
		if(flag == true)
		   return "success";
		else
			return "fail";
	}
	
	public String deleteforumreview()
	{
		boolean flag = fma.delectforumreviewserver(ci);
		if(flag == true)
		   return "success";
		else
			return "fail";
	}
}
