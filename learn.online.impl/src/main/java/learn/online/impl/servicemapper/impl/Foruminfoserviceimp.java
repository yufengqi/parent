package learn.online.impl.servicemapper.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import learn.online.api.service.servicemapper.Foruminfoservice;
import learn.online.common.util.PageBean;
import learn.online.common.vo.Foruminfo;
import learn.online.impl.dao.impl.ControlForumImp;

import org.apache.struts2.ServletActionContext;


public class Foruminfoserviceimp implements Foruminfoservice
{
    private ControlForumImp ffi;
	
	public void setFfi(ControlForumImp ffi) {
		this.ffi = ffi;
	}
	
	public List<Foruminfo> AllForumes() {
		// TODO Auto-generated method stub
		List<Foruminfo> list = ffi.queryAll();
		return list;
	}
	
	public PageBean<Foruminfo> AllClasses(String sql,String coutsql,int pageSize,int page) {
		// TODO Auto-generated method stub
		int allRow = this.ffi.getAllRowCount(coutsql);  //总记录数
		int totalPage = PageBean.countTatalPage(pageSize, allRow); //总页数
		final int offset = PageBean.countOffset(pageSize, page); //当前页开始记录
		final int length = pageSize; // 每页记录数
		final int currentPage = PageBean.countCurrentPage(page); // 当前页
		List list = this.ffi.queryAll(sql,offset, length);//把分页信息保存到Bean当中
		PageBean<Foruminfo> pageBean  = new PageBean<Foruminfo>();
		pageBean.setPageSize(pageSize);
		pageBean.setCurrentPage(currentPage);
		pageBean.setAllRow(allRow);
		pageBean.setTotalPage(totalPage);
		pageBean.setList(list);
		//pageBean.init();
		System.out.print(pageBean.getList());
		return pageBean;
	}
	
	public boolean insertForumserver(Foruminfo an){
		Date time = new Date();
		Date t = null;
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
		try {
			t = sd.parse(sd.format(time));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		an.setForumtime(t);
		
			ffi.insert(an);
			return true;
	}

	public boolean delectForumserver(Foruminfo an) {
		// TODO Auto-generated method stub
		 an = ffi.selectById(an.getFid());
		  boolean flag = ffi.delete(an);
		  if(flag == true)
		    return true;
		  return false;
	}

	public boolean updateForumserver(Foruminfo an) {
		// TODO Auto-generated method stub
		an.setRight(1);
		boolean flag = ffi.update(an);
		  if(flag == true)
		    return true;
		  return false;
	}

	public Foruminfo selectupdateForumserver(int i) {
		// TODO Auto-generated method stub
		Foruminfo an = ffi.selectById(i);
		return an;
	}

	public boolean passForumserver(Foruminfo ci) {
		// TODO Auto-generated method stub
		ci.setRight(1);
		boolean flag = ffi.update(ci);
		  if(flag == true)
		    return true;
		  return false;
	}

	public List<Foruminfo> passAllForumes() {
		// TODO Auto-generated method stub
		List<Foruminfo> list = null;
		HttpServletRequest request = ServletActionContext.getRequest();
		int tag = Integer.parseInt(request.getParameter("tag"));
		if(tag == 0)
		{
			list = ffi.queryAllpassteacher();
		}
		else if(tag == 1)
		{
			list = ffi.queryAllpassstudent();
		}
		else if(tag == 3 || tag == 4)
		{
			list = ffi.queryAllpass();
		}
		return list;
	}
}