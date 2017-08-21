package learn.online.action;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import javax.servlet.http.HttpServletRequest;

import learn.online.api.service.servicemapper.Upinfoservice;
import learn.online.common.util.PageBean;
import learn.online.common.util.UploadConfigurationRead;
import learn.online.common.vo.Classinfo;
import learn.online.common.vo.Upinfo;

public class UpinfoAction extends ActionSupport implements ModelDriven<Upinfo>
{
	private File[] upload;// 实锟斤拷锟较达拷锟侥硷拷
	private String[] uploadContentType; // 锟侥硷拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷
	private String[] uploadFileName; // 锟较达拷锟侥硷拷锟斤拷
	private List<Upinfo> uploadFiles = new ArrayList<Upinfo>();

	private List<Upinfo> list;
	
	private Upinfo ci = new Upinfo();
	
	private PageBean<Upinfo> pageBean; //封装了分页信息和数据内容的pageBean
	private int page = 1; //表示从网页中返回的当前页的值  默认为1 表示默认显示第一页内容
	
	public int getPage() {
	   return page;
	}
	
	public void setPage(int page) {
	     this.page = page;
	}
	
	public PageBean<Upinfo> getPageBean() {
	    return pageBean;
	}
	
	public void setPageBean(PageBean<Upinfo> pageBean) {
	     this.pageBean = pageBean;
	}
	
	private  Upinfoservice uia;
	
	public void setUia(Upinfoservice uia)
	{
		this.uia = uia;
	}
	
	public Upinfo getModel() {
		// TODO Auto-generated method stub
		return ci;
	}
	
	public java.util.Map<String, Object> getSessionnow()
	{
		java.util.Map<String, Object> session = ActionContext.getContext().getSession();
		return session;
	}
	
	public String getAllupinfoes()  
	{
		HttpServletRequest request = ServletActionContext.getRequest();
	   int cid = Integer.parseInt(request.getParameter("cid"));
	   String hql = "from Upinfo up where up.classinfo = "+cid;
	   
	    this.pageBean = this.uia.AllClasses(hql,hql,15, page);//获取封装了分页信息和数据的pageBean
		this.uploadFiles = this.pageBean.getList(); //获取数据
		
		//uploadFiles = uia.Allupinfoes();
		//uploadFiles.add((Upinfo) list);
		ActionContext ctxt=ActionContext.getContext();
		ctxt.put("uploadFiles", uploadFiles);
		return "success";
	}
	
	
	public String allapplyupinfoes()//锟斤拷锟斤拷
	{
	    list =uia.allapplyupinfoes();
	   // HttpServletRequest request = ServletActionContext.getRequest();
	   // request.setAttribute("list",list);
		ActionContext ctxt=ActionContext.getContext();
		ctxt.put("listteacher", list);
		return "success";
	}
	
	public String allchooseupinfoes()//锟斤拷锟斤拷
	{
	    list =uia.allchooseupinfoes();
	   // HttpServletRequest request = ServletActionContext.getRequest();
	   // request.setAttribute("list",list);
		ActionContext ctxt=ActionContext.getContext();
		ctxt.put("list", list);
		return "success";
	}
	
	public String passAllupinfoes()   
	{
		     String hql = "from Upinfo";
		   
		    this.pageBean = this.uia.AllClasses(hql,hql,15, page);//获取封装了分页信息和数据的pageBean
			this.uploadFiles = this.pageBean.getList(); //获取数据
		
		//uploadFiles =uia.passAllupinfoes();
		ActionContext ctxt=ActionContext.getContext();
		ctxt.put("uploadFiles", uploadFiles);
		//request.setAttribute("list",list);                                                                                      
		return "success";
	}
	
	public String insertupinfo()
	{
		Classinfo cc = (Classinfo)getSessionnow().get("classinfoxssq");
	    ci.setClassinfo(cc);
		boolean flag = uia.insertupinfoserver(ci);
		if(flag == true)
		   return "success";
		else
			return "fail";
	}
	
