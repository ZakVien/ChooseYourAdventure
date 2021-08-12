
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Zach
 */

public abstract class Human implements Character {
    String name;
    String chosenFood;
    String response;
    int health = 50;

    @Override
    public String travel() {
        response = "";
        while (!response.equalsIgnoreCase("bike") && !response.equalsIgnoreCase("run")
                && !response.equalsIgnoreCase("walk")) {
            response = JOptionPane.showInputDialog(null,
                    "How are you going to try to get back to your family?\n" + "-Bike\n" + "-Run\n" + "-Walk");
            if (!response.equalsIgnoreCase("bike") && !response.equalsIgnoreCase("run")
                    && !response.equalsIgnoreCase("walk")) {
                JOptionPane.showMessageDialog(null, "Please enter 'bike', 'run', or 'walk'");
            }
        }
        if (response.equals("bike")) {
            setHealth(-5);
        } else if (response.equals("run")) {
            setHealth(-15);
        } else {
            setHealth(-10);
        }
        checkHealth();
        return response;
    }

    @Override
    public void displayHealth() {
        checkHealth();
        JOptionPane.showMessageDialog(null, "Your health is at " + health + "HP.");
    }

    @Override
    public void setHealth(int hp) {
        health = health + hp;
        if (health > 100) {
            health = 100;
        }
    }

    @Override
    public boolean search() {
        String response = "";
        while (!response.equalsIgnoreCase("y") && !response.equalsIgnoreCase("n")) {
            response = JOptionPane.showInputDialog(null, "Do you search the area for food? Y/N");
            if (!response.equalsIgnoreCase("y") && !response.equalsIgnoreCase("n")) {
                JOptionPane.showMessageDialog(null, "Please answer Y/N");
            }
        }
        if (response.toLowerCase().startsWith("y")) {
            return true;
        }
        setHealth(-12);
        JOptionPane.showMessageDialog(null, "This area was nothing but a waste of time....and health.");
        displayHealth();
        return false;
    }

    @Override
    public String eat(ArrayList<String> foodArray) {
        String response = "";
        boolean validChoice = false;

        while (!validChoice) {
            String availFoods = "";
            for (int i = 0; i < foodArray.size(); i++) {
                availFoods = availFoods + "-" + foodArray.get(i) + "\n";
            }
            response = JOptionPane.showInputDialog(null,
                    "After searching the area, "
                            + "you find a variety of food,\nbut some of the food doesn't look so healthy.\n\n"
                            + "Enter the food item that you are going to eat: \n" + availFoods);

            response = response.toLowerCase();

            for (int i = 0; i < foodArray.size(); i++) {
                if (response.equals(foodArray.get(i))) {
                    validChoice = true;
                    break;
                }
            }
            if (!validChoice) {
                JOptionPane.showMessageDialog(null, "Please choose a valid option.");
            }
        }
        return response;
    }
}
