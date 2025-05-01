package kh.function;

import java.util.function.Function;

public class FunctionMain {
    public static void main(String[] args) {
        // Function<T, R> => R apply(T t) : 추상메서드
        Function<String, Integer> func = t -> t.length();
        
        String name = "홍길동";
        int leng = func.apply(name);
        System.out.println(name + "는(은) " + leng + "글자 입니다.");
    }
}
