package learn.online.common.vo;

import java.util.Date;

/**
 * Forumreview entity. @author MyEclipse Persistence Tools
 */

public class Forumreview implements java.io.Serializable {

	// Fields

	private int frid;
	private Forumpost forumpost;
	private String forumrman;
	private String forumrtext;
	private Date forumrtime;

	// Constructors

	/** default constructor */
	public Forumreview() {
	}

	/** full constructor */
	public Forumreview(Forumpost forumpost, String forumrman,
			String forumrtext, Date forumrtime) {
		this.forumpost = forumpost;
		this.forumrman = forumrman;
		this.forumrtext = forumrtext;
		this.forumrtime = forumrtime;
	}

	// Property accessors

	public int getFrid() {
		return this.frid;
	}

	public void setFrid(int frid) {
		this.frid = frid;
	}

	public Forumpost getForumpost() {
		return this.forumpost;
	}

	public void setForumpost(Forumpost forumpost) {
		this.forumpost = forumpost;
	}

	public String getForumrman() {
		return this.forumrman;
	}

	public void setForumrman(String forumrman) {
		this.forumrman = forumrman;
	}

	public String getForumrtext() {
		return this.forumrtext;
	}

	public void setForumrtext(String forumrtext) {
		this.forumrtext = forumrtext;
	}

	public Date getForumrtime() {
		return this.forumrtime;
	}

	public void setForumrtime(Date forumrtime) {
		this.forumrtime = forumrtime;
	}

}