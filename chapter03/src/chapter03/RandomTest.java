package chapter03;

public class RandomTest {

	public static void main(String[] args) {
		// 랜덤 테스트
		int v = 10;
		int k = ++v%5;
		System.out.println((int)Math.random());

		System.out.println(v);
		System.out.println(k);
		
		System.out.println(10+20+"8");
		
		String s1 = "abc";
		String s2 = "def";
		String s3 = s2;
		s2 = "ghi";
		
		System.out.println(s1+s2+s3);
				
		int x = 100;
		double y = 123.4;
		boolean b = (x == y);
		System.out.println(b);
		
	}

}
