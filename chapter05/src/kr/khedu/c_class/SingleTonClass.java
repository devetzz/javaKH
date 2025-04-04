package kr.khedu.c_class;

public class SingleTonClass {

	public static void main(String[] args) {
		// Single single = new Single();
		Single single1 = Single.getSingle();
		Single single2 = Single.getSingle();
		
		System.out.println(single1);
		System.out.println(single2);
	}

}
