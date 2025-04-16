package kh.set;

import java.util.Objects;

public class Data {
	// 변수
	private String phone;

	// 생성자
	public Data() {
		this(null);
	}
	public Data(String phone) {
		super();
		this.phone = phone;
	}
	
	// 함수
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	@Override
	public int hashCode() {
		// 객체 주소로 변환된 hashCode값을 준다.
		return Objects.hash(phone);
	}
	
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Data)) {
			return false;
		}
		Data data = (Data)obj;
		return this.phone.equals(data.phone);
	}
	
	@Override
	public String toString() {
		return "Data [phone=" + phone + "]";
	}
	
}
