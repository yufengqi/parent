package learn.online.impl.servicemapper.impl;

import java.util.List;

import learn.online.api.dao.daomapper.ControlUpinfo;
import learn.online.api.service.servicemapper.Upinfoservice;
import learn.online.common.util.PageBean;
import learn.online.common.vo.Upinfo;


public class Upinfoserviceimp implements Upinfoservice
{
    private ControlUpinfo ufi;
	
	public void setUfi(ControlUpinfo ufi) {
		this.ufi = ufi;
	}
	
	public List<Upinfo> Allupinfoes() {
		// TODO Auto-generated method stub
		List<Upinfo> list = ufi.queryAll();
		return list;
	}
	
	public PageBean<Upinfo> AllClasses(String sql,String coutsql,int pageSize,int page) {
		// TODO Auto-generated method stub
		int allRow = this.ufi.getAllRowCount(coutsql);  //总记录数
		int totalPage = PageBean.countTatalPage(pageSize, allRow); //总页数
		final int offset = PageBean.countOffset(pageSize, page); //当前页开始记录
		final int length = pageSize; // 每页记录数
		final int currentPage = PageBean.countCurrentPage(page); // 当前页
		List list = this.ufi.queryAll(sql,offset, length);//把分页信息保存到Bean当中
		PageBean<Upinfo> pageBean  = new PageBean<Upinfo>();
		pageBean.setPageSize(pageSize);
		pageBean.setCurrentPage(currentPage);
		pageBean.setAllRow(allRow);
		pageBean.setTotalPage(totalPage);
		pageBean.setList(list);
		//pageBean.init();
		return pageBean;
	}
	
	public boolean insertupinfoserver(Upinfo an){
			ufi.insert(an);
			return true;
	}

	public boolean delectupinfoserver(Upinfo an) {
		// TODO Auto-generated method stub
		 an = ufi.selectById(an.getId());
		  boolean flag = ufi.delete(an);
		  if(flag == true)
		    return true;
		  return false;
	}

	public boolean updateupinfoserver(Upinfo an) {
		// TODO Auto-generated method stub
		boolean flag = ufi.update(an);
		  if(flag == true)
		    return true;
		  return false;
	}

	public Upinfo selectupdateupinfoserver(int i) {
		// TODO Auto-generated method stub
		Upinfo an = ufi.selectById(i);
		return an;
	}

	public boolean passupinfoserver(Upinfo ci) {
		// TODO Auto-generated method stub
		boolean flag = ufi.update(ci);
		  if(flag == true)
		    return true;
		  return false;
	}

	public List<Upinfo> passAllupinfoes() {
		// TODO Auto-generated method stub
		List<Upinfo> list = ufi.queryAllpass();
		return list;
	}

	public List<Upinfo> allchooseupinfoes() {
		// TODO Auto-generated method stub
		List<Upinfo> list = ufi.queryAllchoose();
		return list;
	}

	public List<Upinfo> allapplyupinfoes() {
		// TODO Auto-generated method stub
		List<Upinfo> list = ufi.queryAllapply();
		return list;
	}

	/*public Upinfo selectaboutupinfoserver(Upinfo an2) {//û��
		// TODO Auto-generated method stub
		Upinfo an = ufi.selectByXid(an2);
		return an;
	}

	public List<Upinfo> getstyle(String style) {//û�� 
		// TODO Auto-generated method stub
		if(style.equals("kj"))
		{
			style = "�Ƽ�";
		}
		else if(style.equals("yl"))
		{
			style = "����";
		}
		List<Upinfo> list = ufi.queryAllstyle(style);
		return list;
	}*/
}