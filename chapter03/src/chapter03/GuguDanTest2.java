package chapter03;

public class GuguDanTest2 {

	public static void main(String[] args) {
		// 구구단 2단씩 10단까지 출력
		for(int y = 0; y < 10; y+=2) {
			for(int x = 0; x < 9; x++) {
				System.out.printf("%d x %d = %d\t", y+1, x+1, (y+1)*(x+1));
				System.out.printf("%d x %d = %d\n", y+2, x+1, (y+2)*(x+1));
			}
			System.out.println();
		}

	}

}
