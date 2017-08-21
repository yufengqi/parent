package learn.online.impl.dao.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import learn.online.api.dao.daomapper.ControlForum;
import learn.online.api.dao.daomapper.HibernateSessionFactory;
import learn.online.common.vo.Classinfo;
import learn.online.common.vo.Foruminfo;
import learn.online.common.vo.Registertable;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.opensymphony.xwork2.ActionContext;



public class ControlForumImp implements ControlForum
{
	private HibernateTemplate hibTemplate;
	public void setHibTemplate(HibernateTemplate hibTemplate) {
		this.hibTemplate = hibTemplate;
	}
	
	public Map<String, Object> getSession1()
	{
		Map<String, Object> session1 = ActionContext.getContext().getSession();
		return session1;
	}
   
	public List<Foruminfo> queryAll() {
		// TODO Auto-generated method stub
		String hql = "from Foruminfo";
		List<Foruminfo> list = hibTemplate.find(hql);
		return list;
	}
	
	public List<Foruminfo> queryAll(String hql,int first,int size) {
		// TODO Auto-generated method stub
		SQLQuery q = HibernateSessionFactory.getSession().createSQLQuery(hql).addEntity(Foruminfo.class);
		q.setFirstResult(first);
		q.setMaxResults(size);
		List<Foruminfo> list = q.list();
		return list;
	}
	
	public int getAllRowCount(String hql) {
		SQLQuery q = HibernateSessionFactory.getSession().createSQLQuery(hql);
		return q.list().size();
		
	}
	
	public List<Foruminfo> queryAllpass() {
		// TODO Auto-generated method stub
		String hql = "from Foruminfo f where f.right = 1";
		List<Foruminfo> list = hibTemplate.find(hql);
		return list;
	}

	public <Foruminfo> boolean update(Foruminfo an) {
		// TODO Auto-generated method stub
		hibTemplate.update(an);
		return true;
	}

	public <Foruminfo> void insert(Foruminfo an) {
		// TODO Auto-generated method stub
		hibTemplate.save(an);
		java.util.Map<String, Object> session = ActionContext.getContext().getSession();
		session.put("Foruminfo",an);
	}

	public <Foruminfo> boolean delete(Foruminfo an) {
		// TODO Auto-generated method stub
		hibTemplate.delete(an);
		return true;
	}

	public Foruminfo selectById(int Fid) {
		// TODO Auto-generated method stub
		Foruminfo an = null;
		Session session=HibernateSessionFactory.getSession();
		an = (Foruminfo) session.get(Foruminfo.class, Fid);
		session.close();
		return an;
	}

	public List<Foruminfo> queryAllpassteacher() {
		
		Registertable registertable = (Registertable)getSession1().get("register");
		
		Session session=HibernateSessionFactory.getSession();
		Query query = session.createSQLQuery("select distinct Foruminfo.fid, Foruminfo.forumman, Foruminfo.forumtitle, Foruminfo.forumtext, Foruminfo.forumtime, Foruminfo.right from Foruminfo,Forumrelation where Foruminfo.fid = Forumrelation.fid and Foruminfo.right = 1 and Forumrelation.tforumidentity = 1 and Forumrelation.jid = ?").addEntity(Foruminfo.class);
		query.setInteger(0,registertable.getZcid());
		List<Foruminfo> list = query.list();
		session.close();
		return list;
		
		
		//String hql = "from Foruminfo Foruminfo where Foruminfo.right = 1";
		//List<Foruminfo> list = hibTemplate.find(hql);
		//return list;
	}

	public List<Foruminfo> queryAllpassstudent() {
		// TODO Auto-generated method stub
        Registertable re = (Registertable)getSession1().get("register");
		
		Session session=HibernateSessionFactory.getSession();
		Query query = session.createSQLQuery("select distinct Foruminfo.fid, Foruminfo.forumman, Foruminfo.forumtitle, Foruminfo.forumtext, Foruminfo.forumtime, Foruminfo.right from Foruminfo,Forumrelation where Foruminfo.fid = Forumrelation.fid and Foruminfo.right = 1 and Forumrelation.sforumidentity = 1 and Forumrelation.sid = ?").addEntity(Foruminfo.class);
		query.setInteger(0,re.getZcid());
		List<Foruminfo> list = query.list();
		session.close();
		return list;
	}

	public <E> E selectById(Serializable id) {
		// TODO Auto-generated method stub
		return null;
	}

}