package dragonSlayer;

public class Dragon {
	private String name;
	private int health;
	private int clawDamage;
	private int fireDamage;
	private int rank;
	
	public Dragon(String name, int health, int clawDamage, int fireDamage, int rank) {
		this.name = name;
		this.health = health;
		this.clawDamage = clawDamage;
		this.fireDamage = fireDamage;
		this.rank = rank;
	}
	
	public boolean isAlive() {
		if(health > 0)return true;
		else return false;
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
	public int getClawDamage() {
		return clawDamage;
	}
	public void setClawDamage(int clawDamage) {
		this.clawDamage = clawDamage;
	}
	public int getFireDamage() {
		return fireDamage;
	}
	public void setFireDamage(int fireDamage) {
		this.fireDamage = fireDamage;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	
	private int damageValue(String attackType, Knight knight) {
		if(attackType.equals("CLAW") && knight.getEquippedArmor() == null)return clawDamage; 
		if(attackType.equals("FIRE") && knight.getEquippedArmor() == null)return fireDamage;
		if(attackType.equals("CLAW")) return clawDamage - knight.getEquippedArmor().getDefence();
		if(attackType.equals("FIRE") && knight.getEquippedArmor().isHasAntiFire() == true) return (int) ((fireDamage - knight.getEquippedArmor().getDefence()) * 0.8 );
		if(attackType.equals("FIRE") && knight.getEquippedArmor().isHasAntiFire() == false) return (fireDamage - knight.getEquippedArmor().getDefence());
			
		return 0;
	}
	
	private boolean checkDamage(Knight knightName, int damageValue) {
		if(knightName.getEquippedArmor() == null && damageValue != 0){
			return true;
		}else if(knightName.getEquippedArmor().getDefence() >= damageValue) {
			return false;
		}else {
			return true;
		}
	}

	public void attack(Knight knightName, String attackType) {
		int defense = (knightName.getEquippedArmor() != null) ? knightName.getEquippedArmor().getDefence() : 0;
		if(knightName.isAlive() == false) {
			System.out.printf("%s already died!\n", knightName.getName());
		}else if(knightName.getHealth() <= damageValue(attackType, knightName) && checkDamage(knightName, defense + damageValue(attackType, knightName))) {
			System.out.printf("Dealing %d damage to %s! %s has been defeated by %s!\n",  knightName.getHealth(), knightName.getName(), knightName.getName(), this.name);
			knightName.setHealth(0);
		}else if(knightName.getEquippedArmor() == null && knightName.isAlive()) {
			knightName.decreaseHealth(damageValue(attackType, knightName));
			int remainingHealth = knightName.getHealth();
			System.out.printf("Dealing %d damage to %s! %s need %d more damage to defeat the knight!\n", damageValue(attackType, knightName), knightName.getName(), this.name, remainingHealth);
		}else if(checkDamage(knightName, defense + damageValue(attackType, knightName)) == true && knightName.isAlive()) {
			knightName.decreaseHealth(damageValue(attackType, knightName));
			int remainingHealth = knightName.getHealth();
			System.out.printf("Dealing %d damage to %s! %s need %d more damage to defeat the knight!\n", damageValue(attackType, knightName), knightName.getName(), this.name, remainingHealth);
		}else if(checkDamage(knightName, defense + damageValue(attackType, knightName)) == false && knightName.isAlive()){
			System.out.printf("%s has successfully blocked the dragon's attack!\n", knightName.getName());
		}
		
		
		
	}
	
	public void decreaseHealth(int damage) {
		this.health -= damage;
	}
	
	public void buff() {
		this.clawDamage += (this.clawDamage / 10);
		this.fireDamage += (this.fireDamage / 4);
		this.health += (this.health / 10);
		System.out.printf("%s has buffed his abilities!\n", this.name);
	}

	public int reward(String name) {
		int reward = this.rank * 5;
		System.out.printf("%s earned %d gold by killing the dragon!\n", name, reward);
		return reward;
	}
	
	
}
