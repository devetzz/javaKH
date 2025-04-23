package theater;

public class Reservation extends Movie {
	private int phoneNum;
	private String userName;
	//movieName
	private int seatNum;
	
	public Reservation() {
		this(0,null,null,0);
	}

	public Reservation(int phoneNum, String userName, String movieName, int seatNum) {
		super();
		this.phoneNum = phoneNum;
		this.userName = userName;
		this.seatNum = seatNum;
	}

	public int getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(int phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getSeatNum() {
		return seatNum;
	}

	public void setSeatNum(int seatNum) {
		this.seatNum = seatNum;
	}

	@Override
	public String toString() {
		return "Reservation [" + phoneNum + ", " + userName + ", " + this.getMovieName() + ", " + seatNum + "]";
	}
	
	
}
