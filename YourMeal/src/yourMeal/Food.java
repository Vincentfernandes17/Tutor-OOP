package yourMeal;
import java.util.*;

public class Food {
	private String name;
	private String description;
	private int spicyLevel;
	private int calories;
	ArrayList<Ingredient> ingredients = new ArrayList<Ingredient>(); 

	public Food(String name, String description, int spicyLevel, int calories) {
		this.name = name;
		this.description = description;
		this.spicyLevel = spicyLevel;
		this.calories = calories;
	}

	public void addIngredient(Ingredient ingredient) {
		ingredients.add(ingredient);		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getSpicyLevel() {
		return spicyLevel;
	}

	public void setSpicyLevel(int spicyLevel) {
		this.spicyLevel = spicyLevel;
	}

	public int getCalories() {
		return calories;
	}

	public void setCalories(int calories) {
		this.calories = calories;
	}

	public void displayIngredients() {
		for (Ingredient ingredient : ingredients) {
			System.out.printf("%s", ingredient.getName());
			if(!(ingredients.getLast().equals(ingredient))) {
				System.out.printf(", ");
			}
		}
		System.out.println();
	}
}
