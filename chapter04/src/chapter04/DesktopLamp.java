package chapter04;

public class DesktopLamp {
	// 멤버 변수
	private boolean isOn;

	// 멤버 함수
	public boolean getOn() {
		return isOn;
	}

	public void setOn(boolean isOn) {
		this.isOn = isOn;
	}

	// 출력 함수(멤버 변수를 출력하는 기능)
	@Override
	public String toString() {
		return "DesktopLamp [isOn=" + isOn + "]";
	}
	
	
	
	
}
