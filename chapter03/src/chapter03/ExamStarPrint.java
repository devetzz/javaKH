package chapter03;

public class ExamStarPrint {

	public static void main(String[] args) {
		// 별표 찍기
		for (int y = 0; y < 8; y++) {
			for (int s = 0 ;s<y;s++) {
				System.out.print(" ");
			}
			for (int x = 0; x < 15-(2*y); x++) {
				System.out.print("*");
			}
			
			System.out.println();
		}
	}

}
