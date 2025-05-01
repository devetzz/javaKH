package kh.supplier;

import java.util.Scanner;
import java.util.function.Supplier;

public class SupplierMain {
    public static void main(String[] args) {
        // 함수형 인터페이스(추상메서드 1개) -> 구현클래스(오버라이딩) -> 부모 = 자식 구현객체 -> 부모.추상메서드
        // Supplier<T>(T get() : 추상메서드) -> 구현클래스(X) -> 부모 = 자식 구현객체 -> 부모.추상메서드(람다식)
        Supplier<String> sup = () -> {
                System.out.print("이름 입력: ");
                Scanner s = new Scanner(System.in);
                String name = s.nextLine();
                return String.format("%s님 질문을 하신 당신은 멋쟁이", name);
        };
    
        String value = sup.get();

        System.out.println(value);
    }

}
