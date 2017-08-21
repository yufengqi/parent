package learn.online.common.vo;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Foruminfo entity. @author MyEclipse Persistence Tools
 */

public class Foruminfo implements java.io.Serializable {

	// Fields

	private int fid;
	private String forumman;
	private String forumtitle;
	private String forumtext;
	private Date forumtime;
	private int right;
	private Set forumposts = new HashSet(0);

	// Constructors

	/** default constructor */
	public Foruminfo() {
	}

	/** full constructor */
	public Foruminfo(String forumman, String forumtitle, String forumtext,
			Date forumtime, int right, Set forumposts) {
		this.forumman = forumman;
		this.forumtitle = forumtitle;
		this.forumtext = forumtext;
		this.forumtime = forumtime;
		this.right = right;
		this.forumposts = forumposts;
	}

	// Property accessors

	public int getFid() {
		return this.fid;
	}

	public void setFid(int fid) {
		this.fid = fid;
	}

	public String getForumman() {
		return this.forumman;
	}

	public void setForumman(String forumman) {
		this.forumman = forumman;
	}

	public String getForumtitle() {
		return this.forumtitle;
	}

	public void setForumtitle(String forumtitle) {
		this.forumtitle = forumtitle;
	}

	public String getForumtext() {
		return this.forumtext;
	}

	public void setForumtext(String forumtext) {
		this.forumtext = forumtext;
	}

	public Date getForumtime() {
		return this.forumtime;
	}

	public void setForumtime(Date forumtime) {
		this.forumtime = forumtime;
	}

	public int getRight() {
		return this.right;
	}

	public void setRight(int right) {
		this.right = right;
	}

	public Set getForumposts() {
		return this.forumposts;
	}

	public void setForumposts(Set forumposts) {
		this.forumposts = forumposts;
	}

}