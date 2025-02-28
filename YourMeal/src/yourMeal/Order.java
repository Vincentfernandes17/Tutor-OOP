package yourMeal;

public class Order {
	private static int count;
	private User user;
	private Food food;
	private String date;
	
	public Order(User username, Food food, String date) {
		this.user = username;
		this.food = food;
		this.date = date;
	}
	
	public static int getCount() {
		return count;
	}
	
	public static void incrementCount() {
		count++;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Food getFood() {
		return food;
	}

	public void setFood(Food food) {
		this.food = food;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}


	

}
