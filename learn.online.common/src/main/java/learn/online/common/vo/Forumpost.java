package learn.online.common.vo;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Forumpost entity. @author MyEclipse Persistence Tools
 */

public class Forumpost implements java.io.Serializable {

	// Fields

	private int fpid;
	private Foruminfo foruminfo;
	private String postman;
	private String posttitle;
	private String posttext;
	private Date posttime;
	private int right;
	private Set forumreviews = new HashSet(0);

	// Constructors

	/** default constructor */
	public Forumpost() {
	}

	/** full constructor */
	public Forumpost(Foruminfo foruminfo, String postman, String posttitle,
			String posttext, Date posttime, int right, Set forumreviews) {
		this.foruminfo = foruminfo;
		this.postman = postman;
		this.posttitle = posttitle;
		this.posttext = posttext;
		this.posttime = posttime;
		this.right = right;
		this.forumreviews = forumreviews;
	}

	// Property accessors

	public int getFpid() {
		return this.fpid;
	}

	public void setFpid(int fpid) {
		this.fpid = fpid;
	}

	public Foruminfo getForuminfo() {
		return this.foruminfo;
	}

	public void setForuminfo(Foruminfo foruminfo) {
		this.foruminfo = foruminfo;
	}

	public String getPostman() {
		return this.postman;
	}

	public void setPostman(String postman) {
		this.postman = postman;
	}

	public String getPosttitle() {
		return this.posttitle;
	}

	public void setPosttitle(String posttitle) {
		this.posttitle = posttitle;
	}

	public String getPosttext() {
		return this.posttext;
	}

	public void setPosttext(String posttext) {
		this.posttext = posttext;
	}

	public Date getPosttime() {
		return this.posttime;
	}

	public void setPosttime(Date posttime) {
		this.posttime = posttime;
	}

	public int getRight() {
		return this.right;
	}

	public void setRight(int right) {
		this.right = right;
	}

	public Set getForumreviews() {
		return this.forumreviews;
	}

	public void setForumreviews(Set forumreviews) {
		this.forumreviews = forumreviews;
	}

}