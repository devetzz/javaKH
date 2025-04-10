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
		System.out.println("★ \t1. 임직원 가져오기\t ★");
		System.out.println("★ \t2. 임직원 추가입력\t ★");
		System.out.println("★ \t3. 임직원 출력\t ★");
		System.out.println("★ \t4. 급여 최대값\t ★");
		System.out.println("★ \t5. 급여 최소값\t ★");
		System.out.println("★ \t6. 임직원 검색\t ★");
		System.out.println("★ \t7. 임직원 삭제\t ★");
		System.out.println("★ \t8. 임직원 수정\t ★");
		System.out.println("★ \t9. 인사파일 저장\t ★");
		System.out.println("★ \t10. 오름차순 정렬\t ★");
		System.out.println("★ \t11. 내림차순 정렬\t ★");
		System.out.println("★ \t12. 종료\t\t ★");
		System.out.println("★★★★★★★★★★★★★★★★★★★★★");
	}
	
}
