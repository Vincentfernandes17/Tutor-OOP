package dragonSlayer;

public class Knight {
	private String name;
	private int health = 1000;
	private Gold gold;
	private Item equippedSword = null;
	private Item equippedArmor = null;
	private int maxInventory = 3;
	private Inventory inventory = new Inventory(maxInventory);
	private int itemCount = 0;
	
	public void setMaxInventory(int size) {
		this.maxInventory = size;
	}
	
	public int getMaxInventory() {
		return this.maxInventory;
	}
	
	public boolean checkInventorySpace() {
		if(itemCount < maxInventory)return true;
		return false;
	}
	
	public void addInventory(String itemName, Item item) {
		if(checkInventorySpace()) {
			inventory.setItems(itemName, item);
			itemCount++;
		}
//		else {
//			System.out.printf("%s's inventory is full! Please upgrade the inventory!\n", name);
//		}
		
	}
	
	public Knight(String name, Gold gold) {
		this.name = name;
		this.gold = gold;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getHealth() {
		return health;
	}
	public void setHealth(int health) {
		this.health = health;
	}
	public Gold getGold() {
		return gold;
	}
	public void setGold(Gold gold) {
		this.gold = gold;
	}
	public Item getEquippedSword() {
		return equippedSword;
	}
	public void setEquippedSword(Item equippedSword) {
		this.equippedSword = equippedSword;
	}
	public Item getEquippedArmor() {
		return equippedArmor;
	}
	public void setEquippedArmor(Item equippedArmor) {
		this.equippedArmor = equippedArmor;
	}
	
	private int damageValue() {
		return equippedSword.getAttackDamage();
	}
	
	private boolean checkSwordEquipped() {
		if(equippedSword == null) {
			return false;
		}
		return true;
	}
	
	public void attack(Dragon dragon) {
		if(checkSwordEquipped() == true && dragon.isAlive()) {
			if(damageValue() >= dragon.getHealth()) {
				System.out.printf("Dealing %d damage to %s! %s has been defeated by %s!\n", dragon.getHealth(), dragon.getName(), dragon.getName(), this.name );
				dragon.setHealth(0);
				this.gold.setAmount(dragon.reward(this.name));
			}else {
				dragon.decreaseHealth(damageValue());
				int remainingHealth = dragon.getHealth();
				System.out.printf("Dealing %d damage to %s! You need %d more damage to defeat the dragon!\n", damageValue(), dragon.getName(), remainingHealth );
			}
		}else if(checkSwordEquipped() == false) {
			System.out.printf("%s is not using any kind of sword!\n", name);
		}else if(checkSwordEquipped() == true && dragon.isAlive() == false) {
			System.out.printf("%s already died!\n", dragon.getName());
		}
	}
	
	public boolean checkItemAvailability(String item) {
		if(inventory.getItems(item) != null) {
			return true;
		}
		return false;
	}
	
	public void equipSword(String sword) {
		if(checkItemAvailability(sword)) {
			System.out.printf("%s is equipping %s!\n", name, sword);
			equippedSword = inventory.getItems(sword);
		}else {
			System.out.printf("%s does not have %s in the inventory!\n", name, sword);
		}
		
	}
	
	public void equipArmor(String armor) {
		if(checkItemAvailability(armor)) {
			
			System.out.printf("%s is equipping %s!\n", name, armor);
			equippedArmor = inventory.getItems(armor);
		}else {
			System.out.printf("%s does not have %s in the inventory!\n", name, armor);
		}
	}
	
	public void decreaseHealth(int damage) {
		this.health -= damage;
	}
	
	public void decreaseCoin(int amount) {
		int remaining = this.getGold().getAmount() - amount;
		this.getGold().setAmount(remaining);
	}
	
	private void increaseCoin(int amount) {
		int total = this.getGold().getAmount() + amount;
		this.getGold().setAmount(total);
	}
	
	public void enhanceWeapon() {
		if(getGold().getAmount() >= 500) {
			decreaseCoin(500);
			this.equippedSword.setAttackDamage(this.equippedSword.getAttackDamage() + (this.equippedSword.getAttackDamage() / 10));
			System.out.printf("%s has enhanced %s!\n", this.name, this.equippedSword.getName());
		}else {
			System.out.printf("%s does not have enough gold to enhance the weapon!\n", this.name);
		}
		
	}
	
	private boolean checkIfConsumableUsable(Item consumable) {
		if(this.health + consumable.getEffectValue() > 1000) {
			return false;
		}
		return true;
	}
	
	private void removeItem(String name) {
		inventory.removeItem(name);
		itemCount--;
	}
	
	public void useConsumable(String itemName) {
		Item consumable = inventory.getItems(itemName);
		if(checkIfConsumableUsable(consumable)) {
			this.setHealth(this.health + consumable.getEffectValue());
			System.out.printf("%s use %s! (Health: %d)\n", this.name, itemName, this.health);
			removeItem(itemName);
		}else {
			System.out.printf("%s isn't able to use %s!\n", this.name, itemName);
		}
	}
	public void earnGold(int amount) {
		increaseCoin(amount);
		System.out.printf("%s earned %d gold!\n", this.name, amount);
	}
	public void unequipArmor() {
		this.equippedArmor = null;
	}
	public void unequipSword() {
		this.equippedSword = null;
	}
	
	public boolean isAlive() {
		if(this.health > 0)return true;
		else return false;
	}
}
