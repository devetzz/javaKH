package chapter03;

public class StarPrintTest {

	public static void main(String[] args) {
		// 별표 찍기 공식(x, y 좌표를 생각할 것)
		// 변곡점이 있을때 if를 쓴다
		for (int y = 0; y < 13; y++) {
			if(y < 6) {
				for (int x = 0; x < y + 1; x++) {
					System.out.print("*");
				}
				for (int s = 0; s < 11 - 2 * y; s++) {
					System.out.print(" ");
				}
				for (int x = 0; x < y + 1; x++) {
					System.out.print("*");
				}
			}else if (y == 6) {
				for(int x=0;x<13;x++) {
					System.out.print("*");
				}
			}else {
				for (int x = 0; x < 13 - y; x++) {
					System.out.print("*");
				}
				for (int s = 0; s < 2 * y - 13; s++) {
					System.out.print(" ");
				}
				for (int x = 0; x < 13 - y; x++) {
					System.out.print("*");
				}
			}
			System.out.println();
		}
	}

	
	
	
	public static void starPrint1step() {
		// 사각형
		for (int y = 0; y < 5; y++) {
			for (int x = 0; x < 10; x++) {
				System.out.print("*");
			}
			System.out.println("");
		}
		
	}

	public static void starPrint2step() {
		//직각 삼각형
		for (int y = 0; y < 8; y++) {
			for (int x = 0; x < (y + 1); x++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	public static void starPrint3step() {
		// 직각 삼각형
		for (int y = 0; y < 5; y++) {
			for (int x = 0; x < 5 - y; x++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	public static void starPrint4step() {
		// 직각 삼각형
		for (int y = 0; y < 8; y++) {
			for (int s = 0; s < 7 - y; s++) {
				System.out.print(" ");
			}
			for (int x = 0; x < y + 1; x++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	public static void starPrint5step() {
		// 삼각형
		for (int y = 0; y < 8; y++) {
			for (int s = 0; s < 7 - y; s++) {
				System.out.print(" ");
			}
			for (int x = 0; x < 2 * y + 1; x++) {
				System.out.print("*");
			}

			System.out.println();
		}
	}
	
	public static void starPrint6Step() {
		// 마름모
		for (int y = 0; y < 19; y++) {
			if(y <= 9) {
				for (int s = 0; s < 9 - y; s++) {
					System.out.print(' ');
				}
				for (int x = 0; x < 2 * y + 1; x++) {
					System.out.print("*");
				}
			}else {
				for (int s = 0; s < y - 9; s++) {
					System.out.print(' ');
				}
				for (int x = 0; x < (-2) * y + 37; x++) {
					System.out.print("*");
				}
			}
			
			System.out.println();
		}
	}
	
	public static void starPrint7Step() {
		// 모래시계
		for (int y = 0; y < 9; y++) {
			if(y <= 4) {
				for (int s = 0; s < y; s++) {
					System.out.print(' ');
				}
				for (int x = 0; x < (-2 * y) + 9; x++) {
					System.out.print("*");
				}
			}else {
				for (int s = 0; s < 8 - y; s++) {
					System.out.print(' ');
				}
				for (int x = 0; x < 2 * y - 7; x++) {
					System.out.print("*");
				}
			}
			
			System.out.println();
		}
	}
}