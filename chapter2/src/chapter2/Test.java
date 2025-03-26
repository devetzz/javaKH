package chapter2;

public class Test {

	public static void main(String[] args) {
		int num1 = 0;
		int num2 = 0;
		
		num1 = 20;
		num2 = 35;
		
		System.out.println("12345678901234567890");
		System.out.printf("큰 수 : %d\n",(num1 >= num2)?(num1):(num2));
		System.out.printf("작은 수 : %d\n",(num1 < num2)?(num1):(num2));
		// 라이브러리를 사용하여 한줄로 코딩 가능, 속도는 떨어짐
		System.out.printf("큰 수 : %d\n작은 수 : %d\n",Math.max(num1, num2),Math.min(num1, num2));
		System.out.printf("평균 : %6.2f\n",(num1 + num2) / (double)2);
		
		System.out.println("The end");
	}

}



