package kh.generic;

public class BoxMain {

	public static void main(String[] args) {
		// BoxString
		BoxString bs = new BoxString("김동진");
		System.out.println(bs.toString());
		
		// BoxInteger
		BoxInteger bi = new BoxInteger(10);
		System.out.println(bi.toString());
		
		// BoxObject(BoxString, BoxInteger)
		BoxObject bo = new BoxObject("김동진");
		Object objName = bo.getObject();
		if(objName instanceof String) {
			String name = (String)objName;
			System.out.printf("name = %s\n", name);
		}else {
			System.out.println("objName 속에서 자식 영역인 String이 없어요");
		}
		
		// 제네릭을 이용하여 여러 클래스를 활용 (강제 형변환을 할 필요가 없다)
		Box<String> boxString = new Box<String>("김동진");
		String name = boxString.getObject();
		System.out.printf("name = %s\n", name);
		
		Box<Integer> boxInteger = new Box<>();
		boxInteger.setObject(30);
		int num = boxInteger.getObject();
		System.out.printf("num = %d", num);
	}
}
