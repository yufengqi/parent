package learn.online.common.vo;

import java.util.HashSet;
import java.util.Set;

/**
 * Classinfo entity. @author MyEclipse Persistence Tools
 */

public class Classinfo implements java.io.Serializable {

	// Fields

	private int cid;
	private String classname;
	private String classtime;
	private String classplan;
	private String classbook;
	private String classexam;
	private String classneedbase;
	private String classwork;
	private int right;
	private String classimage;
	private String classlink;
	private Set cwrrations = new HashSet(0);
	private Set upinfos = new HashSet(0);
	private Set learninfos = new HashSet(0);

	// Constructors

	/** default constructor */
	public Classinfo() {
	}

	/** full constructor */
	public Classinfo(String classname, String classtime, String classplan,
			String classbook, String classexam, String classneedbase,
			String classwork, int right, String classimage,
			Set cwrrations, Set upinfos, Set learninfos) {
		this.classname = classname;
		this.classtime = classtime;
		this.classplan = classplan;
		this.classbook = classbook;
		this.classexam = classexam;
		this.classneedbase = classneedbase;
		this.classwork = classwork;
		this.right = right;
		this.classimage = classimage;
		this.cwrrations = cwrrations;
		this.upinfos = upinfos;
		this.learninfos = learninfos;
	}

	// Property accessors

	public int getCid() {
		return this.cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getClassname() {
		return this.classname;
	}

	public void setClassname(String classname) {
		this.classname = classname;
	}

	public String getClasstime() {
		return this.classtime;
	}

	public void setClasstime(String classtime) {
		this.classtime = classtime;
	}

	public String getClassplan() {
		return this.classplan;
	}

	public void setClassplan(String classplan) {
		this.classplan = classplan;
	}

	public String getClassbook() {
		return this.classbook;
	}

	public void setClassbook(String classbook) {
		this.classbook = classbook;
	}

	public String getClassexam() {
		return this.classexam;
	}

	public void setClassexam(String classexam) {
		this.classexam = classexam;
	}

	public String getClassneedbase() {
		return this.classneedbase;
	}

	public void setClassneedbase(String classneedbase) {
		this.classneedbase = classneedbase;
	}

	public String getClasswork() {
		return this.classwork;
	}

	public void setClasswork(String classwork) {
		this.classwork = classwork;
	}

	public int getRight() {
		return this.right;
	}

	public void setRight(int right) {
		this.right = right;
	}

	public String getClassimage() {
		return this.classimage;
	}

	public void setClassimage(String classimage) {
		this.classimage = classimage;
	}

	public Set getCwrrations() {
		return this.cwrrations;
	}

	public void setCwrrations(Set cwrrations) {
		this.cwrrations = cwrrations;
	}

	public Set getUpinfos() {
		return this.upinfos;
	}

	public void setUpinfos(Set upinfos) {
		this.upinfos = upinfos;
	}

	public Set getLearninfos() {
		return this.learninfos;
	}

	public void setLearninfos(Set learninfos) {
		this.learninfos = learninfos;
	}

	public String getClasslink() {
		return classlink;
	}

	public void setClasslink(String classlink) {
		this.classlink = classlink;
	}

}