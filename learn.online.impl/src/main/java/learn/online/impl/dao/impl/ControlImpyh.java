package learn.online.impl.dao.impl;

import java.io.Serializable;
import java.util.List;

import learn.online.api.dao.daomapper.ControlYH;
import learn.online.api.dao.daomapper.HibernateSessionFactory;
import learn.online.common.vo.Classinfo;
import learn.online.common.vo.Foruminfo;
import learn.online.common.vo.Manage;
import learn.online.common.vo.Registertable;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateTemplate;




public class ControlImpyh implements ControlYH
{
	
	private HibernateTemplate hibTemplate;
	public void setHibTemplate(HibernateTemplate hibTemplate) {
		this.hibTemplate = hibTemplate;
	}
	
	public ControlImpyh() 
	{
	}

	public <Registertable> List<Registertable> queryAll()
	{
		String hql = "from Registertable";
		List<Registertable> list = hibTemplate.find(hql);
		return list;
	}
	
	
	public List<Registertable> queryAll(String hql,int first,int size) {
		// TODO Auto-generated method stub
		SQLQuery q = HibernateSessionFactory.getSession().createSQLQuery(hql).addEntity(Registertable.class);;
		q.setFirstResult(first);
		q.setMaxResults(size);
		List<Registertable> list = q.list();
		return list;
	}
	
	public int getAllRowCount(String hql) {
		SQLQuery q = HibernateSessionFactory.getSession().createSQLQuery(hql);
		return q.list().size();
		
	}
	
	public Registertable selectByName(String custname)
	{
		Registertable cust=null;
		
		Session session=HibernateSessionFactory.getSession();
		String hql="from Registertable where yhm = ?";
		Query query = session.createQuery(hql);
		query.setString(0, custname);
		cust = (Registertable) query.uniqueResult();
		return cust;
	}
	
	public Registertable selectByNamePwd(String custname,String pwd,int identity)
	{
	
		Registertable cust=null;
		
		Session session=HibernateSessionFactory.getSession();
		Query query = session.createQuery("from Registertable where  yhm =? and dlpassword =? and identity = ?");
		query.setString(0, custname);
		query.setString(1, pwd);
		query.setInteger(2, identity);
		cust = (Registertable) query.uniqueResult();
		return cust;
	}

	public <Registertable> boolean update(Registertable registertable)
	{
		hibTemplate.update(registertable);
		return true;
	}

	public <Registertable> boolean delete(Registertable rtc)
	{
		hibTemplate.delete(rtc);
		return true;
	}

	public <Registertable> void insert(Registertable registertable)
	{
		hibTemplate.save(registertable);
	}

	public Registertable selectById(int zcid) {
		// TODO Auto-generated method stub
		Registertable cust=null;
		Session session=HibernateSessionFactory.getSession();
		cust = (Registertable) session.get(Registertable.class, zcid);
		session.close();
		return cust;
	}

	public Manage selectByNamePwdmanagement(String custname,
			String pwd) {
		// TODO Auto-generated method stub
		Manage cust=null;
		
		Session session=HibernateSessionFactory.getSession();
		Query query = session.createQuery("from Manage where yhm =? and dlpassword =?");
		query.setString(0, custname);
		query.setString(1, pwd);
		cust = (Manage) query.uniqueResult();
		return cust;
	}

	public <E> E selectById(Serializable id) {
		// TODO Auto-generated method stub
		return null;
	}
}