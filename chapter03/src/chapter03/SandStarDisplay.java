package chapter03;

public class SandStarDisplay {

	public static void main(String[] args) {
		// 모래시계 별표 찍기
		for(int y = 0; y < 9; y++) {
			if (y <= 4) {
				for(int s = 0; s < y; s++) {
					System.out.print(" ");
				}
				for(int x = 0; x < (-2*y)+9; x++) {
					System.out.print("*");
				}
			}else {
				for(int s = 0; s < 8-y; s++) {
					System.out.print(" ");
				}
				for(int x = 0; x < (2*y)-7; x++) {
					System.out.print("*");
				}
			}
			System.out.println();
		}

	}

}
