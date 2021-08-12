
import java.util.ArrayList;

/**
 *
 * @author Zach
 */

public class TreehouseFoods extends Foods {
    ArrayList<String> foods = new ArrayList<String>();

    @Override
    public ArrayList<String> setFoodTypes() {
        foods.clear();
        foods.add("granola bar");
        foods.add("candy");
        foods.add("chips");
        foods.add("apple");
        return foods;
    }

    @Override
    public void setPoisons() {
        poison = foods.get(3);
    }

    @Override
    public void setEffects(String selectedFood) {
        if (selectedFood.equalsIgnoreCase(poison)) {
            effects = "You chose to eat the apple.\n" + "However, nearby bees wanted the apple more than you did. \n"
                    + "You have lost some health.";
        } else {
            effects = "Eating the " + selectedFood + " raised your health.";
        }
    }
}
