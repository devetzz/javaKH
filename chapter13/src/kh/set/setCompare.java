package kh.set;

import java.util.HashSet;
import java.util.Set;

public class setCompare {

	public static void main(String[] args) {
		// Data객체를 2개 만든다. hashcode 값을 비교한다.
		Data data1 = new Data("010-1234-5671");
		Data data2 = new Data("010-1234-5672");
		Data data3 = new Data("010-1234-5673");
		Data data4 = new Data("010-1234-5674");
		Data data5 = new Data("010-1234-5675");
		Data data6 = new Data("010-1234-5676");
		
		Set<Data> set = new HashSet<Data>();
		set.add(data1);
		set.add(data2);
		set.add(data3);
		set.add(data4);
		set.add(data5);
		set.add(data6);
		
		Data searchData = null;
		for(Data d : set) {
			if(d.getPhone().equals(data4.getPhone())) {
				searchData = d;
				searchData.setPhone("010-1111-2222");
				break;
			}
		}

		if(searchData == null) {
			System.out.printf("%s 번호는 없습니다.\n",data4.getPhone());
		}else {
			System.out.println(searchData);
		}
		System.out.println("End");
	}

}
