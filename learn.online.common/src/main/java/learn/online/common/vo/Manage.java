package learn.online.common.vo;

import java.util.HashSet;
import java.util.Set;

/**
 * Manage entity. @author MyEclipse Persistence Tools
 */

public class Manage implements java.io.Serializable {

	// Fields

	private int mid;
	private String yhm;
	private String dlpassword;
	private int identity;
	private Set publicnotices = new HashSet(0);

	// Constructors

	/** default constructor */
	public Manage() {
	}

	/** minimal constructor */
	public Manage(String yhm, String dlpassword) {
		this.yhm = yhm;
		this.dlpassword = dlpassword;
	}

	/** full constructor */
	public Manage(String yhm, String dlpassword, int identity,
			Set publicnotices) {
		this.yhm = yhm;
		this.dlpassword = dlpassword;
		this.identity = identity;
		this.publicnotices = publicnotices;
	}

	// Property accessors

	public int getMid() {
		return this.mid;
	}

	public void setMid(int mid) {
		this.mid = mid;
	}

	public String getYhm() {
		return this.yhm;
	}

	public void setYhm(String yhm) {
		this.yhm = yhm;
	}

	public String getDlpassword() {
		return this.dlpassword;
	}

	public void setDlpassword(String dlpassword) {
		this.dlpassword = dlpassword;
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

}