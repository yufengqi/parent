package learn.online.impl.servicemapper.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import learn.online.api.dao.daomapper.ControlClass;
import learn.online.api.service.servicemapper.Classinfoservice;
import learn.online.common.util.PageBean;
import learn.online.common.vo.Classinfo;
import learn.online.impl.dao.impl.ControlClassImp;

import org.apache.struts2.ServletActionContext;

public class Classinfoserviceimp implements Classinfoservice
{
    private ControlClass cci;
	
	public void setCci(ControlClass cci) {
		this.cci = cci;
	}
	
	public List<Classinfo> AllClasses() {
	     List<Classinfo> list = cci.queryAll();
		 return list;
	}
	
	public PageBean<Classinfo> AllClasses(String sql,String coutsql,int pageSize,int page) {
		// TODO Auto-generated method stub
		int allRow = this.cci.getAllRowCount(coutsql);  //总记录数
		int totalPage = PageBean.countTatalPage(pageSize, allRow); //总页数
		final int offset = PageBean.countOffset(pageSize, page); //当前页开始记录
		final int length = pageSize; // 每页记录数
		final int currentPage = PageBean.countCurrentPage(page); // 当前页
		List list = this.cci.queryAll(sql,offset, length);//把分页信息保存到Bean当中
		PageBean<Classinfo> pageBean  = new PageBean<Classinfo>();
		pageBean.setPageSize(pageSize);
		pageBean.setCurrentPage(currentPage);
		pageBean.setAllRow(allRow);
		pageBean.setTotalPage(totalPage);
		pageBean.setList(list);
		//pageBean.init();
		return pageBean;
	}
	
	public boolean insertclassserver(Classinfo an){
			cci.insert(an);
			return true;
	}

	public boolean delectclassserver(Classinfo an) {
		// TODO Auto-generated method stub
		HttpServletRequest request = ServletActionContext.getRequest();
		 int cid = Integer.parseInt(request.getParameter("cid"));
		 an = cci.selectById(cid);
		  boolean flag = cci.delete(an);
		  if(flag == true)
		    return true;
		  return false;
	}

	public boolean updateclassserver(Classinfo an) {
		// TODO Auto-generated method stub
		boolean flag = cci.update(an);
		  if(flag == true)
		    return true;
		  return false;
	}

	public Classinfo selectupdateclassserver(int i) {
		// TODO Auto-generated method stub
		Classinfo an = cci.selectById(i);
		return an;
	}

	public boolean passclassserver(Classinfo ci) {
		// TODO Auto-generated method stub
		ci.setRight(1);
		boolean flag = cci.update(ci);
		  if(flag == true)
		    return true;
		  return false;
	}

	public List<Classinfo> passAllClasses() {
		// TODO Auto-generated method stub
		List<Classinfo> list = cci.queryAllpass();
		return list;
	}

	public List<Classinfo> allchooseClasses() {
		// TODO Auto-generated method stub
		List<Classinfo> list = cci.queryAllchoose();
		return list;
	}

	public List<Classinfo> allapplyClasses() {
		// TODO Auto-generated method stub
		List<Classinfo> list = cci.queryAllapply();
		return list;
	}


	/*public Classinfo selectaboutclassserver(Classinfo an2) {//û��
		// TODO Auto-generated method stub
		Classinfo an = cci.selectByXid(an2);
		return an;
	}

	public List<Classinfo> getstyle(String style) {//û�� 
		// TODO Auto-generated method stub
		if(style.equals("kj"))
		{
			style = "�Ƽ�";
		}
		else if(style.equals("yl"))
		{
			style = "����";
		}
		List<Classinfo> list = cci.queryAllstyle(style);
		return list;
	}*/
}