package learn.online.common.vo;

import java.util.Date;

/**
 * Publicnotice entity. @author MyEclipse Persistence Tools
 */

public class Publicnotice implements java.io.Serializable {

	// Fields

	private int gid;
	private Registertable registertable;
	private Manage manage;
	private String reportman;
	private String reporttitle;
	private String reporttext;
	private Date reporttime;
	private int right;

	// Constructors

	/** default constructor */
	public Publicnotice() {
	}

	/** full constructor */
	public Publicnotice(Registertable registertable, Manage manage,
			String reportman, String reporttitle, String reporttext,
			Date reporttime, int right) {
		this.registertable = registertable;
		this.manage = manage;
		this.reportman = reportman;
		this.reporttitle = reporttitle;
		this.reporttext = reporttext;
		this.reporttime = reporttime;
		this.right = right;
	}

	// Property accessors

	public int getGid() {
		return this.gid;
	}

	public void setGid(int gid) {
		this.gid = gid;
	}

	public Registertable getRegistertable() {
		return this.registertable;
	}

	public void setRegistertable(Registertable registertable) {
		this.registertable = registertable;
	}

	public Manage getManage() {
		return this.manage;
	}

	public void setManage(Manage manage) {
		this.manage = manage;
	}

	public String getReportman() {
		return this.reportman;
	}

	public void setReportman(String reportman) {
		this.reportman = reportman;
	}

	public String getReporttitle() {
		return this.reporttitle;
	}

	public void setReporttitle(String reporttitle) {
		this.reporttitle = reporttitle;
	}

	public String getReporttext() {
		return this.reporttext;
	}

	public void setReporttext(String reporttext) {
		this.reporttext = reporttext;
	}

	public Date getReporttime() {
		return this.reporttime;
	}

	public void setReporttime(Date reporttime) {
		this.reporttime = reporttime;
	}

	public int getRight() {
		return this.right;
	}

	public void setRight(int right) {
		this.right = right;
	}

}