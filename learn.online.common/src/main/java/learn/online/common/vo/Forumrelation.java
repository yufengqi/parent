package learn.online.common.vo;

/**
 * Forumrelation entity. @author MyEclipse Persistence Tools
 */

public class Forumrelation implements java.io.Serializable {

	// Fields

	private int id;
	private Registertable registertableBySid;
	private Foruminfo foruminfo;
	private Registertable registertableByJid;
	private int tforumidentity;
	private int sforumidentity;

	// Constructors

	/** default constructor */
	public Forumrelation() {
	}

	/** full constructor */
	public Forumrelation(Registertable registertableBySid, Foruminfo foruminfo,
			Registertable registertableByJid, int tforumidentity,
			int sforumidentity) {
		this.registertableBySid = registertableBySid;
		this.foruminfo = foruminfo;
		this.registertableByJid = registertableByJid;
		this.tforumidentity = tforumidentity;
		this.sforumidentity = sforumidentity;
	}

	// Property accessors

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Registertable getRegistertableBySid() {
		return this.registertableBySid;
	}

	public void setRegistertableBySid(Registertable registertableBySid) {
		this.registertableBySid = registertableBySid;
	}

	public Foruminfo getForuminfo() {
		return this.foruminfo;
	}

	public void setForuminfo(Foruminfo foruminfo) {
		this.foruminfo = foruminfo;
	}

	public Registertable getRegistertableByJid() {
		return this.registertableByJid;
	}

	public void setRegistertableByJid(Registertable registertableByJid) {
		this.registertableByJid = registertableByJid;
	}

	public int getTforumidentity() {
		return this.tforumidentity;
	}

	public void setTforumidentity(int tforumidentity) {
		this.tforumidentity = tforumidentity;
	}

	public int getSforumidentity() {
		return this.sforumidentity;
	}

	public void setSforumidentity(int sforumidentity) {
		this.sforumidentity = sforumidentity;
	}

}