	public String deleteupinfo()
	{
		boolean flag = uia.delectupinfoserver(ci);
		if(flag == true)
		   return "success";
		else
			return "fail";
	}
	
	public String updateupinfo()//锟斤拷锟斤拷
	{
		boolean flag = uia.updateupinfoserver(ci);
		if(flag == true)
		   return "success";
		else
			return "fail";
	}
	
	public String selectupdateupinfo()//锟斤拷锟斤拷
	{
		Upinfo ci1 = uia.selectupdateupinfoserver(ci.getId());
		
		java.util.Map<String, Object> session = ActionContext.getContext().getSession();
		session.put("Upinfoxssq",ci1);
		
		
		ActionContext ctxt1=ActionContext.getContext();
		ctxt1.put("selectupinfo", ci1);
		//getAllupinfoes();
		return "success";
	}
	
	public String passupinfo()//锟斤拷锟斤拷
	{
		Upinfo ci1 = uia.selectupdateupinfoserver(ci.getId());
		boolean flag = uia.passupinfoserver(ci1);
		if(flag == true)
		   return "success";
		else
			return "fail";
	}
	

	public String executem() throws Exception
	{
		try
		{
			String targetDirectory = ServletActionContext.getServletContext()
					.getRealPath("/"+ UploadConfigurationRead.getInstance().getConfigItem("uploadFilePath").trim());// 锟斤拷锟铰凤拷锟�
			for (int i = 0; i < upload.length; i++)
			{
				String fileName = uploadFileName[i];// 锟较达拷锟斤拷锟侥硷拷锟斤拷
				String type = uploadContentType[i];// 锟侥硷拷锟斤拷锟斤拷
				String realName = UUID.randomUUID().toString()+ getExt(fileName);// 锟斤拷锟斤拷锟斤拷募锟斤拷锟狡ｏ拷使锟斤拷UUID+锟斤拷缀锟斤拷锟叫憋拷锟斤拷

				File target = new File(targetDirectory, realName);
				FileUtils.copyFile(upload[i], target);// 锟较达拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷目录锟斤拷一锟姐都锟斤拷锟斤拷锟斤拷锟斤拷锟�
														// 锟节帮拷路锟斤拷写锟斤拷锟斤拷菘饧达拷锟�

				Upinfo uf = new Upinfo();// 锟斤拷锟斤拷锟侥硷拷
				//uf.setUpstyle(type);
				uf.setUpstyle(null);
				uf.setUpttitle(fileName);
				uf.setUpfrom(realName);
				
				ci = uf;
			    ci.setUptime(new Date());
				insertupinfo();
				

				//uploadFiles.add(uf);// 锟斤拷拥锟斤拷锟揭拷锟斤拷锟斤拷募锟斤拷锟絃ist锟斤拷锟斤拷锟斤拷

				// uploadRealName[i]=UUID.randomUUID().toString();
				// System.out.println("uploadRealName:"+uploadRealName[i]);
				// for(File file:upload)
				// {
				// System.out.println("filename:"+file.getName());
				// }
				// System.out.println("filename:"+fileName);
				// System.out.println("Ext:"+getExt(fileName));
				// System.out.println("Type:"+type);
				// System.out.println(target.getPath());
			}
			//ServletActionContext.getRequest().setAttribute("uploadFiles",
				//	uploadFiles);

		} catch (Exception e)
		{
			e.printStackTrace();
			addActionError(e.getMessage());

			return INPUT;
		}

		return SUCCESS;

	}

	public File[] getUpload()
	{
		return upload;
	}

	public void setUpload(File[] upload)
	{
		this.upload = upload;
	}

	public String[] getUploadContentType()
	{
		return uploadContentType;
	}

	public void setUploadContentType(String[] uploadContentType)
	{
		this.uploadContentType = uploadContentType;
	}

	public String[] getUploadFileName()
	{
		return uploadFileName;
	}

	public void setUploadFileName(String[] uploadFileName)
	{
		this.uploadFileName = uploadFileName;
	}

	public static String getExt(String fileName)
	{
		return fileName.substring(fileName.lastIndexOf("."));
	}
}
