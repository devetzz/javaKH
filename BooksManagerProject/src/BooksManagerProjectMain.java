import controller.BooksManager;
import view.BookChoice;
import view.Menu;
import view.MenuChoice;

public class BooksManagerProjectMain {
    public static void main(String[] args) {
        int choice = 0;
        boolean exitFlag = false;
        while(!exitFlag){
            Menu.mainMenu();
            choice = Integer.parseInt(Menu.scan.nextLine());
            switch(choice){
            case MenuChoice.BOOK_INFO: 
                booksMenu();
                System.out.println("Menu1");
                break;
            case MenuChoice.MEMBER_MANAGE: 
                // memberMenu();
                System.out.println("Menu2");
                break;
            case MenuChoice.RENTAL_MANAGE:
                System.out.println("Menu3"); 
                break;
            case MenuChoice.EXIT: 
                System.out.println("Menu4");
                exitFlag = true;
                break;
            }


        }
        System.out.println("도서 관리 프로그램 종료");
    }




    public static void booksMenu() {
        int choice = 0;
        boolean exitFlag = false;
        while(!exitFlag){
            Menu.booksMenu();
            choice = Integer.parseInt(Menu.scan.nextLine());
            switch(choice){
            case BookChoice.도서목록:
                BooksManager.booksList();
                break;
            case BookChoice.도서입력: 
                BooksManager.booksInsert();
                break;
            case BookChoice.도서수정:
                BooksManager.booksUpdate();
                break;
            case BookChoice.도서삭제:
                BooksManager.booksDelete();
                break;
            case BookChoice.도서검색:
                BooksManager.booksSearch();
                break;
            case BookChoice.메인메뉴: 
                System.out.println("Menu6");
                exitFlag = true;
                break;
            }

        }
    }
}
