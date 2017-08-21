package learn.online.impl.dao.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import learn.online.api.dao.daomapper.Controlforumpost;
import learn.online.api.dao.daomapper.HibernateSessionFactory;
import learn.online.common.vo.Classinfo;
import learn.online.common.vo.Foruminfo;
import learn.online.common.vo.Forumpost;
import learn.online.common.vo.Forumrelation;
import learn.online.common.vo.Forumreview;
import learn.online.common.vo.Registertable;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.opensymphony.xwork2.ActionContext;


public class ControlforumpostImp implements Controlforumpost
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
	
	
	public List<Forumpost> queryAll() {
		Foruminfo fi = (Foruminfo)getSessionnow().get("Foruminfo");
		
		String hql = "from Forumpost fp where fp.foruminfo = " + fi.getFid();
		List<Forumpost> list = hibTemplate.find(hql);
		return list;
	}
	
	public List<Forumpost> queryAll(String hql,int first,int size) {
		// TODO Auto-generated method stub
		Query q = HibernateSessionFactory.getSession().createQuery(hql);
		q.setFirstResult(first);
		q.setMaxResults(size);
		List<Forumpost> list = q.list();
		return list;
	}
	
	public int getAllRowCount(String hql) {
		Query q = HibernateSessionFactory.getSession().createQuery(hql);
		return q.list().size();
		
	}

	public <Forumpost> boolean update(Forumpost an) {
		hibTemplate.update(an);
		return true;
	}

	public <Forumpost> void insert(Forumpost an) {
		hibTemplate.save(an);
	}

	public <Forumpost> boolean delete(Forumpost an) {
		hibTemplate.delete(an);
		return true;
	}

	public Forumpost selectById(int Cid) {
		Forumpost an = null;
		Session session=HibernateSessionFactory.getSession();
		an = (Forumpost) session.get(Forumpost.class, Cid);
		session.close();
		return an;
	}

	public List<Forumpost> queryAllpassTeacher() {
		Foruminfo fi = (Foruminfo)getSessionnow().get("Foruminfo");
		Registertable rt = (Registertable)getSessionnow().get("register");
		
		String hql = "from Forumpost fp where fp.right = 1 and fp.foruminfo = "+ fi.getFid()+"and fp.postman = "+ "'"+rt.getYhm()+"'";
		List<Forumpost> list = hibTemplate.find(hql);
		return list;
	}
	
	public List<Forumpost> queryAllpassStudent() {
		Foruminfo fi = (Foruminfo)getSessionnow().get("Foruminfo");
		Registertable rt = (Registertable)getSessionnow().get("register");
		String hql = "from Forumpost fp where fp.right = 1 and fp.foruminfo = "+ fi.getFid()+"and fp.postman = "+"'"+rt.getYhm()+"'";
		List<Forumpost> list = hibTemplate.find(hql);
		return list;
	}
	
	public List<Forumpost> queryAllpass() {
		Foruminfo fi = (Foruminfo)getSessionnow().get("Foruminfo");
		
		String hql = "from Forumpost fp where fp.right = 1 and fp.foruminfo = "+ fi.getFid();
		List<Forumpost> list = hibTemplate.find(hql);
		return list;
	}
	
	//��̳��ϵ
	
	public boolean update(Forumrelation an) {
		hibTemplate.saveOrUpdate(an);
		return true;
	}

	public void insert(Forumrelation an) {
		hibTemplate.save(an);  //�ϲ�����session  hibTemplate.merge(an)
	}

	public boolean delete(Forumrelation an) {
		hibTemplate.delete(an);
		return true;
	}

	public Forumrelation selectById(Forumrelation frt) {
		String hql = "from Forumrelation Forumrelation where Forumrelation.foruminfo =" + frt.getId();
		List<Forumrelation> list = hibTemplate.find(hql);   
		Forumrelation an = null;
		if(list.size()>0)
		{
			an = list.get(0);
		}
		return an;
	}
	
	public Forumrelation selectByRid(int cid) {
		Session session=HibernateSessionFactory.getSession();
		String hql = "select * from Forumrelation where Forumrelation.fid = "+ cid +" and rownum = 1";
		//List<Forumrelation> list = hibTemplate.find(hql);   
		Query query = session.createSQLQuery(hql).addEntity(Forumrelation.class);
		Forumrelation an = (Forumrelation) query.uniqueResult();
		return an;
	}

	
	//����
	
	public boolean insertForumReview(Forumreview ci) {
		hibTemplate.save(ci);
		return true;
	}


	public List<Forumreview> queryAllreview() {
		Forumpost fp = (Forumpost)getSessionnow().get("Forumpost");
		String hql = "from Forumreview fr where fr.forumpost = " + fp.getFpid();
		List<Forumreview> list = hibTemplate.find(hql);
		return list;
	}
	
	public boolean delete(Forumreview ci) {
		hibTemplate.delete(ci);
		return true;
	}


	public <E> E selectById(Serializable id) {
		// TODO Auto-generated method stub
		return null;
	}

}