package kiosTalenta;

public class Item {
	private String name;
	private int quantity;
	private int price;
	
	public Item(String name, int quantity, int price) {
		this.setName(name);
		this.setQuantity(quantity);
		this.setPrice(price);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

}
