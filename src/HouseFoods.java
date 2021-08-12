
import java.util.ArrayList;

/**
 *
 * @author Zach
 */

public class HouseFoods extends Foods {
    ArrayList<String> foods = new ArrayList<String>();

    @Override
    public ArrayList<String> setFoodTypes() {
        foods.clear();
        foods.add("fish");
        foods.add("berries");
        foods.add("raw meat");
        foods.add("eggs");
        foods.add("bread");
        return foods;
    }

    @Override
    public void setPoisons() {
        poison = foods.get(2);
        poison2 = foods.get(4);
    }

    @Override
    public void setEffects(String selectedFood) {
        if (selectedFood.equalsIgnoreCase(poison)) {
            effects = "You chose to eat " + poison + ".\n"
                    + "Unfortunately, the food was contaminated and you lost some health...";
        } else if (selectedFood.equalsIgnoreCase(poison2)) {
            effects = "You chose to eat " + poison2 + ". " + "Unfortunately, the " + poison2 + " was moldy. \n\n"
                    + "You got sick from the tainted " + poison2 + " and didn't survive.";
        } else {
            effects = "Eating the " + selectedFood + " raised your health.";
        }
    }
}
