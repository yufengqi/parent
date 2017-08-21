package learn.online.impl.servicemapper.impl;

import java.util.List;
import java.util.Map;

import learn.online.api.dao.daomapper.Controlpublicnotice;
import learn.online.api.service.servicemapper.Publicnoticeservice;
import learn.online.common.util.PageBean;
import learn.online.common.vo.Manage;
import learn.online.common.vo.Publicnotice;
import learn.online.common.vo.Registertable;

import com.opensymphony.xwork2.ActionContext;


public class Publicnoticeserviceimp implements Publicnoticeservice
{
    private Controlpublicnotice pti;
	
	public void setPti(Controlpublicnotice pti) {
		this.pti = pti;
	}
	
	public Map<String, Object> getSessionnow()
	{
		Map<String, Object> session = ActionContext.getContext().getSession();
		return session;
	}
	
	public List<Publicnotice> Allpublicnoticees() {
		// TODO Auto-generated method stub
		List<Publicnotice> list = pti.queryAll();
		return list;
	}
	
	public PageBean<Publicnotice> AllClasses(String sql,String coutsql,int pageSize,int page) {
		// TODO Auto-generated method stub
		int allRow = this.pti.getAllRowCount(coutsql);  //总记录数
		int totalPage = PageBean.countTatalPage(pageSize, allRow); //总页数
		final int offset = PageBean.countOffset(pageSize, page); //当前页开始记录
		final int length = pageSize; // 每页记录数
		final int currentPage = PageBean.countCurrentPage(page); // 当前页
		List list = this.pti.queryAll(sql,offset, length);//把分页信息保存到Bean当中
		PageBean<Publicnotice> pageBean  = new PageBean<Publicnotice>();
		pageBean.setPageSize(pageSize);
		pageBean.setCurrentPage(currentPage);
		pageBean.setAllRow(allRow);
		pageBean.setTotalPage(totalPage);
		pageBean.setList(list);
		//pageBean.init();
		System.out.print(pageBean.getList());
		return pageBean;
	}
	
	public boolean insertpublicnoticeserver(Publicnotice an){
		Registertable rt = null;
		Manage mm  = null;
		if(getSessionnow().get("register") instanceof Registertable)
		{
		     rt = (Registertable)getSessionnow().get("register");
		     an.setRegistertable(rt);
		     an.setManage(null);
		}
		else if(getSessionnow().get("register") instanceof Manage)
		{
			mm = (Manage)getSessionnow().get("register");
			an.setManage(mm);
			an.setRegistertable(null);
		}
			pti.insert(an);
			return true;
	}

	public boolean delectpublicnoticeserver(Publicnotice an) {
		// TODO Auto-generated method stub
		// an = pti.selectById(an.getCid());
		  boolean flag = pti.delete(an);
		  if(flag == true)
		    return true;
		  return false;
	}

	public boolean updatepublicnoticeserver(Publicnotice an) {
		// TODO Auto-generated method stub
		Publicnotice ann = pti.selectById(an.getGid());
		an.setManage(ann.getManage());
		an.setRegistertable(ann.getRegistertable());
		an.setRight(ann.getRight());
		boolean flag = pti.update(an);
		  if(flag == true)
		    return true;
		  return false;
	}

	public Publicnotice selectupdatepublicnoticeserver(int i) {
		// TODO Auto-generated method stub
		Publicnotice an = pti.selectById(i);
		return an;
	}

	public boolean passpublicnoticeserver(Publicnotice ci) {
		// TODO Auto-generated method stub
		ci.setRight(1);
		boolean flag = pti.update(ci);
		  if(flag == true)
		    return true;
		  return false;
	}

	public List<Publicnotice> passAllpublicnoticees() {
		// TODO Auto-generated method stub
		List<Publicnotice> list = pti.queryAllapply();
		return list;
	}
	
	public List<Publicnotice> allapplypublicnoticees() {
		// TODO Auto-generated method stub
		List<Publicnotice> list = pti.queryAllpass();
		return list;
	}
}