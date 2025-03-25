package hello;

public class Hello {

	public static void main(String[] args) {
		//입력(이름, 나이, 몸무게, 혈액형, 성별)
		String name = "";
		int age = 0;
		double weight = 0.0;
		String bloodType = "";
		boolean gender = false;
		char grade = 0;
		
		name = "pi";
		age = 3;
		weight = 3.14;
		bloodType = "B";
		gender = true;
		grade = 'A';

		//연산
		
		//출력(이름, 나이, 몸무게, 혈액형, 성별)
		System.out.println("name = "+ name);
		System.out.printf("name = %s \n", name);
		System.out.printf("age = %d \n", age);
		System.out.printf("weight = %6.2f \n", weight);
		System.out.printf("bloodType = %s형\n", bloodType);
		
		if(gender == true) {
			System.out.printf("gender = 남자 \n");
		}else {
			System.out.printf("gender = 여자 \n");
		}
		System.out.printf("grade = %c \n", grade);
		
		/*
		System.out.println(age);
		System.out.println(weight);
		System.out.println(bloodType);
		System.out.println(gender);
		System.out.println(grade);
		*/
	}

}
