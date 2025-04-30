package kh.lambda;

public class InstanceLambdaMain {
    public static void main(String[] args) {
        // 람다식(인스턴스 메서드 System.out.println() 사용)

        Mystery mystery = a -> System.out.println(a);
        Mystery mystery2 = System.out::println;
        mystery.methodMystery(10);
        mystery2.methodMystery(100);

        System.out.println("====================");
        
        A a = () -> Bobject.bcd();
        A a2 = Bobject::bcd;
        // 클래스이름::인스턴스메소드 이름
        a.method();
        a2.method();
        
        System.out.println("====================");

        Atest atest = (b, k) -> b.bcd(k);
        Atest atest2 = BObject2::bcd;

        atest.abc(new BObject2(), 20);
        atest2.abc(new BObject2(), 300);
            
        

    }
}
