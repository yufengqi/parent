package learn.online.impl.servicemapper.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import learn.online.api.dao.daomapper.ControlView;
import learn.online.api.service.servicemapper.Viewservice;
import learn.online.common.util.PageBean;
import learn.online.common.vo.StudentId;
import learn.online.common.vo.TeacherId;

import org.apache.struts2.ServletActionContext;

public class Viewserviceimp implements Viewservice
{
    private ControlView vvi;
	
	public void setVvi(ControlView vvi) {
		this.vvi = vvi;
	}
	
	public List<StudentId> AllClasses() {
		// TODO Auto-generated method stub
		List<StudentId> list = vvi.queryAllclasses();
		return list;
	}
	
	public PageBean<StudentId> AllClasses(String sql,String coutsql,int pageSize,int page) {
		// TODO Auto-generated method stub
		int allRow = this.vvi.getAllRowCount(coutsql);  //总记录数
		int totalPage = PageBean.countTatalPage(pageSize, allRow); //总页数
		final int offset = PageBean.countOffset(pageSize, page); //当前页开始记录
		final int length = pageSize; // 每页记录数
		final int currentPage = PageBean.countCurrentPage(page); // 当前页
		List list = this.vvi.queryAll(sql,offset, length);//把分页信息保存到Bean当中
		PageBean<StudentId> pageBean  = new PageBean<StudentId>();
		pageBean.setPageSize(pageSize);
		pageBean.setCurrentPage(currentPage);
		pageBean.setAllRow(allRow);
		pageBean.setTotalPage(totalPage);
		pageBean.setList(list);
		//pageBean.init();
		return pageBean;
	}

	public List<TeacherId> AllTeacher() {
		// TODO Auto-generated method stub
		List<TeacherId> list = vvi.queryAllteacher();
		return list;
	}
}