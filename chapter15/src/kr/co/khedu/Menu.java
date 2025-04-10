package kr.co.khedu;

public interface Menu {
	// {"", "로드", "추가입력", "출력", "최대값", "최소값", "검색", "저장", "삭제", "수정", "종료"};
	
	// 상수
	public static final int LOAD = 1;
	public static final int INPUT = 2;
	public static final int OUTPUT = 3;
	public static final int MAX = 4;
	public static final int MIN = 5;
	public static final int SEARCH = 6;
	public static final int SAVE = 7;
	public static final int REMOVE = 8;
	public static final int UPDATE = 9;
	public static final int ASC = 10;
	public static final int DESC = 11;
	public static final int EXIT = 12;

	// 추상 메소드
	
	// 정적 메소드
	public static void menuDisplay() {
		System.out.println("★★★★★★★★ MENU ★★★★★★★★");
		System.out.println("★ \t1. 로드\t\t ★");
		System.out.println("★ \t2. 추가입력\t ★");
		System.out.println("★ \t3. 출력\t\t ★");
		System.out.println("★ \t4. 최대값\t\t ★");
		System.out.println("★ \t5. 최소값\t\t ★");
		System.out.println("★ \t6. 검색\t\t ★");
		System.out.println("★ \t7. 저장\t\t ★");
		System.out.println("★ \t8. 삭제\t\t ★");
		System.out.println("★ \t9. 수정\t\t ★");
		System.out.println("★ \t10. 오름차순\t ★");
		System.out.println("★ \t11. 내림차순\t ★");
		System.out.println("★ \t12. 종료\t\t ★");
		System.out.println("★★★★★★★★★★★★★★★★★★★★★");
	}
	
	
	// 디폴트 메소드
	
	// private 메소드

}