package learn.online.api.service;

import java.io.Serializable;
import java.util.List;

import learn.online.common.exception.BasicException;
import learn.online.common.util.PageBean;



/**
 * @author 王惠 
 * @version 创建时间：2014年8月26日 下午3:09:58
 * @className BaseService.java
 */

public interface BaseService<E> {
	

	/**
	 * 分页查询
	 * @param pageSize
	 * @param page
	 * @return
	 */
	public PageBean<E> AllClasses(String sql,String coutsql,int pageSize,int page);
}
