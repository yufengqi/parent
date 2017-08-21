package learn.online.common.vo;

import java.util.Date;

/**
 * Upinfo entity. @author MyEclipse Persistence Tools
 */

public class Upinfo implements java.io.Serializable {

	// Fields

	private int id;
	private Classinfo classinfo;
	private String upstyle;
	private String upttitle;
	private String upfrom;
	private Date uptime;

	// Constructors

	/** default constructor */
	public Upinfo() {
	}

	/** full constructor */
	public Upinfo(Classinfo classinfo, String upstyle, String upttitle,
			String upfrom, Date uptime) {
		this.classinfo = classinfo;
		this.upstyle = upstyle;
		this.upttitle = upttitle;
		this.upfrom = upfrom;
		this.uptime = uptime;
	}

	// Property accessors

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Classinfo getClassinfo() {
		return this.classinfo;
	}

	public void setClassinfo(Classinfo classinfo) {
		this.classinfo = classinfo;
	}

	public String getUpstyle() {
		return this.upstyle;
	}

	public void setUpstyle(String upstyle) {
		this.upstyle = upstyle;
	}

	public String getUpttitle() {
		return this.upttitle;
	}

	public void setUpttitle(String upttitle) {
		this.upttitle = upttitle;
	}

	public String getUpfrom() {
		return this.upfrom;
	}

	public void setUpfrom(String upfrom) {
		this.upfrom = upfrom;
	}

	public Date getUptime() {
		return this.uptime;
	}

	public void setUptime(Date uptime) {
		this.uptime = uptime;
	}

}