package learn.online.common.vo;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Leavewordinfo entity. @author MyEclipse Persistence Tools
 */

public class Leavewordinfo implements java.io.Serializable {

	// Fields

	private int lwid;
	private String reportman;
	private String leavewordman;
	private String leavewordtext;
	private Date leavewordtime;
	private Set replyinfos = new HashSet(0);

	// Constructors

	/** default constructor */
	public Leavewordinfo() {
	}

	/** full constructor */
	public Leavewordinfo(String reportman, String leavewordman,
			String leavewordtext, Date leavewordtime, Set replyinfos) {
		this.reportman = reportman;
		this.leavewordman = leavewordman;
		this.leavewordtext = leavewordtext;
		this.leavewordtime = leavewordtime;
		this.replyinfos = replyinfos;
	}

	// Property accessors

	public int getLwid() {
		return this.lwid;
	}

	public void setLwid(int lwid) {
		this.lwid = lwid;
	}

	public String getReportman() {
		return this.reportman;
	}

	public void setReportman(String reportman) {
		this.reportman = reportman;
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

	public Set getReplyinfos() {
		return this.replyinfos;
	}

	public void setReplyinfos(Set replyinfos) {
		this.replyinfos = replyinfos;
	}
}