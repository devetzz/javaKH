package kr.co.khedu;

import java.io.Serializable;

public class StudentData implements Serializable, Comparable{
	// 멤버 변수
		private String name;
		private int kor;
		private int eng;
		private int math;
		private int total;
		private double avg;
		
		// 생성자(오버로딩)
		public StudentData() {
			this(null, 0, 0, 0);
		}
		
		public StudentData(String name, int kor, int eng, int math) {
			super();
			this.name = name;
			this.kor = kor;
			this.eng = eng;
			this.math = math;
		}

		
		// 멤버 함수
		public String getName() {
			return name;
		}
		
		public void setName(String name) {
			this.name = name;
		}
		
		public int getKor() {
			return kor;
		}
		
		public void setKor(int kor) {
			this.kor = kor;
		}
		
		public int getEng() {
			return eng;
		}
		
		public void setEng(int eng) {
			this.eng = eng;
		}
		
		public int getMath() {
			return math;
		}
		
		public void setMath(int math) {
			this.math = math;
		}
		
		public int getTotal() {
			return total;
		}
		
		public void setTotal(int total) {
			this.total = total;
		}
		
		public double getAvg() {
			return avg;
		}
		
		public void setAvg(double avg) {
			this.avg = avg;
		}

		
		// 멤버 출력
		@Override
		public String toString() {
			String avgFormat = String.format("%.2f", this.avg);
			return "Student [" + name + " " + kor + " " + eng + " " + math + " " + total
					+ " " + avgFormat + "]";
		}

		@Override
		public int compareTo(Object object) {
			// Object(부모 영역)에 StudentData(자식)가 있는지 점검한다.
			StudentData stu = null;
			if(object instanceof StudentData) {
				stu = (StudentData)object;
			}
			// 비교
			if(this.getTotal() > stu.getTotal()) {
				return 1;
			}else if(this.getTotal() < stu.getTotal()) {
				return -1;
			}else {
				return 0;
			}
			
		}

		@Override
		public boolean equals(Object obj) {
			if(!(obj instanceof StudentData)) {
				return false;
			}
			StudentData stu = (StudentData)obj;
			return this.name.equals(stu.name);
		}
		
		
		
}
