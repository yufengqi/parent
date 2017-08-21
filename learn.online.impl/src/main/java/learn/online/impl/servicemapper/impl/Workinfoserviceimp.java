package learn.online.impl.servicemapper.impl;

import java.util.List;

import learn.online.api.dao.daomapper.ControlWork;
import learn.online.api.service.servicemapper.Workinfoservice;
import learn.online.common.util.PageBean;
import learn.online.common.vo.Workinfo;

import com.opensymphony.xwork2.ActionContext;

public class Workinfoserviceimp implements Workinfoservice
{
    private ControlWork wfi;
    
	public void setWfi(ControlWork wfi) {
		this.wfi = wfi;
	}
	
	public java.util.Map<String, Object> getSessionnow()
	{
		java.util.Map<String, Object> session = ActionContext.getContext().getSession();
		return session;
	}
	
	public List<Workinfo> Allworkes() {
		// TODO Auto-generated method stub
		List<Workinfo> list = wfi.queryAll();
		return list;
	}
	
	public PageBean<Workinfo> AllClasses(String sql,String coutsql,int pageSize,int page) {
		// TODO Auto-generated method stub
		int allRow = this.wfi.getAllRowCount(coutsql);  //总记录数
		int totalPage = PageBean.countTatalPage(pageSize, allRow); //总页数
		final int offset = PageBean.countOffset(pageSize, page); //当前页开始记录
		final int length = pageSize; // 每页记录数
		final int currentPage = PageBean.countCurrentPage(page); // 当前页
		List list = this.wfi.queryAll(sql,offset, length);//把分页信息保存到Bean当中
		PageBean<Workinfo> pageBean  = new PageBean<Workinfo>();
		pageBean.setPageSize(pageSize);
		pageBean.setCurrentPage(currentPage);
		pageBean.setAllRow(allRow);
		pageBean.setTotalPage(totalPage);
		pageBean.setList(list);
		//pageBean.init();
		return pageBean;
	}
	
	public boolean insertworkserver(Workinfo an){
			wfi.insert(an);
			return true;
	}

	public boolean delectworkserver(Workinfo an) {
		// TODO Auto-generated method stub
		
		int zyid = Integer.parseInt((String) getSessionnow().get("zyid"));
		an = wfi.selectById(zyid);
		 
		  boolean flag = wfi.delete(an);
		  if(flag == true)
		    return true;
		  return false;
	}

	public boolean updateworkserver(Workinfo an) {
		// TODO Auto-generated method stub
		boolean flag = wfi.update(an);
		  if(flag == true)
		    return true;
		  return false;
	}

	public Workinfo selectupdateworkserver(int i) {
		// TODO Auto-generated method stub
		Workinfo an = wfi.selectById(i);
		return an;
	}

	public boolean passworkserver(Workinfo ci) {
		// TODO Auto-generated method stub
		//ci.setRight(1);
		boolean flag = wfi.update(ci);
		  if(flag == true)
		    return true;
		  return false;
	}

	public List<Workinfo> passAllworkes() {
		// TODO Auto-generated method stub
		List<Workinfo> list = wfi.queryAllpass();
		return list;
	}

	public List<Workinfo> allchooseworkes() {
		// TODO Auto-generated method stub
		List<Workinfo> list = wfi.queryAllchoose();
		return list;
	}

	public List<Workinfo> allapplyworkes() {
		// TODO Auto-generated method stub
		List<Workinfo> list = wfi.queryAllapply();
		return list;
	}

	/*public Workinfo selectaboutworkserver(Workinfo an2) {//û��
		// TODO Auto-generated method stub
		Workinfo an = wfi.selectByXid(an2);
		return an;
	}

	public List<Workinfo> getstyle(String style) {//û�� 
		// TODO Auto-generated method stub
		if(style.equals("kj"))
		{
			style = "�Ƽ�";
		}
		else if(style.equals("yl"))
		{
			style = "����";
		}
		List<Workinfo> list = wfi.queryAllstyle(style);
		return list;
	}*/
}