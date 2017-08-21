package learn.online.impl.servicemapper.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;






import learn.online.api.service.servicemapper.Forumpostservice;
import learn.online.common.util.PageBean;
import learn.online.common.vo.Foruminfo;
import learn.online.common.vo.Forumpost;
import learn.online.common.vo.Forumrelation;
import learn.online.common.vo.Forumreview;
import learn.online.common.vo.Registertable;
import learn.online.impl.dao.impl.ControlforumpostImp;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;


public class Forumpostserviceimp implements Forumpostservice
{
    private ControlforumpostImp fpi;
    
 //   private ControlForumralationImp fpi;
   
    
	public void setFpi(ControlforumpostImp fpi) {
		this.fpi = fpi;
	}
	
    HttpServletRequest request = ServletActionContext.getRequest();
	 
	public Map<String, Object> getSessionnow()
	{
		Map<String, Object> session = ActionContext.getContext().getSession();
		return session;
	}
	
	//����
	
	public List<Forumpost> Allforumposts() {
		// TODO Auto-generated method stub
		List<Forumpost> list = fpi.queryAll();
		return list;
	}
	
	public PageBean<Forumpost> AllClasses(String sql,String coutsql,int pageSize,int page) {
		// TODO Auto-generated method stub
		int allRow = this.fpi.getAllRowCount(coutsql);  //总记录数
		int totalPage = PageBean.countTatalPage(pageSize, allRow); //总页数
		final int offset = PageBean.countOffset(pageSize, page); //当前页开始记录
		final int length = pageSize; // 每页记录数
		final int currentPage = PageBean.countCurrentPage(page); // 当前页
		List list = this.fpi.queryAll(sql,offset, length);//把分页信息保存到Bean当中
		PageBean<Forumpost> pageBean  = new PageBean<Forumpost>();
		pageBean.setPageSize(pageSize);
		pageBean.setCurrentPage(currentPage);
		pageBean.setAllRow(allRow);
		pageBean.setTotalPage(totalPage);
		pageBean.setList(list);
		//pageBean.init();
		System.out.print(pageBean.getList());
		return pageBean;
	}
	
	public PageBean<Forumreview> AllClassesreview(String sql,String coutsql,int pageSize,int page) {
		// TODO Auto-generated method stub
		int allRow = this.fpi.getAllRowCount(coutsql);  //总记录数
		int totalPage = PageBean.countTatalPage(pageSize, allRow); //总页数
		final int offset = PageBean.countOffset(pageSize, page); //当前页开始记录
		final int length = pageSize; // 每页记录数
		final int currentPage = PageBean.countCurrentPage(page); // 当前页
		List list = this.fpi.queryAll(sql,offset, length);//把分页信息保存到Bean当中
		PageBean<Forumreview> pageBean  = new PageBean<Forumreview>();
		pageBean.setPageSize(pageSize);
		pageBean.setCurrentPage(currentPage);
		pageBean.setAllRow(allRow);
		pageBean.setTotalPage(totalPage);
		pageBean.setList(list);
		//pageBean.init();
		System.out.print(pageBean.getList());
		return pageBean;
	}
	
	public boolean insertforumpostserver(Forumpost an){
		Foruminfo fi = (Foruminfo)getSessionnow().get("Foruminfo");
		Registertable rt = (Registertable)getSessionnow().get("register");
		an.setForuminfo(fi);
		an.setRight(0);
		an.setPosttime(new Date());
		an.setPostman(rt.getYhm());
			fpi.insert(an);
			return true;
	}

	public boolean delectforumpostserver(Forumpost an) {
		// TODO Auto-generated method stub	
		 an = fpi.selectById(an.getFpid());
		  boolean flag = fpi.delete(an);
		  if(flag == true)
		    return true;
		  return false;
	}

	public boolean updateforumpostserver(Forumpost an) {
		// TODO Auto-generated method stub
		boolean flag = fpi.update(an);
		  if(flag == true)
		    return true;
		  return false;
	}

	public Forumpost selectupdateforumpostserver(int i) {
		// TODO Auto-generated method stub
		Forumpost an = fpi.selectById(i);
		return an;
	}

