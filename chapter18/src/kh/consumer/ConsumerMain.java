package kh.consumer;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class ConsumerMain {
    public static void main(String[] args) {
        // 인터페이스 -> 구현클래스 -> 구현객체 -> 부 자 관계 -> 부.추상메서드
        // Consumer X -> x -> 구현 객체(부자관계) -> 부.추상메서드
        Consumer<String> con = t -> System.out.printf("%s님 환영합니다.\n", t);
        con.accept("홍길동");
        con.accept("고길동");
        con.accept("저길동");

        Consumer<Integer> conInt = t -> {
            for(int i= 1; i <= 9; i ++){
                System.out.printf("%d X %d = %d\n", t, i, t*i);
            }
        };

        conInt.accept(9);
        System.out.println("===================================");
        BiConsumer<String, Integer> bicon = (name, age) -> {
            System.out.printf("%s의 나이는 %d 입니다.\n", name, age);
        };

        bicon.accept("홍길동", 20);

    }
}
