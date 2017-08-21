package learn.online.impl.dao.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import learn.online.api.dao.daomapper.Controlreplyinfo;
import learn.online.api.dao.daomapper.HibernateSessionFactory;
import learn.online.common.vo.Classinfo;
import learn.online.common.vo.Foruminfo;
import learn.online.common.vo.Leavewordinfo;
import learn.online.common.vo.Replyinfo;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.opensymphony.xwork2.ActionContext;


public class ControlreplyinfoImp implements Controlreplyinfo
{
	private HibernateTemplate hibTemplate;
	public void setHibTemplate(HibernateTemplate hibTemplate) {
		this.hibTemplate = hibTemplate;
	}
	
	public Map<String, Object> getSessionnow()
	{
		Map<String, Object> session = ActionContext.getContext().getSession();
		return session;
	}
   
	public List<Replyinfo> queryAll() {
		// TODO Auto-generated method stub
		String hql = "from replyinfoinfo";
		List<Replyinfo> list = hibTemplate.find(hql);
		return list;
	}
	
	public List<Replyinfo> queryAll(String hql,int first,int size) {
		// TODO Auto-generated method stub
		SQLQuery q = HibernateSessionFactory.getSession().createSQLQuery(hql).addEntity(Replyinfo.class);;
		q.setFirstResult(first);
		q.setMaxResults(size);
		List<Replyinfo> list = q.list();
		return list;
	}
	
	public int getAllRowCount(String hql) {
		SQLQuery q = HibernateSessionFactory.getSession().createSQLQuery(hql);
		return q.list().size();
		
	}
	
	public <Replyinfo> boolean update(Replyinfo an) {
		// TODO Auto-generated method stub
		hibTemplate.update(an);
		return true;
	}

	public <Replyinfo> void insert(Replyinfo an) {
		// TODO Auto-generated method stub
		hibTemplate.save(an);
	}

	public <Replyinfo> boolean delete(Replyinfo an) {
		// TODO Auto-generated method stub
		Leavewordinfo lwid = (Leavewordinfo)getSessionnow().get("Leavewordinfo");
		String hql = "delete Replyinfo ri  where ri.leavewordinfo =  "+lwid.getLwid();
        Session session=HibernateSessionFactory.getSession();
        Query query = session.createQuery(hql);
        query.executeUpdate();
		return true;
	}

	public  Replyinfo selectById(int Cid) {
		// TODO Auto-generated method stub
		Replyinfo an = null;
		Session session=HibernateSessionFactory.getSession();
		an = (Replyinfo) session.get(Replyinfo.class, Cid);
		session.close();
		return an;
	}

	public List<Replyinfo> queryAllpass() {
		// TODO Auto-generated method stub
		
		Leavewordinfo lwid =  (Leavewordinfo)getSessionnow().get("Leavewordinfo");
		List<Replyinfo> list = null;
		if(lwid != null)
		{
			String hql = "from Replyinfo replyinfo where replyinfo.leavewordinfo = " + lwid.getLwid();
			list = hibTemplate.find(hql);
		}
		return list;
	}

	public <E> E selectById(Serializable id) {
		// TODO Auto-generated method stub
		return null;
	}

}