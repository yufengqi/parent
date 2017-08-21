package learn.online.impl.service.impl;

import java.io.Serializable;
import java.util.List;

import learn.online.api.dao.BaseDao;
import learn.online.api.service.BaseService;
import learn.online.common.exception.ApplicationException;
import learn.online.common.exception.BasicException;
import learn.online.common.exception.ParameterException;


/**
 * @author 王惠 
 * @version 创建时间：2014年8月26日 下午3:35:16
 * @param <E>
 * @className BaseServiceImpl.java
 */

public abstract class BaseServiceImpl<E> implements BaseService<E> {

	public boolean saveObj(E e) throws BasicException {
		if (e == null) {
			throw new ParameterException("parameter object is null...");
		}
		try {
			this.getDao().insert(e);
			return true;
		} catch (Exception ex) {
			throw new ApplicationException(ex);
		}
		
	}
	
	public boolean updateObj(E e) throws BasicException {
		if (e == null) {
			throw new ParameterException("parameter object is null...");
		}
		try {
			 this.getDao().update(e);
			 return true;
		} catch (Exception ex) {
			throw new ApplicationException(ex);
		}
	}
	
	public boolean delete(E e) throws BasicException {
		if (e == null) {
			throw new ParameterException("parameter object is null...");
		}
		try {
			return this.getDao().delete(e);
		} catch (Exception ex) {
			throw new ApplicationException(ex);
		}
	}
	
	public E getObjById(int id) throws BasicException {
		if (id == 0) {
			throw new ParameterException("parameter id is null...");
		}
		try {
			return this.getDao().selectById(id);
		} catch (Exception e) {
			throw new ApplicationException(e);
		}
	}
	
//	public <T extends Serializable> List<E> getObjByIds(List<T> ids)
//			throws BasicException {
//		if (ids == null || ids.size() == 0) {
//			throw new ParameterException(
//					"parameter idList is null or idList.size = 0...");
//		}
//		try {
//			return this.getDao().getByIds(ids);
//		} catch (Exception ex) {
//			throw new ApplicationException(ex);
//		}
//	}
	
	protected abstract BaseDao getDao();
}
