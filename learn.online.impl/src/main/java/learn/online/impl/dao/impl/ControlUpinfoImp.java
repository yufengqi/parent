package learn.online.impl.dao.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import learn.online.api.dao.daomapper.ControlUpinfo;
import learn.online.api.dao.daomapper.HibernateSessionFactory;
import learn.online.common.vo.Classinfo;
import learn.online.common.vo.Foruminfo;
import learn.online.common.vo.Registertable;
import learn.online.common.vo.Upinfo;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.opensymphony.xwork2.ActionContext;


public class ControlUpinfoImp implements ControlUpinfo
{
	private HibernateTemplate hibTemplate;
	
	public void setHibTemplate(HibernateTemplate hibTemplate) {
		this.hibTemplate = hibTemplate;
	}
	
	public List<Upinfo> queryAll() {
		// TODO Auto-generated method stub
		HttpServletRequest request = ServletActionContext.getRequest();
		int cid = Integer.parseInt(request.getParameter("cid"));
		String hql = "from Upinfo up where up.classinfo = "+cid;
		List<Upinfo> list = hibTemplate.find(hql);
		return list;
	}

	public <Upinfo> boolean update(Upinfo an) {
		// TODO Auto-generated method stub
		hibTemplate.update(an);
		return true;
	}
	
	public List<Upinfo> queryAll(String hql,int first,int size) {
		// TODO Auto-generated method stub
		Query q = HibernateSessionFactory.getSession().createQuery(hql);
		q.setFirstResult(first);
		q.setMaxResults(size);
		List<Upinfo> list = q.list();
		return list;
	}
	
	public int getAllRowCount(String hql) {
		Query q = HibernateSessionFactory.getSession().createQuery(hql);
		return q.list().size();
		
	}

	public <Upinfo> void insert(Upinfo an) {
		// TODO Auto-generated method stub
		hibTemplate.save(an);
	}

	public <Upinfo> boolean delete(Upinfo an) {
		// TODO Auto-generated method stub
		hibTemplate.delete(an);
		return true;
	}

	public Upinfo selectById(int Cid) {
		// TODO Auto-generated method stub
		Upinfo an = null;
		Session session=HibernateSessionFactory.getSession();
		an = (Upinfo) session.get(Upinfo.class, Cid);
		session.close();
		return an;
	}

	public List<Upinfo> queryAllpass() {
		// TODO Auto-generated method stub
		String hql = "from Upinfo";
		List<Upinfo> list = hibTemplate.find(hql);
		return list;
	}

	public List<Upinfo> queryAllchoose() {
		// TODO Auto-generated method stub
		Map<String, Object> session1 = ActionContext.getContext().getSession();
		Registertable registertable = (Registertable)session1.get("register");
		//String hql = "select Upinfo.cid,  Upinfo.classname, Upinfo.classtime, Upinfo.classplan, Upinfo.classbook, Upinfo.classexam, Upinfo.classneedbase, Upinfo.classwork, Upinfo.right from Upinfo Upinfo,Cwrration cw where Upinfo.right = 1 and cw.sclassindentity = 1 and cw.registertableBySid = " + registertable.getZcid();
		//List<Upinfo> list = hibTemplate.find(hql);
		
		Session session=HibernateSessionFactory.getSession();
		Query query = session.createSQLQuery("select Upinfo.cid, Upinfo.classname, Upinfo.classtime, Upinfo.classplan, Upinfo.classbook, Upinfo.classexam, Upinfo.classneedbase, Upinfo.classwork, Upinfo.right from Upinfo,Cwrration where Upinfo.cid = Cwrration.cid and Upinfo.right = 1 and Cwrration.sclassindentity = 1 and Cwrration.sid = ?").addEntity(Upinfo.class);
		query.setInteger(0,registertable.getZcid());
		List<Upinfo> list = query.list();
		return list;
	}

	public List<Upinfo> queryAllapply() {
		// TODO Auto-generated method stub
		Map<String, Object> session1 = ActionContext.getContext().getSession();
		Registertable registertable = (Registertable)session1.get("register");
		//String hql = "select Upinfo.cid,  Upinfo.classname, Upinfo.classtime, Upinfo.classplan, Upinfo.classbook, Upinfo.classexam, Upinfo.classneedbase, Upinfo.classwork, Upinfo.right from Upinfo Upinfo,Cwrration cw where Upinfo.right = 1 and cw.sclassindentity = 1 and cw.registertableBySid = " + registertable.getZcid();
		//List<Upinfo> list = hibTemplate.find(hql);
		
		Session session=HibernateSessionFactory.getSession();
		Query query = session.createSQLQuery("select Upinfo.cid, Upinfo.classname, Upinfo.classtime, Upinfo.classplan, Upinfo.classbook, Upinfo.classexam, Upinfo.classneedbase, Upinfo.classwork, Upinfo.right from Upinfo,Cwrration where Upinfo.cid = Cwrration.cid and Upinfo.right = 1 and Cwrration.tclassidentity = 1 and Cwrration.jid = ?").addEntity(Upinfo.class);
		query.setInteger(0,registertable.getZcid());
		List<Upinfo> list = query.list();
		return list;
	}

	public <E> E selectById(Serializable id) {
		// TODO Auto-generated method stub
		return null;
	}
}