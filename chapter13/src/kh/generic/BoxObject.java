package kh.generic;

public class BoxObject {
	// 변수
	private Object object;
	
	// 생성자
	public BoxObject() {
		this(null);
	}
	public BoxObject(Object object) {
		super();
		this.object = object;
	}
	
	// 함수
	public Object getObject() {
		return object;
	}
	public void setObject(Object object) {
		this.object = object;
	}
	
	@Override
	public String toString() {
		return "BoxObject [object=" + object + "]";
	}
	
	
	
}
