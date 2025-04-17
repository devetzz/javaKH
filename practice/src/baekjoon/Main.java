package baekjoon;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// 검증수는 고유번호의 처음 5자리에 들어가는 5개의 숫자를 각각 제곱한 수의 합을 10으로 나눈 나머지이다.
		Scanner scan = new Scanner(System.in);
//		String[] s = scan.nextLine().split(" ");
		String s1 = scan.nextLine();
		String s2 = scan.nextLine();
		String s3 = scan.nextLine();
		
		int i1 = Integer.parseInt(s1);
		int i2 = Integer.parseInt(s2);
		int i3 = Integer.parseInt(s3);
		
		
		System.out.println(i1+i2-i3);
		System.out.println(Integer.parseInt(s1+s2)-i3);
	}
}
