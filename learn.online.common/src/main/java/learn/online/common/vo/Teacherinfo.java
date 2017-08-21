package learn.online.common.vo;


/**
 * Teacherinfo entity. @author MyEclipse Persistence Tools
 */

public class Teacherinfo implements java.io.Serializable {

	// Fields

	private int tid;
	private Registertable registertable;
	private String oldteach;
	private String result;
	private String classstyle;
	private String book;
	private String honour;

	// Constructors

	/** default constructor */
	public Teacherinfo() {
	}

	/** full constructor */
	public Teacherinfo(Registertable registertable, String oldteach,
			String result, String classstyle, String book, String honour) {
		this.registertable = registertable;
		this.oldteach = oldteach;
		this.result = result;
		this.classstyle = classstyle;
		this.book = book;
		this.honour = honour;
	}

	// Property accessors

	public int getTid() {
		return this.tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}

	public Registertable getRegistertable() {
		return this.registertable;
	}

	public void setRegistertable(Registertable registertable) {
		this.registertable = registertable;
	}

	public String getOldteach() {
		return this.oldteach;
	}

	public void setOldteach(String oldteach) {
		this.oldteach = oldteach;
	}

	public String getResult() {
		return this.result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getClassstyle() {
		return this.classstyle;
	}

	public void setClassstyle(String classstyle) {
		this.classstyle = classstyle;
	}

	public String getBook() {
		return this.book;
	}

	public void setBook(String book) {
		this.book = book;
	}

	public String getHonour() {
		return this.honour;
	}

	public void setHonour(String honour) {
		this.honour = honour;
	}

}