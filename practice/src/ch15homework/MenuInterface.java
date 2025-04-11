package ch15homework;

public interface MenuInterface {
	// "가져오기","추가입력","출력","최대값","최소값","검색","삭제","수정","저장","종료"
	public static final int LOAD = 1;
	public static final int INPUT = 2;
	public static final int OUTPUT = 3;
	public static final int MAX = 4;
	public static final int MIN = 5;
	public static final int SEARCH = 6;
	public static final int DELETE = 7;
	public static final int UPDATE = 8;
	public static final int SAVE = 9;
	public static final int ASC = 10;
	public static final int DESC = 11;
	public static final int EXIT = 12;
	
	public static void menuPrint() {
		// 메뉴
		System.out.println("★★★★★★★★ MENU ★★★★★★★★");
		System.out.printf("%s\t", "1. 임직원 가져오기");
		System.out.printf("%s\t", "2. 임직원 추가입력");
		System.out.printf("%s\n", "3. 임직원 출력");
		System.out.printf("%s\t\t", "4. 급여 최대값");
		System.out.printf("%s\t\t", "5. 급여 최소값");
		System.out.printf("%s\n", "6. 임직원 검색");
		System.out.printf("%s\t\t", "7. 임직원 삭제");
		System.out.printf("%s\t\t", "8. 임직원 수정");
		System.out.printf("%s\n", "9. 인사파일 저장");
		System.out.printf("%s\t", "10. 오름차순 정렬");
		System.out.printf("%s\t", "11. 내림차순 정렬");
		System.out.printf("%s\n", "12. 종료");
		System.out.println("★★★★★★★★★★★★★★★★★★★★★");
	}
	
}
