
import java.util.ArrayList;

/**
 *
 * @author Zach
 */

public abstract class Foods {
    String poison;
    String poison2;
    String effects;

    abstract ArrayList<String> setFoodTypes();

    abstract void setPoisons();

    abstract void setEffects(String selectedFood);

    String getPoison() {
        return poison;
    }

    String getPoison2() {
        return poison2;
    }

    String getEffects() {
        return effects;
    }
}
