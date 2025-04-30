package kh.lambda;

public class LambdaMain {
    public static void main(String[] args) {
        // 임시객체 부 = new 자식()
        // 입력 없다, 리턴 없다 => 람다식을 통한 오버라이딩
        A am = () -> System.out.println("입력 없고, 리턴 없다");
        
        // 부모 추상메서드를 불러주면 -> 자식의 오버라이딩 함수가 작동이된다.
        am.method();
        
        D d = (a, b) -> (double)a+b;

        double doubleD = d.methodD(1, 2.0);
        System.out.println(doubleD);


        B b = () -> {
            int x = 10;
            int y = 20;
            return x+y;
        };

        int x = b.methodB();
        System.out.println(x);

        System.out.println("End");
    }
}
