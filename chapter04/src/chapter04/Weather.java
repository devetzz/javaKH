package chapter04;

public class Weather {
	// 멤버 변수(지역, 온도) 자동 초기화
	public String area;
	public double temperatureF;
	public double temperatureC;
	
	
	// 멤버 함수(섭씨, 화씨 변환)
	public double ConvertFtoC() {
		temperatureC = (temperatureF-32) / 1.8;
		return temperatureC;
	}
	
	public double ConvertCtoF() {
		temperatureF = 9 / 5 * temperatureC + 32;
		return temperatureF;
	}
}
