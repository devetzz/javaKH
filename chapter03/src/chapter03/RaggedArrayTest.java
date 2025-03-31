package chapter03;

public class RaggedArrayTest {

	public static void main(String[] args) {
		// 2차원 배열 선언하고 값을 입력
		int [][] arr = new int[4][];
		arr[0] = new int[] {3,5,7,9};
		arr[1] = new int[] {4,2};
		arr[2] = new int[] {5,7,8,6};
		arr[3] = new int[] {6};
		
		for(int y = 0; y < arr.length; y++) {
			for(int x = 0; x < arr[y].length; x++) {
				System.out.printf("arr[%d][%d] = %d \t", y, x, arr[y][x]);
			}
			System.out.println();
		}
		
		
		
		
	}
	public static void ReggedArray1() {
//		int[] a1 = new int[3];
//		int[][] arr = new int[3][];
//		
//		arr[0] = new int[]{1,2,3};
//		arr[1] = new int[]{4,5,6,7};
//		arr[2] = new int[]{8,9};
//		
//		// 2차원 배열값 출력
//		for(int y = 0; y < arr.length; y++) {
//			for(int x = 0; x < arr[y].length; x++) {
//				System.out.printf("arr[%d][%d] = %d\t",y,x,arr[y][x]);
//			}
//			System.out.println();
//		}
//		
//		
//		// 종료
//		System.out.println("End");
	}
}
