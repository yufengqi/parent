package learn.online.impl.servicemapper.impl;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import learn.online.api.dao.daomapper.Controlralation;
import learn.online.api.service.servicemapper.Cwrrationservice;
import learn.online.common.util.PageBean;
import learn.online.common.vo.Classinfo;
import learn.online.common.vo.Cwrration;
import learn.online.common.vo.Registertable;
import learn.online.common.vo.Workinfo;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;



public class Cwrrationserviceimp implements Cwrrationservice
{
    private Controlralation csi;
    
    Map<String, Object> session = ActionContext.getContext().getSession();
    HttpServletRequest request = ServletActionContext.getRequest();
	
	
	public void setCsi(Controlralation csi) {
		this.csi = csi;
	}
	
	
	public List<Cwrration> Allralationes() {
		// TODO Auto-generated method stub
		List<Cwrration> list = csi.queryAll();
		return list;
	}
	
	public PageBean<Cwrration> AllClasses(String sql,String coutsql,int pageSize,int page) {
		// TODO Auto-generated method stub
		int allRow = this.csi.getAllRowCount(coutsql);  //总记录数
		int totalPage = PageBean.countTatalPage(pageSize, allRow); //总页数
		final int offset = PageBean.countOffset(pageSize, page); //当前页开始记录
		final int length = pageSize; // 每页记录数
		final int currentPage = PageBean.countCurrentPage(page); // 当前页
		List list = this.csi.queryAll(sql,offset, length);//把分页信息保存到Bean当中
		PageBean<Cwrration> pageBean  = new PageBean<Cwrration>();
		pageBean.setPageSize(pageSize);
		pageBean.setCurrentPage(currentPage);
		pageBean.setAllRow(allRow);
		pageBean.setTotalPage(totalPage);
		pageBean.setList(list);
		//pageBean.init();
		System.out.print(pageBean.getList());
		return pageBean;
	}
	
	public boolean insertralationserver(Cwrration an){
			Classinfo ci = (Classinfo)session.get("Classinfo");
			Registertable registertable = (Registertable)session.get("register");	
		if(registertable.getIdentity() == 0)
		{
		   an.setRegistertableByJid(registertable);
		   an.setTclassidentity(1);
		}
		else
		{
			an.setRegistertableBySid(registertable);
			an.setSclassindentity(1);
		}
		   an.setClassinfo(ci);
			csi.insert(an);
			return true;
	}

	public boolean delectralationserver(Cwrration an) {
		// TODO Auto-generated method stub
		boolean flag = false;
		Registertable registertable = (Registertable)session.get("register");
		String id = request.getParameter("cid");
		int cid = Integer.parseInt(id);
	    Cwrration cr = csi.selectByRiddelete(registertable.getZcid(),cid,registertable.getIdentity());
		if(registertable.getIdentity() == 1)
		{
		   an.setTclassidentity(1);
		   an.setRegistertableBySid(null);
			an.setSclassindentity(0);
			an.setClassinfo(cr.getClassinfo());
			an.setRid(cr.getRid());
			an.setRegistertableByJid(cr.getRegistertableByJid());
			an.setTclassidentity(cr.getTclassidentity());
		    flag = csi.update(an);
		}
		else
		{
			  an.setTclassidentity(0);
			   an.setRegistertableBySid(null);
				an.setSclassindentity(0);
				an.setClassinfo(cr.getClassinfo());
				an.setRid(cr.getRid());
				an.setRegistertableByJid(null);
				an.setTclassidentity(0);
			 flag = csi.delete(an);
		}
		 
		  if(flag == true)
		    return true;
		  return false;
	}

	public boolean updateralationserver(Cwrration an) {
		// TODO Auto-generated method stub
		boolean flag;
		int cid = 0;
		//int tt = 0;
		String id = request.getParameter("cid");
		int zyid = 0;
		Cwrration cr = null;
		
		Registertable registertable = (Registertable)session.get("register");
		Workinfo wi = (Workinfo)session.get("Workinfo");
		
		
		if(id == null)
		{
			cid = Integer.parseInt((String) session.get("cidzy"));
		//	tt = 1;
			if(zyid !=0)
			{
				zyid = Integer.parseInt((String) session.get("zyid"));
				cr = csi.selectByRid(registertable.getZcid(),cid,zyid);
				
			}
			else
			{
				cr = csi.selectByRidall(cid);
			}
		}
		else
		{
			cid = Integer.parseInt(id);
			cr = csi.selectByRidall(cid);
		}
		
		if(wi != null)
		{
			an.setWorkinfo(wi);
		}
		else
		{
			an.setWorkinfo(null);
		}
		an.setRegistertableBySid(registertable);
		an.setSclassindentity(1);
		an.setClassinfo(cr.getClassinfo());
		an.setRid(cr.getRid());
		an.setRegistertableByJid(cr.getRegistertableByJid());
		an.setTclassidentity(cr.getTclassidentity());
		if((cr.getRegistertableBySid()!=null) || (cr.getWorkinfo()!=null))//(tt == 1))
		{
			csi.insert(an);
			flag = true;
		}
		else
		{
			flag = csi.update(an);
		}
		  if(flag == true)
		    return true;
		  return false;
	}

	public Cwrration selectupdateralationserver(Classinfo classinfo) {
		// TODO Auto-generated method stub
		Cwrration an = csi.selectById(classinfo);
		return an;
	}

	public boolean passralationserver(Cwrration ci) {
		// TODO Auto-generated method stub
		boolean flag = csi.update(ci);
		  if(flag == true)
		    return true;
		  return false;
	}

	public List<Cwrration> passAllralationes() {
		// TODO Auto-generated method stub
		List<Cwrration> list = csi.queryAllpass();
		return list;
	}

	/*public Classinfo selectaboutclassserver(Classinfo an2) {//û��
		// TODO Auto-generated method stub
		Classinfo an = csi.selectByXid(an2);
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
		List<Classinfo> list = csi.queryAllstyle(style);
		return list;
	}*/
}