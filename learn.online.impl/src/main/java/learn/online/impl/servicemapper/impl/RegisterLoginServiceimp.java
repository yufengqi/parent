package learn.online.impl.servicemapper.impl;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import learn.online.api.dao.daomapper.ControlYH;
import learn.online.api.service.servicemapper.RegisterLoginService;
import learn.online.common.util.PageBean;
import learn.online.common.vo.Manage;
import learn.online.common.vo.Registertable;

import org.apache.struts2.ServletActionContext;








import com.opensymphony.xwork2.ActionContext;



public class RegisterLoginServiceimp implements RegisterLoginService
{
	private ControlYH cyh;
	
	public void setCyh(ControlYH cyh) {
		this.cyh = cyh;
	}

	public boolean login(String custname,String pwd){
		HttpServletRequest request = ServletActionContext.getRequest();
		String xz = request.getParameter("login_in");
		System.out.println("xz= "+xz);
		Registertable cust = null;
		Registertable js = null;
		Manage mg = null;
		if(xz.equals("1"))
		{
		   cust = cyh.selectByNamePwd(custname, pwd,1);
		   if(cust!=null){
				java.util.Map<String, Object> session = ActionContext.getContext().getSession();
				session.put("register",cust);
				session.put("login", "ok");
				return true;
			}else{
				return false;
			}
		}
		else if(xz.equals("2"))
		{
		    mg = cyh.selectByNamePwdmanagement(custname, pwd);
		    if(mg!=null){
				java.util.Map<String, Object> session = ActionContext.getContext().getSession();
				session.put("register",mg);
				session.put("logingl", "ok");
				return true;
			}else{
				return false;
			}
		}
		else if(xz.equals("0"))
		{
			   js = cyh.selectByNamePwd(custname, pwd,0);
			   if(js!=null){
					java.util.Map<String, Object> session = ActionContext.getContext().getSession();
					session.put("register",js);
					session.put("loginjs", "ok");
					return true;
				}else{
					return false;
				}
		}
		return false;
	}
	
	public void register(Registertable cust) //throws RegisterException
	{
		Registertable c=cyh.selectByName(cust.getYhm());
		if(c==null){
			cyh.insert(cust);
			
		}else{
			//throw new RegisterException();
		}
	}
   
   public List<Registertable> AllRegister()
   {
	    // TODO Auto-generated method stub
	    return cyh.queryAll();
   }
   
   public PageBean<Registertable> AllClasses(String sql,String coutsql,int pageSize,int page) {
		// TODO Auto-generated method stub
		int allRow = this.cyh.getAllRowCount(coutsql);  //总记录数
		int totalPage = PageBean.countTatalPage(pageSize, allRow); //总页数
		final int offset = PageBean.countOffset(pageSize, page); //当前页开始记录
		final int length = pageSize; // 每页记录数
		final int currentPage = PageBean.countCurrentPage(page); // 当前页
		List list = this.cyh.queryAll(sql,offset, length);//把分页信息保存到Bean当中
		PageBean<Registertable> pageBean  = new PageBean<Registertable>();
		pageBean.setPageSize(pageSize);
		pageBean.setCurrentPage(currentPage);
		pageBean.setAllRow(allRow);
		pageBean.setTotalPage(totalPage);
		pageBean.setList(list);
		//pageBean.init();
		return pageBean;
   }

   public boolean delectserver(Registertable rtc)
   {
	   // TODO Auto-generated method stub
	  rtc = cyh.selectById(rtc.getZcid());
	  boolean flag = cyh.delete(rtc);
	  if(flag == true)
	    return true;
	  return false;
   }

   public boolean updateserver(Registertable rtc)
   {
	  // TODO Auto-generated method stub 
	   boolean flag = cyh.update(rtc);
		  if(flag == true)
		    return true;
		  return false;
    }

  public Registertable selectupdateserver(int zcid) {
	// TODO Auto-generated method stub
	Registertable c=cyh.selectById(zcid);
	return  c;
  }

}