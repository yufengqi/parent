package learn.online.common.vo;

import java.util.Date;

/**
 * Learninfo entity. @author MyEclipse Persistence Tools
 */

public class Learninfo implements java.io.Serializable {

	// Fields

	private int lwid;
	private Classinfo classinfo;
	private String leavewordman;
	private String leavewordtext;
	private Date leavewordtime;

	// Constructors

	/** default constructor */
	public Learninfo() {
	}

	/** full constructor */
	public Learninfo(Classinfo classinfo, String leavewordman,
			String leavewordtext, Date leavewordtime) {
		this.classinfo = classinfo;
		this.leavewordman = leavewordman;
		this.leavewordtext = leavewordtext;
		this.leavewordtime = leavewordtime;
	}

	// Property accessors

	public int getLwid() {
		return this.lwid;
	}

	public void setLwid(int lwid) {
		this.lwid = lwid;
	}

	public Classinfo getClassinfo() {
		return this.classinfo;
	}

	public void setClassinfo(Classinfo classinfo) {
		this.classinfo = classinfo;
	}

	public String getLeavewordman() {
		return this.leavewordman;
	}

	public void setLeavewordman(String leavewordman) {
		this.leavewordman = leavewordman;
	}

	public String getLeavewordtext() {
		return this.leavewordtext;
	}

	public void setLeavewordtext(String leavewordtext) {
		this.leavewordtext = leavewordtext;
	}

	public Date getLeavewordtime() {
		return this.leavewordtime;
	}

	public void setLeavewordtime(Date leavewordtime) {
		this.leavewordtime = leavewordtime;
	}

}