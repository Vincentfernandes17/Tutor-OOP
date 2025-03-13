package dragonSlayer;

public class Item {
	private String name;
	private String type;
	private int price;
	private int attackDamage;
	private int defence;
	private boolean hasAntiFire;
	private int effectValue;
	
	public Item(String name, String type, int price, int attackDamage, int defence, boolean hasAntiFire,
			int effectValue) {
		this.name = name;
		this.type = type;
		this.price = price;
		this.attackDamage = attackDamage;
		this.defence = defence;
		this.effectValue = effectValue;
		this.hasAntiFire = hasAntiFire;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getAttackDamage() {
		return attackDamage;
	}

	public void setAttackDamage(int attackDamage) {
		this.attackDamage = attackDamage;
	}

	public int getDefence() {
		return defence;
	}

	public void setDefence(int defence) {
		this.defence = defence;
	}

	public int getEffectValue() {
		return effectValue;
	}

	public void setEffectValue(int effectValue) {
		this.effectValue = effectValue;
	}

	public boolean isHasAntiFire() {
		return hasAntiFire;
	}

	public void setHasAntiFire(boolean hasAntiFire) {
		this.hasAntiFire = hasAntiFire;
	}
	
	
	
}
