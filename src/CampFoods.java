
import java.util.ArrayList;

/**
 *
 * @author Zach
 */

public class CampFoods extends Foods {
    ArrayList<String> foods = new ArrayList<String>();

    @Override
    public ArrayList<String> setFoodTypes() {
        foods.clear();
        foods.add("hot dogs");
        foods.add("sandwiches");
        foods.add("marshmallows");
        foods.add("cereal");
        foods.add("chips");
        return foods;
    }

    @Override
    public void setPoisons() {
        poison = foods.get(4);
        poison2 = foods.get(3);
    }

    @Override
    public void setEffects(String selectedFood) {
        if (selectedFood.equalsIgnoreCase(poison)) {
            effects = "You chose to eat the chips.\n" + "However, a raccoon fought you for the food and won. \n"
                    + "You have lost some health.";
        } else if (selectedFood.equalsIgnoreCase(poison2)) {
            effects = "You chose to eat cereal.\n"
                    + "Unfortunately, the Choco-Balls were mixed with mouse droppings. \n"
                    + "You fell ill within minutes and didn't survive.";
        } else {
            effects = "Eating the " + selectedFood + " raised your health.";
        }
    }
}
