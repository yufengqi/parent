package learn.online.impl.dao.impl;

import java.io.Serializable;
import java.util.List;

import learn.online.api.dao.daomapper.ControlT;
import learn.online.api.dao.daomapper.HibernateSessionFactory;
import learn.online.common.vo.Classinfo;
import learn.online.common.vo.Foruminfo;
import learn.online.common.vo.Registertable;
import learn.online.common.vo.Teacherinfo;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateTemplate;



public class ControlTimp implements ControlT
{
	private HibernateTemplate hibTemplate;
	public void setHibTemplate(HibernateTemplate hibTemplate) {
		this.hibTemplate = hibTemplate;
	}
   
	public List<Teacherinfo> queryAll(Registertable rt) {
		// TODO Auto-generated method stub
		
		String hql = "from Teacherinfo t where t.registertable = "+rt.getZcid();
		List<Teacherinfo> list = hibTemplate.find(hql);
		return list;
	}

	public <Teacherinfo> boolean update(Teacherinfo an) {
		// TODO Auto-generated method stub
		hibTemplate.update(an);
		return true;
	}

	public List<Teacherinfo> queryAll(String hql,int first,int size) {
		// TODO Auto-generated method stub
	    Query q = HibernateSessionFactory.getSession().createQuery(hql);
		q.setFirstResult(first);
		q.setMaxResults(size);
		List<Teacherinfo> list = q.list();
		return list;
	}
	
	public int getAllRowCount(String hql) {
		Query q = HibernateSessionFactory.getSession().createQuery(hql);
		return q.list().size();
		
	}
	
	public <Teacherinfo> void insert(Teacherinfo an) {
		// TODO Auto-generated method stub
		hibTemplate.save(an);
	}

	public <Teacherinfo> boolean delete(Teacherinfo an) {
		// TODO Auto-generated method stub
		hibTemplate.delete(an);
		/*Session session = factory.openSession();
		Transaction tran = session.beginTransaction();
		session.delete(an);
		/*Query query = session.createSQLQuery("delete Teacherinfo where id = ?");
		query.setInteger(0,an.getId());
		query.executeUpdate();*/
		/*tran.commit();
		session.close();*/
		return true;
	}


	public Teacherinfo selectById(int Tid) {
		// TODO Auto-generated method stub
		Teacherinfo an = null;
		Session session=HibernateSessionFactory.getSession();
		an = (Teacherinfo) session.get(Teacherinfo.class, Tid);
		session.close();
		return an;
	}
	
	public Teacherinfo selectByJId(int Tid) {
		// TODO Auto-generated method stub
		Teacherinfo an = null;
		Session session=HibernateSessionFactory.getSession();
		Query query = session.createSQLQuery("select * from Teacherinfo where jid = " + Tid +"and rownum = 1").addEntity(Teacherinfo.class);
		an = (Teacherinfo) query.uniqueResult();
		return an;
	}

	public Teacherinfo selectByXid(Teacherinfo an2) {//������ţ�û��ʲô�����õģ�
		// TODO Auto-generated method stub
		Teacherinfo an = null;
		Session session=HibernateSessionFactory.getSession();
		Query query = session.createQuery("from Teacherinfo where tid = ?");
		an = (Teacherinfo) query.uniqueResult();
		return an;
	}

	public List<Teacherinfo> queryAllstyle(String style) {
		// TODO Auto-generated method stub
       /* List<Teacherinfo> list = new ArrayList<Teacherinfo>();
		
        Session session=HibernateSessionFactory.getSession();
		Query query = session.createQuery("from Teacherinfo where keyword like ?");
		query.setString(0,"%"+style+"%");
		list = query.list();
		session.close();
		return list;*/
		return null;
	}

	public <E> List<E> queryAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public <E> E selectById(Serializable id) {
		// TODO Auto-generated method stub
		return null;
	}
}