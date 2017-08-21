package learn.online.common.vo;

import java.util.HashSet;
import java.util.Set;

/**
 * Registertable entity. @author MyEclipse Persistence Tools
 */

public class Registertable implements java.io.Serializable {

	// Fields

	private int zcid;
	private String yhm;
	private String registername;
	private String dlpassword;
	private String qrpassword;
	private String email;
	private String sex;
	private int age;
	private String image;
	private String science;
	private int identity;
	private Set publicnotices = new HashSet(0);
	private Set forumrelationsForJid = new HashSet(0);
	private Set forumrelationsForSid = new HashSet(0);
	private Set teacherinfos = new HashSet(0);
	private Set cwrrationsForJid = new HashSet(0);
	private Set cwrrationsForSid = new HashSet(0);

	// Constructors

	/** default constructor */
	public Registertable() {
	}

	/** minimal constructor */
	public Registertable(String yhm, String registername, String dlpassword,
			String qrpassword) {
		this.yhm = yhm;
		this.registername = registername;
		this.dlpassword = dlpassword;
		this.qrpassword = qrpassword;
	}

	/** full constructor */
	public Registertable(String yhm, String registername, String dlpassword,
			String qrpassword, String email, String sex, int age,
			String image, String science, int identity,
			Set publicnotices, Set forumrelationsForJid,
			Set forumrelationsForSid, Set teacherinfos, Set cwrrationsForJid,
			Set cwrrationsForSid) {
		this.yhm = yhm;
		this.registername = registername;
		this.dlpassword = dlpassword;
		this.qrpassword = qrpassword;
		this.email = email;
		this.sex = sex;
		this.age = age;
		this.image = image;
		this.science = science;
		this.identity = identity;
		this.publicnotices = publicnotices;
		this.forumrelationsForJid = forumrelationsForJid;
		this.forumrelationsForSid = forumrelationsForSid;
		this.teacherinfos = teacherinfos;
		this.cwrrationsForJid = cwrrationsForJid;
		this.cwrrationsForSid = cwrrationsForSid;
	}

	// Property accessors

	public int getZcid() {
		return this.zcid;
	}

	public void setZcid(int zcid) {
		this.zcid = zcid;
	}

	public String getYhm() {
		return this.yhm;
	}

	public void setYhm(String yhm) {
		this.yhm = yhm;
	}

	public String getRegistername() {
		return this.registername;
	}

	public void setRegistername(String registername) {
		this.registername = registername;
	}

	public String getDlpassword() {
		return this.dlpassword;
	}

	public void setDlpassword(String dlpassword) {
		this.dlpassword = dlpassword;
	}

	public String getQrpassword() {
		return this.qrpassword;
	}

	public void setQrpassword(String qrpassword) {
		this.qrpassword = qrpassword;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public int getAge() {
		return this.age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getScience() {
		return this.science;
	}

	public void setScience(String science) {
		this.science = science;
	}

	public int getIdentity() {
		return this.identity;
	}

	public void setIdentity(int identity) {
		this.identity = identity;
	}

	public Set getPublicnotices() {
		return this.publicnotices;
	}

	public void setPublicnotices(Set publicnotices) {
		this.publicnotices = publicnotices;
	}

	public Set getForumrelationsForJid() {
		return this.forumrelationsForJid;
	}

	public void setForumrelationsForJid(Set forumrelationsForJid) {
		this.forumrelationsForJid = forumrelationsForJid;
	}

	public Set getForumrelationsForSid() {
		return this.forumrelationsForSid;
	}

	public void setForumrelationsForSid(Set forumrelationsForSid) {
		this.forumrelationsForSid = forumrelationsForSid;
	}

	public Set getTeacherinfos() {
		return this.teacherinfos;
	}

	public void setTeacherinfos(Set teacherinfos) {
		this.teacherinfos = teacherinfos;
	}

	public Set getCwrrationsForJid() {
		return this.cwrrationsForJid;
	}

	public void setCwrrationsForJid(Set cwrrationsForJid) {
		this.cwrrationsForJid = cwrrationsForJid;
	}

	public Set getCwrrationsForSid() {
		return this.cwrrationsForSid;
	}

	public void setCwrrationsForSid(Set cwrrationsForSid) {
		this.cwrrationsForSid = cwrrationsForSid;
	}

}