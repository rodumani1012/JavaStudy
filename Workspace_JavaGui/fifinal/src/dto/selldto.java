package dto;

public class selldto {
	
	private String kinds;
	private String name;
	private int price;
	private int amount;
	private int total;
	
	public selldto() {

	}
	
	public String getKind() {
		return kinds;
	}
	public void setKind(String kinds) {
		this.kinds = kinds;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	

}