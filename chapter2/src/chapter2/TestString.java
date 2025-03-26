package chapter2;

public class TestString {

	public static void main(String[] args) {
		String message1 = "Hello";
		String message2 = "Gildong";
		
		System.out.printf("%10s \n", message1);
		System.out.printf("%10s \n", message2);
		
		System.out.printf("%s 당신의 나이는 %d살 입니다.\n", message1+" "+message2, 60);
		
		System.out.printf("The End \n");
		
	}

}
