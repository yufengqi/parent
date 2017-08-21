package learn.online.impl.dao.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import learn.online.api.dao.daomapper.ControlWork;
import learn.online.api.dao.daomapper.HibernateSessionFactory;
import learn.online.common.vo.Foruminfo;
import learn.online.common.vo.Registertable;
import learn.online.common.vo.Workinfo;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.opensymphony.xwork2.ActionContext;



public class ControlworkImp implements ControlWork
{
	private HibernateTemplate hibTemplate;
	
	public void setHibTemplate(HibernateTemplate hibTemplate) {
		this.hibTemplate = hibTemplate;
	}
	
	public java.util.Map<String, Object> getSessionnow()
	{
		java.util.Map<String, Object> session = ActionContext.getContext().getSession();;
		return session;
	}
	
	public List<Workinfo> queryAll() {
		// TODO Auto-generated method stub
		Registertable register = (Registertable) getSessionnow().get("register");
		HttpServletRequest request = ServletActionContext.getRequest();
		
		int cid = Integer.parseInt(request.getParameter("cid"));
		
		Session session=HibernateSessionFactory.getSession();
		
		String hql = null;
		if(register.getIdentity() == 0)
		{
		   hql = "select Workinfo.zyid,Workinfo.worktitle,Workinfo.other,Workinfo.reviewgrand,Workinfo.reviewtext,Workinfo.reviewtime,Workinfo.studentname,Workinfo.teachername,Workinfo.worktext from Workinfo,Cwrration where Workinfo.zyid = Cwrration.zyid and Cwrration.jid = ? and Cwrration.cid = ?";
		}
		else if(register.getIdentity() == 1)
		{
			hql = "select Workinfo.zyid,Workinfo.worktitle,Workinfo.other,Workinfo.reviewgrand,Workinfo.reviewtext,Workinfo.reviewtime,Workinfo.studentname,Workinfo.teachername,Workinfo.worktext from Workinfo,Cwrration where Workinfo.zyid = Cwrration.zyid and Cwrration.sid = ? and Cwrration.cid = ?";
		}
		
		Query query = session.createSQLQuery(hql).addEntity(Workinfo.class);
		query.setInteger(0,register.getZcid());
		query.setInteger(1,cid);
		List<Workinfo> list = query.list();
		return list;
	}
	
	public List<Workinfo> queryAll(String hql,int first,int size) {
		// TODO Auto-generated method stub
		SQLQuery q = HibernateSessionFactory.getSession().createSQLQuery(hql).addEntity(Workinfo.class);;
		q.setFirstResult(first);
		q.setMaxResults(size);
		List<Workinfo> list = q.list();
		return list;
	}
	
	public int getAllRowCount(String hql) {
		SQLQuery q = HibernateSessionFactory.getSession().createSQLQuery(hql);
		return q.list().size();
		
	}
	
	public <Workinfo> boolean update(Workinfo an) {
		// TODO Auto-generated method stub
		hibTemplate.update(an);
		return true;
	}

	public <Workinfo> void insert(Workinfo an) {
		// TODO Auto-generated method stub
		hibTemplate.save(an);
		
		getSessionnow().put("Workinfo",an);
		//Session session = factory.openSession();
		//Transaction tran = session.beginTransaction();
		//Query query = session.createSQLQuery("insert into Workinfo (newstitle,newsman,reporttime,keyword,newstext,xid) values(?,?,?,?,?,?)");
		/*query.setString(0,an.getNewstitle()); 
		query.setString(1,an.getNewsman());
		query.setDate(2,an.getReporttime());
		query.setString(3,an.getKeyword());
		query.setString(4,an.getNewstext());
		query.setInteger(5,an.getXid());
		query.executeUpdate();*/
	//	tran.commit();
	//	session.close();
	}

	public <Workinfo> boolean delete(Workinfo an) {
		// TODO Auto-generated method stub
		hibTemplate.delete(an);
		/*Session session = factory.openSession();
		Transaction tran = session.beginTransaction();
		session.delete(an);
		/*Query query = session.createSQLQuery("delete Workinfo where id = ?");
		query.setInteger(0,an.getId());
		query.executeUpdate();*/
		/*tran.commit();
		session.close();*/
		return true;
	}

	public Workinfo selectById(int Cid) {
		// TODO Auto-generated method stub
		Workinfo an = null;
		Session session=HibernateSessionFactory.getSession();
		an = (Workinfo) session.get(Workinfo.class, Cid);
		session.close();
		return an;
	}

	public List<Workinfo> queryAllpass() {
		// TODO Auto-generated method stub
		String hql = "from Workinfo Workinfo where Workinfo.right = 1";
		List<Workinfo> list = hibTemplate.find(hql);
		return list;
	}

	public List<Workinfo> queryAllchoose() {
		// TODO Auto-generated method stub
		Map<String, Object> session1 = ActionContext.getContext().getSession();
		Registertable registertable = (Registertable)session1.get("register");
		//String hql = "select Workinfo.cid,  Workinfo.Workname, Workinfo.Worktime, Workinfo.Workplan, Workinfo.Workbook, Workinfo.Workexam, Workinfo.Workneedbase, Workinfo.Workwork, Workinfo.right from Workinfo Workinfo,Cwrration cw where Workinfo.right = 1 and cw.sWorkindentity = 1 and cw.registertableBySid = " + registertable.getZcid();
		//List<Workinfo> list = hibTemplate.find(hql);
		
		Session session=HibernateSessionFactory.getSession();
		Query query = session.createSQLQuery("select Workinfo.cid, Workinfo.Workname, Workinfo.Worktime, Workinfo.Workplan, Workinfo.Workbook, Workinfo.Workexam, Workinfo.Workneedbase, Workinfo.Workwork, Workinfo.right from Workinfo,Cwrration where Workinfo.cid = Cwrration.cid and Workinfo.right = 1 and Cwrration.sWorkindentity = 1 and Cwrration.sid = ?").addEntity(Workinfo.class);
		query.setInteger(0,registertable.getZcid());
		List<Workinfo> list = query.list();
		return list;
	}

	public List<Workinfo> queryAllapply() {
		// TODO Auto-generated method stub
		Map<String, Object> session1 = ActionContext.getContext().getSession();
		Registertable registertable = (Registertable)session1.get("register");
		//String hql = "select Workinfo.cid,  Workinfo.Workname, Workinfo.Worktime, Workinfo.Workplan, Workinfo.Workbook, Workinfo.Workexam, Workinfo.Workneedbase, Workinfo.Workwork, Workinfo.right from Workinfo Workinfo,Cwrration cw where Workinfo.right = 1 and cw.sWorkindentity = 1 and cw.registertableBySid = " + registertable.getZcid();
		//List<Workinfo> list = hibTemplate.find(hql);
		
		Session session=HibernateSessionFactory.getSession();
		Query query = session.createSQLQuery("select Workinfo.cid, Workinfo.Workname, Workinfo.Worktime, Workinfo.Workplan, Workinfo.Workbook, Workinfo.Workexam, Workinfo.Workneedbase, Workinfo.Workwork, Workinfo.right from Workinfo,Cwrration where Workinfo.cid = Cwrration.cid and Workinfo.right = 1 and Cwrration.tWorkidentity = 1 and Cwrration.jid = ?").addEntity(Workinfo.class);
		query.setInteger(0,registertable.getZcid());
		List<Workinfo> list = query.list();
		return list;
	}

	public <E> E selectById(Serializable id) {
		// TODO Auto-generated method stub
		return null;
	}
}