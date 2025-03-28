package chapter03;

public class StarPrintTest {

	public static void main(String[] args) {
		// 별표 찍기 공식(x, y 좌표를 생각할 것)
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

	
	
	
	public static void starPrint1step() {

		for (int y = 0; y < 5; y++) {
			for (int x = 0; x < 10; x++) {
				System.out.print("*");
			}
			System.out.println("");
		}
		
	}

	public static void starPrint2step() {
		
		for (int y = 0; y < 8; y++) {
			for (int x = 0; x < (y + 1); x++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	public static void starPrint3step() {
		
		for (int y = 0; y < 5; y++) {
			for (int x = 0; x < 5 - y; x++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	public static void starPrint4step() {
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
	
	
}