package dragonSlayer;

import java.util.*;

public class Shop {
	private HashMap<String, Item> items = new HashMap<String, Item>();
	
	public void addItem(Item item) {
		items.put(item.getName(), item);
	}
	
	private boolean checkGold(int price, Knight knightName) {
		if(price > knightName.getGold().getAmount()) {
			return false;
		}
		return true;
	}
	
	private boolean checkAvailability(String itemName) {
		if(items.containsKey(itemName)) {
			return true;
		}
		return false;
	}


	public void buyItem(String itemName, Knight knightName) {
		Item item = items.get(itemName);
		if(knightName.checkInventorySpace() == false) {
			System.out.printf("%s's inventory is full! Please upgrade the inventory!\n", knightName.getName());
		}else if(checkAvailability(itemName) == true && checkGold(item.getPrice(), knightName) == true && knightName.checkInventorySpace() == true) {
			// ----------????----------------
			int remainingGold = knightName.getGold().getAmount() - item.getPrice();
			Gold newGold = new Gold(remainingGold);
			knightName.setGold(newGold);
//			items.remove(itemName);
			//-------------------------------
			knightName.addInventory(itemName, items.get(itemName));
			System.out.printf("%s has purchased %s!\n", knightName.getName(), itemName);
		}else if(checkAvailability(itemName) == false) {
			System.out.printf("%s does not exist in the shop!\n", itemName);
		}else if(checkAvailability(itemName) == true && checkGold(item.getPrice(), knightName) == false) {
			System.out.printf("%s does not have enough gold to buy %s!\n", knightName.getName(), itemName);
		}
		
	}

	public void upgradeInventory(Knight knightName, int amount) {
		int inventoryPrice = 100;
		int totalPrice = amount * inventoryPrice;
		if(checkGold(totalPrice, knightName)) {
			knightName.setMaxInventory(knightName.getMaxInventory() + amount);
			knightName.decreaseCoin(totalPrice);
			System.out.printf("%s has successfully upgraded %d more inventory!\n", knightName.getName(), amount);
		}else {
			System.out.printf("%s does not have enough gold to upgrade %d more inventory!\n", knightName.getName(), amount);
		}
		
	}

	public void sellItem(String itemName, Knight knigtName) {
		if(knigtName.checkItemAvailability(itemName)) {
			Item item = items.get(itemName);
			int price = item.getPrice();
			int newPrice = price * 80 / 100;
			System.out.printf("%s has sold %s for %d gold!\n", knigtName.getName(), itemName, newPrice);
			knigtName.earnGold(newPrice);
		}else {
			System.out.printf("%s does not have %s in his inventory!\n", knigtName.getName(), itemName);
		}
		
	}

	public HashMap<String, Item> getItems() {
		return items;
	}

	public void setItems(HashMap<String, Item> items) {
		this.items = items;
	}

}
