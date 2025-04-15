package selftraning;

import java.text.DecimalFormat;

public class DecimalTest {

	public static void main(String[] args) {
		DecimalFormat formatter = new DecimalFormat("###,###");
		int price1 = 123;
		int price2 = 1234;
		int price3 = 12345;
		int price4 = 123456;
		int price5 = 1234567;
		
		System.out.println(formatter.format(price1));
		System.out.println(formatter.format(price2));
		System.out.println(formatter.format(price3));
		System.out.println(formatter.format(price4));
		System.out.println(formatter.format(price5));
	}
}
