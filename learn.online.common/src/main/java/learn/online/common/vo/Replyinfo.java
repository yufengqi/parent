package learn.online.common.vo;

import java.util.Date;

/**
 * Replyinfo entity. @author MyEclipse Persistence Tools
 */

public class Replyinfo implements java.io.Serializable {

	// Fields

	private int rpid;
	private Leavewordinfo leavewordinfo;
	private String replyman;
	private String replytext;
	private Date replytime;

	// Constructors

	/** default constructor */
	public Replyinfo() {
	}

	/** full constructor */
	public Replyinfo(Leavewordinfo leavewordinfo, String replyman,
			String replytext, Date replytime) {
		this.leavewordinfo = leavewordinfo;
		this.replyman = replyman;
		this.replytext = replytext;
		this.replytime = replytime;
	}

	// Property accessors

	public int getRpid() {
		return this.rpid;
	}

	public void setRpid(int rpid) {
		this.rpid = rpid;
	}

	public Leavewordinfo getLeavewordinfo() {
		return this.leavewordinfo;
	}

	public void setLeavewordinfo(Leavewordinfo leavewordinfo) {
		this.leavewordinfo = leavewordinfo;
	}

	public String getReplyman() {
		return this.replyman;
	}

	public void setReplyman(String replyman) {
		this.replyman = replyman;
	}

	public String getReplytext() {
		return this.replytext;
	}

	public void setReplytext(String replytext) {
		this.replytext = replytext;
	}

	public Date getReplytime() {
		return this.replytime;
	}

	public void setReplytime(Date replytime) {
		this.replytime = replytime;
	}

}