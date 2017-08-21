package learn.online.impl.dao.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import learn.online.api.dao.daomapper.Controlpublicnotice;
import learn.online.api.dao.daomapper.HibernateSessionFactory;
import learn.online.common.vo.Classinfo;
import learn.online.common.vo.Foruminfo;
import learn.online.common.vo.Publicnotice;
import learn.online.common.vo.Registertable;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.opensymphony.xwork2.ActionContext;



public class ControlpublcnoticeImp implements Controlpublicnotice
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
	
	
	public List<Publicnotice> queryAll(String hql,int first,int size) {
		// TODO Auto-generated method stub
		Query q = HibernateSessionFactory.getSession().createQuery(hql);
		q.setFirstResult(first);
		q.setMaxResults(size);
		List<Publicnotice> list = q.list();
		return list;
	}
	
	public int getAllRowCount(String hql) {
	Query q = HibernateSessionFactory.getSession().createQuery(hql);
		return q.list().size();
		
	}
	
	public List<Publicnotice> queryAll() {
		// TODO Auto-generated method stub
		String hql = "from Publicnotice";
		List<Publicnotice> list = hibTemplate.find(hql);
		return list;
	}
	
	public List<Publicnotice> queryAllapply() {   //��ѯͨ���
		// TODO Auto-generated method stub
		String hql = "from Publicnotice p where p.right = 1";
		List<Publicnotice> list = hibTemplate.find(hql);
		return list;
		
	}

	public <Publicnotice> boolean update(Publicnotice an) {
		// TODO Auto-generated method stub
		hibTemplate.update(an);
		return true;
	}

	public <Publicnotice> void insert(Publicnotice an) {
		// TODO Auto-generated method stub
		hibTemplate.save(an);
	}

	public <Publicnotice> boolean delete(Publicnotice an) {
		// TODO Auto-generated method stub
		hibTemplate.delete(an);
		/*Session session = factory.openSession();
		Transaction tran = session.beginTransaction();
		session.delete(an);
		/*Query query = session.createSQLQuery("delete Publicnotice where id = ?");
		query.setInteger(0,an.getId());
		query.executeUpdate();*/
		/*tran.commit();
		session.close();*/
		return true;
	}

	public Publicnotice selectById(int Gid) {
		// TODO Auto-generated method stub
		Publicnotice an = null;
		Session session=HibernateSessionFactory.getSession();
		an = (Publicnotice) session.get(Publicnotice.class, Gid);
		session.close();
		return an;
	}

	public List<Publicnotice> queryAllpass() {  //��ѯ���й���
		// TODO Auto-generated method stub
		Registertable registertable = null;
		String hql = null;
		if(getSessionnow().get("register") instanceof Registertable)
		{
		     registertable = (Registertable)getSessionnow().get("register");
		     hql = "from Publicnotice publicnotice where publicnotice.right = 1 and publicnotice.registertable = " + registertable.getZcid();
		}
		else{
			  hql = "from Publicnotice publicnotice where publicnotice.right = 1 and publicnotice.registertable = null";
		}
		
	  
		List<Publicnotice> list = hibTemplate.find(hql);
		return list;
	}

	public <E> E selectById(Serializable id) {
		// TODO Auto-generated method stub
		return null;
	}
}