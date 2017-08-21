package learn.online.impl.dao.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import learn.online.api.dao.daomapper.Controlleaveword;
import learn.online.api.dao.daomapper.HibernateSessionFactory;
import learn.online.common.vo.Classinfo;
import learn.online.common.vo.Foruminfo;
import learn.online.common.vo.Learninfo;
import learn.online.common.vo.Leavewordinfo;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.opensymphony.xwork2.ActionContext;



public class ControlleavewordImp implements Controlleaveword
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
   
	public List<Leavewordinfo> queryAll() {
		// TODO Auto-generated method stub
		String hql = "from Leavewordinfo";
		List<Leavewordinfo> list = hibTemplate.find(hql);
		return list;
	}
	
	public List<Leavewordinfo> queryAll(String hql,int first,int size) {
		// TODO Auto-generated method stub
		SQLQuery q = HibernateSessionFactory.getSession().createSQLQuery(hql).addEntity(Leavewordinfo.class);;
		q.setFirstResult(first);
		q.setMaxResults(size);
		List<Leavewordinfo> list = q.list();
		return list;
	}
	
	public int getAllRowCount(String hql) {
		SQLQuery q = HibernateSessionFactory.getSession().createSQLQuery(hql);
		return q.list().size();
		
	}

	public <Leavewordinfo> boolean update(Leavewordinfo an) {
		// TODO Auto-generated method stub
		hibTemplate.update(an);
		return true;
	}

	public <Leavewordinfo> void insert(Leavewordinfo an) {
		// TODO Auto-generated method stub
		hibTemplate.save(an);
	}

	public <Leavewordinfo> boolean delete(Leavewordinfo an) {
		// TODO Auto-generated method stub
		hibTemplate.delete(an);
		return true;
	}

	public  Leavewordinfo selectById(int Cid) {
		// TODO Auto-generated method stub
		Leavewordinfo an = null;
		Session session=HibernateSessionFactory.getSession();
		an = (Leavewordinfo) session.get(Leavewordinfo.class, Cid);
		session.close();
		return an;
	}

	public List<Leavewordinfo> queryAllpass() {
		// TODO Auto-generated method stub
		String hql = "from Leavewordinfo Leavewordinfo where Leavewordinfo.right = 1";
		List<Leavewordinfo> list = hibTemplate.find(hql);
		return list;
	}

	
	//有待修改
	public List<Learninfo> queryAlllearninfo() {
		// TODO Auto-generated method stub
		Classinfo ci = (Classinfo)getSessionnow().get("classinfoxssq");
		String hql = "from Learninfo li where li.classinfo = "+ci.getCid();
		List<Learninfo> list = hibTemplate.find(hql);
		return list;
	}

	public void insertlearninfo(Learninfo ci) {
		// TODO Auto-generated method stub
		hibTemplate.save(ci);
	}

	public <E> E selectById(Serializable id) {
		// TODO Auto-generated method stub
		return null;
	}

}