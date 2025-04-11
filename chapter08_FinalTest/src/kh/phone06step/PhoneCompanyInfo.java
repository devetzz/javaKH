package kh.phone06step;

public class PhoneCompanyInfo extends Phone {
	private String company;
	
	public PhoneCompanyInfo() {
		this(null, null, null);
	}
	
	public PhoneCompanyInfo(String name, String phoneNum, String company) {
		super(name, phoneNum);
		this.company = company;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	@Override
	public String toString() {
		String data = super.toString();
		return "PhoneUnivInfo ["+ data + ", company=" + company + "]";
	}
	
}
