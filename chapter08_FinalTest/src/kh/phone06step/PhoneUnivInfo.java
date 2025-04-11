package kh.phone06step;

public class PhoneUnivInfo extends Phone {
	private String major;
	private int year;
	
	
	public PhoneUnivInfo() {
		this(null, null, null, 0);
	}
	
	public PhoneUnivInfo(String name, String phoneNum, String major, int year) {
		super(name, phoneNum);
		this.major = major;
		this.year = year;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	@Override
	public String toString() {
		String data = super.toString();
		return "PhoneUnivInfo ["+ data + ", major=" + major + ", year=" + year + "]";
	}
	
}
