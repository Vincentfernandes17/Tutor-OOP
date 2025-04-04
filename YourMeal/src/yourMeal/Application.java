package yourMeal;
import java.util.*;

public class Application {
	ArrayList<Food> foods = new ArrayList<Food>();
	ArrayList<Order> orders = new ArrayList<Order>();
	
	public void addNewFood(Food newFood) {
		foods.add(newFood);	
		System.out.printf("%s was successfully added to the kitchen!\n", newFood.getName());
	}

	public void displayFoods() {
		System.out.println("Food List:");
		System.out.println("----------------------------------------------------------------------------------------------------");
		for (Food food : foods) {
//			Bento (470 Kcal)
//			Description: Bento atau dalam bahasa jepang disebut o-bento merupakan makanan bekal yang berupa nasi dan lauk pauk yang dikemas secara praktis.
//			Spicy Level: 1
//			Ingredients:
//			Steam Rice, Beef blackpepper, Chicken Teriyaki, Japanesse Chicken sauce, Ekado, Tori no teba, Egg Chicken roll, Coleslaw, Chili Sauce, Tomato Sauce, Mayonese
			System.out.printf("%s (%d Kcal)\n", food.getName(), food.getCalories());
			System.out.printf("Description: %s\n", food.getDescription());
			System.out.printf("Spicy Level: %d\n", food.getSpicyLevel());
			System.out.println("Ingredients:");
			food.displayIngredients();		
			System.out.println("----------------------------------------------------------------------------------------------------");
		}
	}

	public void order(User username, Food food, String date) {
		orders.add(new Order(username, food, date));
		System.out.printf("%s ordered %s on %s\n", username.getUsername(), food.getName(), date);
		
		Order.incrementCount();
	}

	public void displayOrders() {
		System.out.println("Order List:");
		System.out.println("----------------------------------------------------------------------------------------------------");
		for (Order order : orders) {
			System.out.printf("User: %s - %s\n", order.getUser().getUsername(), order.getUser().getId());
			System.out.printf("Food: %s\n", order.getFood().getName());
			System.out.printf("Date: %s\n", order.getDate());
			System.out.println("----------------------------------------------------------------------------------------------------");
		}
		
	}

}
