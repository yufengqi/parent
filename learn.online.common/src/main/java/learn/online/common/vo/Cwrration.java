package learn.online.common.vo;


/**
 * Cwrration entity. @author MyEclipse Persistence Tools
 */

public class Cwrration implements java.io.Serializable {

	// Fields

	private int rid;
	private Classinfo classinfo;
	private Registertable registertableBySid;
	private Workinfo workinfo;
	private Registertable registertableByJid;
	private int tclassidentity;
	private int sclassindentity;

	// Constructors

	/** default constructor */
	public Cwrration() {
	}

	/** full constructor */
	public Cwrration(Classinfo classinfo, Registertable registertableBySid,
			Workinfo workinfo, Registertable registertableByJid,
			int tclassidentity, int sclassindentity) {
		this.classinfo = classinfo;
		this.registertableBySid = registertableBySid;
		this.workinfo = workinfo;
		this.registertableByJid = registertableByJid;
		this.tclassidentity = tclassidentity;
		this.sclassindentity = sclassindentity;
	}

	// Property accessors

	public int getRid() {
		return this.rid;
	}

	public void setRid(int rid) {
		this.rid = rid;
	}

	public Classinfo getClassinfo() {
		return this.classinfo;
	}

	public void setClassinfo(Classinfo classinfo) {
		this.classinfo = classinfo;
	}

	public Registertable getRegistertableBySid() {
		return this.registertableBySid;
	}

	public void setRegistertableBySid(Registertable registertableBySid) {
		this.registertableBySid = registertableBySid;
	}

	public Workinfo getWorkinfo() {
		return this.workinfo;
	}

	public void setWorkinfo(Workinfo workinfo) {
		this.workinfo = workinfo;
	}

	public Registertable getRegistertableByJid() {
		return this.registertableByJid;
	}

	public void setRegistertableByJid(Registertable registertableByJid) {
		this.registertableByJid = registertableByJid;
	}

	public int getTclassidentity() {
		return this.tclassidentity;
	}

	public void setTclassidentity(int tclassidentity) {
		this.tclassidentity = tclassidentity;
	}

	public int getSclassindentity() {
		return this.sclassindentity;
	}

	public void setSclassindentity(int sclassindentity) {
		this.sclassindentity = sclassindentity;
	}

}