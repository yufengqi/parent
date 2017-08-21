package learn.online.common.vo;


/**
 * StudentId entity. @author MyEclipse Persistence Tools
 */

public class StudentId implements java.io.Serializable {

	// Fields

	private String yhm;
	private String registername;
	private String sex;
	private int age;
	private String image;
	private String classname;
	private String classtime;
	private String classimage;
	private int cid;

	// Constructors

	/** default constructor */
	public StudentId() {
	}

	/** minimal constructor */
	public StudentId(String yhm, String registername, int cid) {
		this.yhm = yhm;
		this.registername = registername;
		this.cid = cid;
	}

	/** full constructor */
	public StudentId(String yhm, String registername, String sex,
			int age, String image, String classname, String classtime,
			String classimage, int cid) {
		this.yhm = yhm;
		this.registername = registername;
		this.sex = sex;
		this.age = age;
		this.image = image;
		this.classname = classname;
		this.classtime = classtime;
		this.classimage = classimage;
		this.cid = cid;
	}

	// Property accessors

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

	public String getClassimage() {
		return this.classimage;
	}

	public void setClassimage(String classimage) {
		this.classimage = classimage;
	}

	public int getCid() {
		return this.cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof StudentId))
			return false;
		StudentId castOther = (StudentId) other;

		return ((this.getYhm() == castOther.getYhm()) || (this.getYhm() != null
				&& castOther.getYhm() != null && this.getYhm().equals(
				castOther.getYhm())))
				&& ((this.getRegistername() == castOther.getRegistername()) || (this
						.getRegistername() != null
						&& castOther.getRegistername() != null && this
						.getRegistername().equals(castOther.getRegistername())))
				&& ((this.getSex() == castOther.getSex()) || (this.getSex() != null
						&& castOther.getSex() != null && this.getSex().equals(
						castOther.getSex())))
				&& ((this.getAge() == castOther.getAge()) || (this.getAge() != 0
						&& castOther.getAge() != 0 && this.getAge() ==
						castOther.getAge()))
				&& ((this.getImage() == castOther.getImage()) || (this
						.getImage() != null && castOther.getImage() != null && this
						.getImage().equals(castOther.getImage())))
				&& ((this.getClassname() == castOther.getClassname()) || (this
						.getClassname() != null
						&& castOther.getClassname() != null && this
						.getClassname().equals(castOther.getClassname())))
				&& ((this.getClasstime() == castOther.getClasstime()) || (this
						.getClasstime() != null
						&& castOther.getClasstime() != null && this
						.getClasstime().equals(castOther.getClasstime())))
				&& ((this.getClassimage() == castOther.getClassimage()) || (this
						.getClassimage() != null
						&& castOther.getClassimage() != null && this
						.getClassimage().equals(castOther.getClassimage())))
				&& ((this.getCid() == castOther.getCid()) || (this.getCid() != 0
						&& castOther.getCid() != 0 && this.getCid()==
						castOther.getCid()));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getYhm() == null ? 0 : this.getYhm().hashCode());
		result = 37
				* result
				+ (getRegistername() == null ? 0 : this.getRegistername()
						.hashCode());
		result = 37 * result
				+ (getSex() == null ? 0 : this.getSex().hashCode());
		result = 37 * result
				+ (getAge() == 0 ? 0 : this.getAge());
		result = 37 * result
				+ (getImage() == null ? 0 : this.getImage().hashCode());
		result = 37 * result
				+ (getClassname() == null ? 0 : this.getClassname().hashCode());
		result = 37 * result
				+ (getClasstime() == null ? 0 : this.getClasstime().hashCode());
		result = 37
				* result
				+ (getClassimage() == null ? 0 : this.getClassimage()
						.hashCode());
		result = 37 * result
				+ (getCid() == 0 ? 0 : this.getCid());
		return result;
	}

}