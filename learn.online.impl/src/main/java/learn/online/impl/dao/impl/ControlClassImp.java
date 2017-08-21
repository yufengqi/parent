package learn.online.impl.dao.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import learn.online.api.dao.daomapper.ControlClass;
import learn.online.api.dao.daomapper.HibernateSessionFactory;
import learn.online.common.vo.Classinfo;
import learn.online.common.vo.Cwrration;
import learn.online.common.vo.Registertable;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.opensymphony.xwork2.ActionContext;


public class ControlClassImp implements ControlClass
{
	private HibernateTemplate hibTemplate;
	
	public void setHibTemplate(HibernateTemplate hibTemplate) {
		this.hibTemplate = hibTemplate;
	}
	
	public List<Classinfo> queryAll() {
		// TODO Auto-generated method stub
		String hql = "from Classinfo";
		return this.hibTemplate.find(hql);
	}
	
	public List<Classinfo> queryAll(String hql,int first,int size) {
		// TODO Auto-generated method stub
		SQLQuery q = HibernateSessionFactory.getSession().createSQLQuery(hql).addEntity(Classinfo.class);;
		q.setFirstResult(first);
		q.setMaxResults(size);
		List<Classinfo> list = q.list();
		return list;
	}
	
	public int getAllRowCount(String hql) {
		SQLQuery q = HibernateSessionFactory.getSession().createSQLQuery(hql);
		return q.list().size();
		
	}
	
	public Map<String, Object> getSession1()
	{
		Map<String, Object> session1 = ActionContext.getContext().getSession();
		return session1;
	}

	public <Classinfo> boolean update(Classinfo an) {
		// TODO Auto-generated method stub
		hibTemplate.update(an);
		return true;
	}

	@SuppressWarnings("hiding")
	public <Classinfo> void insert(Classinfo an) {
		// TODO Auto-generated method stub
		hibTemplate.save(an);
		getSession1().put("Classinfo",an);
	}
	

	public <Classinfo> boolean delete(Classinfo an) {
		// TODO Auto-generated method stub
		
		 hibTemplate.delete(an);
		 return true;
	}
	
	public Classinfo selectById(int Cid) {
		// TODO Auto-generated method stub
		Classinfo an = null;
		Session session=HibernateSessionFactory.getSession();
		an = (Classinfo) session.get(Classinfo.class, Cid);
		
		HttpServletRequest request = ServletActionContext.getRequest();
		 
		 
		
		Cwrration cr = null;
		String hql = "select * from Cwrration  where cid = " + Cid +" and rownum = 1";
		SQLQuery query =  session.createSQLQuery(hql).addEntity(Cwrration.class);
		List<Cwrration> list = query.list();
		if(list.size()>0)
		{
			cr = list.get(0);
		}
		
		getSession1().put("intro",cr);
		
		
		session.close();
		return an;
	}

	public List<Classinfo> queryAllpass() {
		// TODO Auto-generated method stub
		String hql = "from Classinfo classinfo where classinfo.right = 1";
		List<Classinfo> list = hibTemplate.find(hql);
		return list;
	}

	public List<Classinfo> queryAllchoose() {  //ѧ����ѡѡ��
		// TODO Auto-generated method stub
		Registertable registertable = (Registertable)getSession1().get("register");
		//String hql = "select classinfo.cid,  classinfo.classname, classinfo.classtime, classinfo.classplan, classinfo.classbook, classinfo.classexam, classinfo.classneedbase, classinfo.classwork, classinfo.right from Classinfo classinfo,Cwrration cw where classinfo.right = 1 and cw.sclassindentity = 1 and cw.registertableBySid = " + registertable.getZcid();
		//List<Classinfo> list = hibTemplate.find(hql);
		
		Session session=HibernateSessionFactory.getSession();
		SQLQuery query = session.createSQLQuery("select distinct Classinfo.cid, Classinfo.classname, Classinfo.classtime, Classinfo.classplan, Classinfo.classbook, Classinfo.classexam, Classinfo.classneedbase, Classinfo.classwork, Classinfo.classimage, Classinfo.right from Classinfo,Cwrration where Classinfo.cid = Cwrration.cid and Classinfo.right = 1 and Cwrration.sclassindentity = 1 and Cwrration.sid = ?").addEntity(Classinfo.class);
		query.setInteger(0,registertable.getZcid());
		List<Classinfo> list = query.list();
		session.close();
		return list;
	}

	public List<Classinfo> queryAllapply() {  //��ʦ������γ�
		// TODO Auto-generated method stub
		
		Registertable registertable = (Registertable)getSession1().get("register");
		//String hql = "select classinfo.cid,  classinfo.classname, classinfo.classtime, classinfo.classplan, classinfo.classbook, classinfo.classexam, classinfo.classneedbase, classinfo.classwork, classinfo.right from Classinfo classinfo,Cwrration cw where classinfo.right = 1 and cw.sclassindentity = 1 and cw.registertableBySid = " + registertable.getZcid();
		//List<Classinfo> list = hibTemplate.find(hql);
		
		Session session=HibernateSessionFactory.getSession();
		SQLQuery query = session.createSQLQuery("select distinct Classinfo.cid, Classinfo.classname, Classinfo.classtime, Classinfo.classplan, Classinfo.classbook, Classinfo.classexam, Classinfo.classneedbase, Classinfo.classwork, Classinfo.classimage, Classinfo.right from Classinfo,Cwrration where Classinfo.cid = Cwrration.cid and Classinfo.right = 1 and Cwrration.tclassidentity = 1 and Cwrration.jid = ?").addEntity(Classinfo.class);
		query.setInteger(0,registertable.getZcid());
		List<Classinfo> list = query.list();
		session.close();
		return list;
	}


}