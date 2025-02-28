package kiosTalenta;
import java.util.*;

public class Kios {
	private ArrayList<Item> items = new ArrayList<Item>();
	private HashSet<Admin> admins = new HashSet<Admin>();
	private ArrayList<Transaction> transactionHistory = new ArrayList<Transaction>();
	
	
	public void registerAdmin(String id, String username, String password) {
		if(username.length() < 5) {
			System.out.println("Error: Username is to short! Username must be at least 5 characters");
			return;
		}
		if(password.length() < 7) {
			System.out.println("Error: Password is not safe! Password must be at least 8 characters");
			return;
		}
		for (Admin admin : admins) {
			if(admin.getUsername().equals(username)) {
				System.out.println("Error: Username already exists!");
				return;
			}
		}
		//successfull checks
		System.out.printf("Admin %s registered!\n", username);
		admins.add(new Admin(id, username,password));
	}

	public Admin login(String username, String password) {
		for (Admin admin : admins) {
			if(admin.getUsername().equals(username) && admin.getPassword().equals(password)) {
				return admin;
			}
		}
		return null;
	}

	public void displayItems() {
		System.out.println("Items in the store:");
		System.out.println("------------------------------");
		if(items.size() == 0) {
			System.out.println("No items in the store!");
		}else {
			for (Item item : items) {
				System.out.printf("Item name : %s\n", item.getName());
				System.out.printf("Item quantity : %d\n", item.getQuantity());
				System.out.printf("Item price : %d\n", item.getPrice());
				System.out.println("------------------------------");
			}
		}

		
	}

	public void addItem(Item item, Admin admin) {
		for (Admin adminList : admins) {
			if(adminList.getUsername().equals(admin.getUsername()) && adminList.getPassword().equals(admin.getPassword())) {
				if(items.contains(item)) {
					System.out.printf("%s already in the store!\n", item.getName());
					return;
				}else {
					items.add(item);
					System.out.printf("%s successfully added to store by %s\n",item.getName(), admin.getUsername());
					return;
				}
			}else {
				System.out.println("Unauthorized to add item!");
				return;
			}
		}
		
	}

	public void purchase(Item item, Buyer buyer, int quantity) {
		if(items.contains(item)) {
			if(item.getQuantity() < quantity) {
				System.out.printf("%s input invalid quantity!\n", buyer.getName());
				return;
			}else {
				int totalCost = quantity * item.getPrice();
				if(buyer.getCash() < totalCost) {
					System.out.printf("%s has no enough cash!\n", buyer.getName());
					return;
				}else {
					int totalQuantity = item.getQuantity() - quantity;
					item.setQuantity(totalQuantity);
					System.out.printf("Successfully purchased %d %s for %d by %s from %s\n",quantity, item.getName(), totalCost, buyer.getName(), buyer.getClassroom());
					transactionHistory.add(new Transaction(buyer, item, totalQuantity, totalCost));
					if(item.getQuantity() == 0) {
						System.out.printf("%s is out of stock! Removing from store!\n", item.getName());
						items.remove(item);
						return;
					}
				}
			}
		}else {
			System.out.printf("%s is not in the store or out of stock!", item.getName());
			return;
		}
	}

	public void displayTransactionHistory() {
		System.out.println("Tranasction History:");
		System.out.println("------------------------------");
		if(transactionHistory.isEmpty()) {
			System.err.println("No transaction history to show!");
		}else {
			for (Transaction transaction : transactionHistory) {
				System.out.printf("Item name : %s\n", transaction.getItem().getName());
				System.out.printf("Item price : %d\n", transaction.getItem().getPrice());
				System.out.printf("Quantity : %d\n", transaction.getQuantity());
				System.out.printf("Total cost : %d\n", transaction.getCost());
				System.out.printf("Buyer : %s (%s)\n", transaction.getBuyer().getName(), transaction.getBuyer().getClassroom());
				System.out.println("------------------------------");
				
			}
		}
	}

}
