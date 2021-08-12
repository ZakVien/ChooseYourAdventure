
import java.util.ArrayList;

/**
 *
 * @author Zach
 */

public interface Character {
    void setHealth(int hp);

    void checkHealth();

    void displayHealth();

    boolean search();

    String travel();

    String eat(ArrayList<String> foodArray);
}
