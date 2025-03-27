package chapter02;

public class TestOperator {

	public static void main(String[] args) {
		int x = 10, y = x + 1, z = y *10;
		
		System.out.printf("z = %d\n",z);
		
		// 형변환 우선순위 테스트
		System.out.println((int)12.3+(double)10);
	}

}
