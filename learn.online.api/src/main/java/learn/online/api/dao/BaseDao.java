package learn.online.api.dao;

import java.io.Serializable;
import java.util.List;

/**
 * @author 王惠 
 * @version 创建时间：2015年5月4日 下午3:30:17
 * @className BaseDao.java
 */

public interface BaseDao {
	
	
	public <E> List<E> queryAll(); //throws Exception;
	/**
	 * 查询全部
	 * @return
	 * @throws Exception
	 */
	public <E> List<E> queryAll(String sql,int first,int size); //throws Exception;
	
	/**
	 * 保存数据，返回受影响的行数
	 * 
	 * @param e
	 * @return
	 */
	public <E> void insert(E e); //throws Exception;

	/**
	 * 更新数据，返回boolean值
	 * 
	 * @param e
	 * @return
	 */
	public <E> boolean update(E e); //throws Exception;

	/**
	 * 删除对象，返回boolean值
	 * @param <E>
	 * 
	 * @return
	 */
	public <E> boolean delete(E e); //throws Exception;

	/**
	 * 根据主键id列表删除数据，返回受影响的行数
	 * 
	 * @param id
	 * @return
	 */
/*	public <T extends Serializable> int deleteByIds(List<T> ids)
			throws Exception;  用于联合主键的删除，此处没有用到联合主键！*/

	/**
	 * 根据主键id查询数据，返回一个对象
	 * 
	 * @param id
	 * @return
	 */
	public <E> E selectById(int id); //throws Exception;
	
	/**
	 * 根据多个主键id查询数据，返回多个对象
	 * 
	 * @param ids
	 * @return
	 *//*
	public <E, T extends Serializable> List<E> getByIds(List<T> ids)
			throws Exception;*/

	/**
	 * 
	 * 获取项目条数
	 * 
	 * 
	 * @return
	 */
	public int getAllRowCount(String hql);
}
