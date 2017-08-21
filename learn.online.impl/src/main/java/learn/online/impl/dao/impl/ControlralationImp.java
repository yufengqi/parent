package learn.online.impl.dao.impl;

import java.io.Serializable;
import java.util.List;

import learn.online.api.dao.daomapper.Controlralation;
import learn.online.api.dao.daomapper.HibernateSessionFactory;
import learn.online.common.vo.Classinfo;
import learn.online.common.vo.Cwrration;
import learn.online.common.vo.Foruminfo;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateTemplate;

public class ControlralationImp implements Controlralation
{
	private HibernateTemplate hibTemplate;
	public void setHibTemplate(HibernateTemplate hibTemplate) {
		this.hibTemplate = hibTemplate;
	}
   
	public List<Cwrration> queryAll() {
		// TODO Auto-generated method stub
		String hql = "from Cwrration";
		List<Cwrration> list = hibTemplate.find(hql);
		return list;
	}

	public <Cwrration> boolean update(Cwrration an) {
		// TODO Auto-generated method stub
		hibTemplate.update(an);
		return true;
	}
	
	public List<Cwrration> queryAll(String hql,int first,int size) {
		// TODO Auto-generated method stub
		SQLQuery q = HibernateSessionFactory.getSession().createSQLQuery(hql).addEntity(Cwrration.class);;
		q.setFirstResult(first);
		q.setMaxResults(size);
		List<Cwrration> list = q.list();
		return list;
	}
	
	public int getAllRowCount(String hql) {
		SQLQuery q = HibernateSessionFactory.getSession().createSQLQuery(hql);
		return q.list().size();
		
	}

	public <Cwrration> void insert(Cwrration an) {
		// TODO Auto-generated method stub
		hibTemplate.save(an);  //�ϲ�����session  hibTemplate.merge(an)
	}

	public <Cwrration> boolean delete(Cwrration an) {
		// TODO Auto-generated method stub
		hibTemplate.update(an);
		hibTemplate.delete(an);
		return true;
	}

	public Cwrration selectById(Classinfo classinfo) {
		// TODO Auto-generated method stub
		
		String hql = "from Cwrration cwrration where cwrration.classinfo =" + classinfo.getCid();
		List<Cwrration> list = hibTemplate.find(hql);   
		Cwrration an = null;
		if(list.size()>0)
		{
			an = list.get(0);
		}
		return an;
	}
	
	public Cwrration selectByRidall(int cid) {
		// TODO Auto-generated method stub
		Session session=HibernateSessionFactory.getSession();
		String hql = null;
		  hql = "select * from Cwrration where Cwrration.cid = "+ cid +" and rownum = 1 ";
		Query query = session.createSQLQuery(hql).addEntity(Cwrration.class);
		Cwrration an = (Cwrration) query.uniqueResult();
		return an;
	}
	
	public Cwrration selectByRid(int set, int cid, int zyid) {
		// TODO Auto-generated method stub
		Session session=HibernateSessionFactory.getSession();
		String hql = "select * from Cwrration where Cwrration.cid = "+ cid +"and Cwrration.zyid = " + zyid;
		//List<Cwrration> list = hibTemplate.find(hql);   
		Query query = session.createSQLQuery(hql).addEntity(Cwrration.class);
		Cwrration an = (Cwrration) query.uniqueResult();
		session.close();
		return an;
	}

	public List<Cwrration> queryAllpass() {
		// TODO Auto-generated method stub
		
		Session session=HibernateSessionFactory.getSession();
		Query query = session.createSQLQuery("select * from Cwrration where right = ?");
		query.setInteger(0,1);
		List<Cwrration> list = query.list();
		session.close();
		return list;
	}

	public Cwrration selectByRiddelete(int zcid, int cid, int i) {
		// TODO Auto-generated method stub
		Session session=HibernateSessionFactory.getSession();
		String hql = null;
		if(i == 0)
		{
			 hql = "select * from Cwrration where Cwrration.cid = "+ cid +" and rownum = 1 and jid = "+zcid;
		}
		else
		{
			 hql = "select * from Cwrration where Cwrration.cid = "+ cid +" and rownum = 1 and sid = "+zcid;
		}
		 
		Query query = session.createSQLQuery(hql).addEntity(Cwrration.class);
		Cwrration an = (Cwrration) query.uniqueResult();
		return an;
	}

	public <E> E selectById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
}