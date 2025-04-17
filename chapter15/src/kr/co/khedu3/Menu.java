package kr.co.khedu3;

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
		System.out.print("1. 로드\t\t");
		System.out.print("2. 추가입력\t");
		System.out.print("3. 출력\n");
		System.out.print("4. 최대값\t\t");
		System.out.print("5. 최소값\t");
		System.out.print("6. 검색\n");
		System.out.print("7. 저장\t\t");
		System.out.print("8. 삭제\t");
		System.out.print("9. 수정\n");
		System.out.print("10. 오름차순\t");
		System.out.print("11. 내림차순\t");
		System.out.print("12. 종료\n");
		System.out.println("★★★★★★★★★★★★★★★★★★★★★");
	}
	
	
	// 디폴트 메소드
	
	// private 메소드

}