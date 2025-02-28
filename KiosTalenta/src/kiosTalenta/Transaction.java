package kiosTalenta;

public class Transaction {
	private Buyer buyer;
	private Item item;
	private int quantity;
	private int cost;
	
	public Transaction(Buyer buyer, Item item, int quantity, int cost) {
		this.setBuyer(buyer);
		this.setItem(item);
		this.setQuantity(quantity);
		this.setCost(cost);
	}

	public Buyer getBuyer() {
		return buyer;
	}

	public void setBuyer(Buyer buyer) {
		this.buyer = buyer;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}
	
	
}
