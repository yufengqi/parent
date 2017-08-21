package learn.online.common.vo;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Workinfo entity. @author MyEclipse Persistence Tools
 */

public class Workinfo implements java.io.Serializable {

	// Fields

	private int zyid;
	private String worktitle;
	private String worktext;
	private String studentname;
	private String other;
	private String reviewtext;
	private int reviewgrand;
	private String teachername;
	private Date reviewtime;
	private Set cwrrations = new HashSet(0);

	// Constructors

	/** default constructor */
	public Workinfo() {
	}

	/** full constructor */
	public Workinfo(String worktitle, String worktext, String studentname,
			String other, String reviewtext, int reviewgrand,
			String teachername, Date reviewtime, Set cwrrations) {
		this.worktitle = worktitle;
		this.worktext = worktext;
		this.studentname = studentname;
		this.other = other;
		this.reviewtext = reviewtext;
		this.reviewgrand = reviewgrand;
		this.teachername = teachername;
		this.reviewtime = reviewtime;
		this.cwrrations = cwrrations;
	}

	// Property accessors

	public int getZyid() {
		return this.zyid;
	}

	public void setZyid(int zyid) {
		this.zyid = zyid;
	}

	public String getWorktitle() {
		return this.worktitle;
	}

	public void setWorktitle(String worktitle) {
		this.worktitle = worktitle;
	}

	public String getWorktext() {
		return this.worktext;
	}

	public void setWorktext(String worktext) {
		this.worktext = worktext;
	}

	public String getStudentname() {
		return this.studentname;
	}

	public void setStudentname(String studentname) {
		this.studentname = studentname;
	}

	public String getOther() {
		return this.other;
	}

	public void setOther(String other) {
		this.other = other;
	}

	public String getReviewtext() {
		return this.reviewtext;
	}

	public void setReviewtext(String reviewtext) {
		this.reviewtext = reviewtext;
	}

	public int getReviewgrand() {
		return this.reviewgrand;
	}

	public void setReviewgrand(int reviewgrand) {
		this.reviewgrand = reviewgrand;
	}

	public String getTeachername() {
		return this.teachername;
	}

	public void setTeachername(String teachername) {
		this.teachername = teachername;
	}

	public Date getReviewtime() {
		return this.reviewtime;
	}

	public void setReviewtime(Date reviewtime) {
		this.reviewtime = reviewtime;
	}

	public Set getCwrrations() {
		return this.cwrrations;
	}

	public void setCwrrations(Set cwrrations) {
		this.cwrrations = cwrrations;
	}

}