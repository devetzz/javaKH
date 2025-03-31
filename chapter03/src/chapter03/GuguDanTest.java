package chapter03;

public class GuguDanTest {

	public static void main(String[] args) {
		// 구구단
		for(int y = 0; y < 20; y+=4) {
			System.out.printf("-------------------------------------------------------------\n");
			for(int x = 0 ; x < 9; x++) {
				System.out.printf("%2d x %d = %3d |\t", y+1, x+1, (x+1)*(y+1));
				System.out.printf("%2d x %d = %3d |\t", y+2, x+1, (y+2)*(x+1));
				System.out.printf("%2d x %d = %3d |\t", y+3, x+1, (y+3)*(x+1));
				System.out.printf("%2d x %d = %3d\n", y+4, x+1, (y+4)*(x+1));
			}
		}
		System.out.printf("-------------------------------------------------------------\n");
	}

	
    //1단씩 출력
    public static void gugudanTest1() {
        for(int y=0;y<9;y=y+1) {
            for(int x=0;x<9;x++) {
                System.out.printf("%d x %d = %d \n",y+1,x+1,(y+1)*(x+1));
            }
            System.out.println();
        }
    }
    //3단씩 출력
    public static void gugudanTest2() {
        for(int y=0;y<9;y=y+3) {
            for(int x=0;x<9;x++) {
                System.out.printf("%d x %d = %d \t",y+1,x+1,(y+1)*(x+1));
                System.out.printf("%d x %d = %d \t",y+2,x+1,(y+2)*(x+1));
                System.out.printf("%d x %d = %d \n",y+3,x+1,(y+3)*(x+1));
            }
            System.out.println();
        }
    }
	
}
