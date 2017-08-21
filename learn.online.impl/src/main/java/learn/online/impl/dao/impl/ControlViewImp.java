package learn.online.impl.dao.impl;

import java.io.Serializable;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

import learn.online.api.dao.daomapper.ControlView;
import learn.online.api.dao.daomapper.HibernateSessionFactory;
import learn.online.common.vo.Classinfo;
import learn.online.common.vo.Foruminfo;
import learn.online.common.vo.StudentId;
import learn.online.common.vo.TeacherId;
import oracle.jdbc.OracleTypes;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateTemplate;



public class ControlViewImp implements ControlView
{
	private HibernateTemplate hibTemplate;
	
	public void setHibTemplate(HibernateTemplate hibTemplate) {
		this.hibTemplate = hibTemplate;
	}

	public List<TeacherId> queryAllteacher() {
		// TODO Auto-generated method stub
		 Connection conn = null;
		 try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			 conn = java.sql.DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:orcl","learn","wh");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		String sql = "{call mypk1.Popularteacherpro(?)}";  //这个是调用存储过程的，过去用的是函数，就是不可以，完全出错，有时间可以研究研究。
		List<TeacherId> list = null;
		ResultSet rs = null;
		
		CallableStatement call = null;
		try {
			call = conn.prepareCall(sql);
			call.registerOutParameter(1, OracleTypes.CURSOR);
			call.execute();
			rs = (ResultSet) call.getObject(1);
			if (rs.next()) {
				list.add(new TeacherId(rs.getInt("zcid"),rs.getString("yhm"),rs.getString("registername"),rs.getString("sex"),rs.getInt("age"),rs.getString("image"),rs.getInt("cid"),rs.getString("classname"),rs.getString("classtime"),rs.getString("classimage") ) );
				System.out.println(list.get(0).getClassname()+"视图");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		
	/*	cst.registerOutParameter(1, Types.NUMERIC);  
		cst.setDouble(2, 2);  
		cst.execute(); */ 

		return list;
	}

	public List<StudentId> queryAllclasses() {
		// TODO Auto-generated method stub
		//Session session =HibernateSessionFactory.getSession(); 
		
		 Connection conn = null;
		 try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			 conn = java.sql.DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:orcl","learn","wh");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String sql = "{call mypk.PopularClasspro(?) } ";
		
	
		

		List<StudentId> list = null;
		
	
		//Connection conn = session.connection(); 
		CallableStatement call = null;
		ResultSet rs = null;
		try {
			call = conn.prepareCall(sql);
			call.registerOutParameter(1, OracleTypes.CURSOR);
			call.executeQuery();
			rs = (ResultSet) call.getObject(1);
			if (rs .next()) {
				list.add(new StudentId( rs.getString(0),rs.getString(1),rs.getString(2),rs.getInt(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getInt(8) ) );
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}// ���������������	
	
		return list;
	}
	
	public List<TeacherId> queryAll(String hql,int first,int size) {
		// TODO Auto-generated method stub
		SQLQuery q = HibernateSessionFactory.getSession().createSQLQuery(hql).addEntity(TeacherId.class);
		q.setFirstResult(first);
		q.setMaxResults(size);
		List<TeacherId> list = q.list();
		return list;
	}
	
	public int getAllRowCount(String hql) {
		SQLQuery q = HibernateSessionFactory.getSession().createSQLQuery(hql);
		return q.list().size();
		
	}

	public <E> List<E> queryAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public <E> void insert(E e) {
		// TODO Auto-generated method stub
		
	}

	public <E> boolean update(E e) {
		// TODO Auto-generated method stub
		return false;
	}

	public <E> boolean delete(E e) {
		// TODO Auto-generated method stub
		return false;
	}

	public <E> E selectById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
}