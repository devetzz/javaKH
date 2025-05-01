package kh.predicate;

import java.util.function.Predicate;

public class PredicateMain {
    public static void main(String[] args) {
        // Predicate<T> => boolean test(T t) : 추상메서드
        Predicate<String> pdc = t -> {
                boolean flag = false;
                try {
                    Integer.parseInt(t);
                    flag = true;
                } catch (NumberFormatException e) {
                    flag = false;
                } catch (Exception e) {
                    flag = false;
                }

                return flag;
        };

        boolean check = pdc.test("23445");
        System.out.println((check == true) ? ("숫자로 변환됩니다.") : ("숫자로 변환되지 않는 문자입니다."));
    }
}
