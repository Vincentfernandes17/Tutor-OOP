package dragonSlayer;

import java.util.HashMap;

public class Inventory {
	private int size;
	private HashMap<String, Item> items = new HashMap<String, Item>();
	
	public Inventory(int size) {
		this.size = size;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public Item getItems(String itemName) {
		return items.get(itemName);
	}
	public void setItems(String itemName, Item item) {
		this.items.put(itemName, item);
	}
	public void removeItem(String itemName) {
		items.remove(itemName);
	}

}
