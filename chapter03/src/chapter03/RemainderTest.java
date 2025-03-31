package chapter03;

public class RemainderTest {

	public static void main(String[] args) {
		// 1~100 사이의 정수에서 6의 배수의 합을 구하는 프로그램
		int sum = 0;
		for (int i = 0; i < 100; i++) {
			if ((i+1)%6 == 0) {
				sum = sum + (i + 1);
			}
		}
		System.out.println("1~100사이 6의 배수의 합은 " + sum + " 입니다.");
		System.out.printf("1~100사이 6의 배수의 합은 %d 입니다.", sum);
		

	}

}
