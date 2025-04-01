package chapter04;

public class Store {
	// 멤버 변수
	// 물품명, 재고, 물품 원가, 부가세, 부가세 포함 가격
	private final int TAX = 10;
	private String name;
	private int stock;
	private int price;
	private int vat;
	private double total;
	
	// 멤버 함수
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getVat() {
		return vat;
	}

	public void calculateVat() {
		this.vat = price / TAX;
	}

	public double getTotal() {
		return total;
	}

	public void calculateTotal() {
		this.total = price + vat;
	}
	
	@Override
	public String toString() {
		return "상품 이름 : " + name + "\t| 재고 : " + stock + "\t| 상품 가격 : " + price + "\t| 부가세 : " + vat + "\t| 부가세 포함 가격 : " + total + "\n";
	}
	
}
