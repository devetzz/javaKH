package incomplete;

import java.util.ArrayList;

public class Store {
	// 멤버 변수
	// 물품명, 재고, 물품 원가, 부가세, 부가세 포함 가격
	private final int TAX = 10;
	private ArrayList<String> nameArr = new ArrayList<String>();
	private ArrayList<Integer> stockArr = new ArrayList<Integer>();
	private ArrayList<Integer> priceArr = new ArrayList<Integer>();
	private ArrayList<Integer> vatArr = new ArrayList<Integer>();
	private ArrayList<Double> totalArr = new ArrayList<Double>();
	
	// 멤버 함수
	public ArrayList<String> getNameArr() {
		return nameArr;
	}

	public void setNameArr(String nameArr) {
		this.nameArr.add(nameArr);
	}

	public ArrayList<Integer> getStockArr() {
		return stockArr;
	}

	public void setStockArr(int stockArr) {
		this.stockArr.add(stockArr);
	}

	public ArrayList<Integer> getPriceArr() {
		return priceArr;
	}

	public void setPriceArr(int priceArr) {
		this.priceArr.add(priceArr);
	}
	
	public ArrayList<Integer> getVatArr() {
		return vatArr;
	}
	
	public void setVatArr(int vatArr) {
		this.vatArr.add(vatArr);
	}

	public ArrayList<Double> getTotalArr() {
		return totalArr;
	}

	public void setTotalArr(double totalArr) {
		this.totalArr.add(totalArr);
	}

	

	@Override
	public String toString() {
		return "상품명 : " + nameArr + "재고 : " + stockArr + "\t| 상품 가격 : " + priceArr + "\t| 부가세 포함 가격 : " + totalArr;
	}
	
}
