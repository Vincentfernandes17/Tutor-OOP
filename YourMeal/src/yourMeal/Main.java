package yourMeal;

public class Main {
    public static void main(String[] args) {
        Application yourMeal = new Application();

        User firstUser = new User("0789", "Josh Ronaldo");
        User secondUser = new User("9083", "Kukilo Seto");

        Food food1 = new Food("Bento", "Bento atau dalam bahasa jepang disebut o-bento merupakan makanan bekal yang berupa nasi dan lauk pauk yang dikemas secara praktis.", 1, 470);

        food1.addIngredient(new Ingredient("Steam Rice"));
        food1.addIngredient(new Ingredient("Beef blackpepper"));
        food1.addIngredient(new Ingredient("Chicken Teriyaki"));
        food1.addIngredient(new Ingredient("Japanesse Chicken sauce"));
        food1.addIngredient(new Ingredient("Ekado"));
        food1.addIngredient(new Ingredient("Tori no teba"));
        food1.addIngredient(new Ingredient("Egg Chicken roll"));
        food1.addIngredient(new Ingredient("Coleslaw"));
        food1.addIngredient(new Ingredient("Chili Sauce"));
        food1.addIngredient(new Ingredient("Tomato Sauce"));
        food1.addIngredient(new Ingredient("Mayonese"));

        Food food2 = new Food("Tokyo Beef Humberg", "Tokyo Beef Hamburg merupakan makanan barat bergaya jepang", 1, 683);

        food2.addIngredient(new Ingredient("Beef Patty"));
        food2.addIngredient(new Ingredient("Potato Wedges"));
        food2.addIngredient(new Ingredient("Carrot"));
        food2.addIngredient(new Ingredient("Corn Kernel"));
        food2.addIngredient(new Ingredient("Brocoli"));
        food2.addIngredient(new Ingredient("Fried Egg"));
        food2.addIngredient(new Ingredient("Tonkatsu Sauce"));
        food2.addIngredient(new Ingredient("Blackpepper Sauce"));

        yourMeal.addNewFood(food1);
        yourMeal.addNewFood(food2);

        yourMeal.displayFoods();

        yourMeal.order(firstUser, food1, "10 February 2025");
        yourMeal.order(firstUser, food1, "15 February 2025");
        yourMeal.order(secondUser, food2, "20 February 2025");
        yourMeal.order(firstUser, food2, "26 February 2025");

        System.out.printf("Order count: %d\n", Order.getCount());

        yourMeal.displayOrders();
    }
}