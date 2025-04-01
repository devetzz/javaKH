package chapter04;

import java.util.Scanner;


public class WeatherMain {

	public static void main(String[] args) {
		// 변수 선언
		Scanner scan = new Scanner(System.in);
		Weather weather = new Weather();

		while (true) {
			System.out.print("지역 입력 : ");
			weather.area = scan.nextLine();

			char fc = 0;
			double temperature = 0.0;
			;
			System.out.print("선택(f/c)");
			fc = scan.nextLine().charAt(0);

			if (fc == 'f') {
				System.out.print("화씨 온도 입력 : ");
				weather.temperatureF = Double.parseDouble(scan.nextLine());
				temperature = weather.ConvertFtoC();
				// 출력
				System.out.printf("%s 지역의 변환된 섭씨 온도는 %.2f 입니다.\n", weather.area, temperature);
			} else {
				System.out.print("섭씨 온도 입력 : ");
				weather.temperatureC = Double.parseDouble(scan.nextLine());
				temperature = weather.ConvertCtoF();
				// 출력
				System.out.printf("%s 지역의 변환된 화씨 온도는 %.2f 입니다.\n", weather.area, temperature);
			}

			

			// 계속 유무
			char yn = 0;
			do {
				// 값 입력
				System.out.print("계속(y/n)");
				yn = scan.nextLine().charAt(0);
				if (yn == 'n' || yn == 'N' || yn == 'y' || yn == 'Y')
					break;
				System.out.println("정신차려!");
			} while (true);

			if (yn == 'n' || yn == 'N') {
				System.out.println("종료!");
				scan.close();
				break;

			}

		}
		
	}

}