	public boolean passforumpostserver(Forumpost ci) {
		// TODO Auto-generated method stub
		ci.setRight(1);
		boolean flag = fpi.update(ci);
		  if(flag == true)
		    return true;
		  return false;
	}

	public List<Forumpost> passAllforumposts() {
		// TODO Auto-generated method stub
		List<Forumpost> list = null;
		int manage = Integer.parseInt(request.getParameter("manage"));
		if(manage == 0)
		{
			list = fpi.queryAllpassTeacher();
		}
		else if(manage == 1)
		{
			list = fpi.queryAllpassStudent();
		}
		else if(manage == 2)
		{
			list = fpi.queryAllpass();
		}
		return list;
	}

	//����
	
	
	public boolean insertforumreviewserver(Forumreview ci) {
		// TODO Auto-generated method stub
		Forumpost fp = (Forumpost)getSessionnow().get("Forumpost");
		Registertable rt = (Registertable)getSessionnow().get("register");
		ci.setForumpost(fp);
		ci.setForumrman(rt.getYhm());//��Ҫ�׳��쳣��
		ci.setForumrtime(new Date());
		boolean flag = fpi.insertForumReview(ci);
		if(flag)
		{
			return true;
		}
		return false;
	}

	public List<Forumreview> Allforumreviewes() {
		// TODO Auto-generated method stub
		List<Forumreview> list = fpi.queryAllreview();
		return list;
	}
	
	//��̳��ϵ
	
	public boolean insertralationserver(Forumrelation an){
		Foruminfo fi = (Foruminfo)getSessionnow().get("Foruminfo");
	    Registertable registertable = (Registertable)getSessionnow().get("register");	
		if(registertable.getIdentity() == 0)
		{
		   an.setRegistertableByJid(registertable);
		   an.setTforumidentity(1);
		}
		else
		{
			an.setRegistertableBySid(registertable);
			an.setSforumidentity(1);
		}
		   an.setForuminfo(fi);
			fpi.insert(an);
			return true;
	}

	public boolean delectralationserver(Forumrelation an) {
		// TODO Auto-generated method stub
		boolean flag = false;
		Registertable registertable = (Registertable)getSessionnow().get("register");
		String id = request.getParameter("cid");
		int cid = Integer.parseInt(id);
	    Forumrelation cr = fpi.selectByRid(cid);
		if(registertable.getIdentity() == 1)
		{
		   an.setTforumidentity(1);
		   an.setRegistertableByJid(null);
		   an.setSforumidentity(0);
		   an.setForuminfo(cr.getForuminfo());
			an.setId(cr.getId());
			an.setRegistertableByJid(cr.getRegistertableByJid());
			an.setTforumidentity(cr.getTforumidentity());
		    flag = fpi.update(an);
		}
		else
		{
			 an = cr;
			 flag = fpi.delete(an);
		}
		 
		  if(flag == true)
		    return true;
		  return false;
	}

	public boolean updateralationserver(Forumrelation an) {
		// TODO Auto-generated method stub
		boolean flag;
		String id = request.getParameter("fid");
		int fid = Integer.parseInt(id);
		Registertable registertable = (Registertable)getSessionnow().get("register");
		Forumrelation cr = fpi.selectByRid(fid);
		an.setRegistertableBySid(registertable);
		an.setSforumidentity(1);
		an.setForuminfo(cr.getForuminfo());
		an.setId(cr.getId());
		an.setRegistertableByJid(cr.getRegistertableByJid());
		an.setTforumidentity(cr.getTforumidentity());
		if(cr.getRegistertableBySid()!=null)
		{
			fpi.insert(an);
			flag = true;
		}
		else
		{
			flag = fpi.update(an);
		}
		  if(flag == true)
		    return true;
		  return false;
	}

	public Forumrelation selectupdateralationserver(Forumrelation frt) {
		// TODO Auto-generated method stub
		Forumrelation an = fpi.selectById(frt);
		return an;
	}

	public boolean delectforumreviewserver(Forumreview ci) {
		// TODO Auto-generated method stub
		boolean flag = fpi.delete(ci);
		if(flag)
		{
			return true;
		}
		return false;
	}
}