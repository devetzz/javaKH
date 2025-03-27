package chapter02;

public class TypeConvert {

	public static void main(String[] args) {
		int i = 0;
		double f = 0.0;
		
		// 피연산자가 정수이므로 정수 연산이 된다.
		f = 1 / 5;
		System.out.println(f);
		//형변환 연산자가 먼저 1을 소수로 바꾸고 1.0 / 5는 피연산자중 하나가 double이라서 자동 형변환되어 연산된다.
		f = (double)1 / 5;
		System.out.println(f);
		// 평변환 연산자가 1.7과 1.8 모두 1로 바꾼 후 연산하여 1+1=2가 된다.
		i = (int)1.7 / (int)1.8;
		System.out.println(i);
	}

}
