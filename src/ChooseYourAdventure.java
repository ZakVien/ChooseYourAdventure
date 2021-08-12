
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Zach
 */

public class ChooseYourAdventure {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String response = "";
        int searchCount = 0;
        Human person = new Adult();

        while (!response.equalsIgnoreCase("adult") && !response.equalsIgnoreCase("child")) {
            response = JOptionPane.showInputDialog(null,
                    "Select the type of person you'd like to be.\n" + "-Adult\n" + "-Child");
            if (response.equalsIgnoreCase("adult")) {
                person = new Adult();
            } else if (response.equalsIgnoreCase("child")) {
                person = new Child();
            } else {
                JOptionPane.showMessageDialog(null, "Please enter 'adult' or 'child'");
            }
        }

        JOptionPane.showMessageDialog(null,
                "You wake up with in the middle of an empty field.\n" + "There's no signs of life around...\n"
                        + "All you have are the clothes on your back and a nearby bicycle.");
        JOptionPane.showMessageDialog(null, "You can see the sun is setting.\n" + "It's starting to get cold.\n"
                + "You need to get back to your family.");

        String travelMethod = person.travel();

        while (!response.equalsIgnoreCase("y") && !response.equalsIgnoreCase("n")) {
            response = JOptionPane.showInputDialog(null,
                    "You lost some health during your search. Your health is at " + person.health + "HP.\n"
                            + "You've been traveling for a while and you're starting to get hungry. \n"
                            + "You arrive at a deserted house. Do you enter the house? Y/N");
            if (!response.equalsIgnoreCase("y") && !response.equalsIgnoreCase("n")) {
                JOptionPane.showMessageDialog(null, "Please enter Y or N");
            }
        }

        // enter the house
        if (response.equalsIgnoreCase("y")) {
            searchCount++;
            // search the house
            if (person.search()) {
                Foods location = new HouseFoods();
                ArrayList<String> foodArray = location.setFoodTypes();
                location.setPoisons();

                String selectedFood = person.eat(foodArray);

                if (selectedFood.equals(location.getPoison())) {
                    person.setHealth(-30);
                } else if (selectedFood.equals(location.getPoison2())) {
                    person.setHealth(-100);
                } else {
                    person.setHealth(30);
                }
                location.setEffects(selectedFood);
                JOptionPane.showMessageDialog(null, location.getEffects());
                person.displayHealth();
            }
        }

        person.checkHealth();
        JOptionPane.showMessageDialog(null, "You continue searching for your family, costing you some health.");
        if (travelMethod.equals("bike")) {
            person.setHealth(-5);
        } else if (travelMethod.equals("run")) {
            person.setHealth(-15);
        } else {
            person.setHealth(-10);
        }
        person.checkHealth();

        response = "";
        while (!response.equalsIgnoreCase("y") && !response.equalsIgnoreCase("n")) {
            response = JOptionPane.showInputDialog(null, "Your health is at " + person.health + "HP.\n\n"
                    + "You see a campsite nearby. Do you travel towards it? Y/N");
            if (!response.equalsIgnoreCase("y") && !response.equalsIgnoreCase("n")) {
                JOptionPane.showMessageDialog(null, "Please enter Y or N");
            }
        }
        // check out the campsite
        if (response.equalsIgnoreCase("y")) {
            searchCount++;
            // search the campsite
            if (person.search()) {
                Foods location = new CampFoods();
                ArrayList<String> foodArray = location.setFoodTypes();
                location.setPoisons();

                String selectedFood = person.eat(foodArray);

                if (selectedFood.equals(location.getPoison())) {
                    person.setHealth(-30);
                } else if (selectedFood.equals(location.getPoison2())) {
                    person.setHealth(-100);
                } else {
                    person.setHealth(30);
                }
                location.setEffects(selectedFood);
                JOptionPane.showMessageDialog(null, location.getEffects());
                person.displayHealth();
            }
        }
        person.checkHealth();
        JOptionPane.showMessageDialog(null, "You continue searching for your family, costing you some health.");
        if (travelMethod.equals("bike")) {
            person.setHealth(-5);
        } else if (travelMethod.equals("run")) {
            person.setHealth(-15);
        } else {
            person.setHealth(-10);
        }
        person.checkHealth();

        response = "";
        while (!response.equalsIgnoreCase("y") && !response.equalsIgnoreCase("n")) {
            response = JOptionPane.showInputDialog(null, "Your health is at " + person.health + "HP.\n\n"
                    + "You see a treehouse nearby. Do you travel towards it? Y/N");
            if (!response.equalsIgnoreCase("y") && !response.equalsIgnoreCase("n")) {
                JOptionPane.showMessageDialog(null, "Please enter Y or N");
            }
        }
        // check out the treehouse
        if (response.equalsIgnoreCase("y")) {
            searchCount++;
            // search the treehouse
            if (person.search()) {
                Foods location = new TreehouseFoods();
                ArrayList<String> foodArray = location.setFoodTypes();
                location.setPoisons();

                String selectedFood = person.eat(foodArray);

                if (selectedFood.equals(location.getPoison())) {
                    person.setHealth(-30);
                } else {
                    person.setHealth(30);
                }
                location.setEffects(selectedFood);
                JOptionPane.showMessageDialog(null, location.getEffects());
                person.displayHealth();
            }
        }
        person.checkHealth();
        JOptionPane.showMessageDialog(null, "You continue searching for your family, costing you some health.");
        if (travelMethod.equals("bike")) {
            person.setHealth(-5);
        } else if (travelMethod.equals("run")) {
            person.setHealth(-15);
        } else {
            person.setHealth(-10);
        }
        person.checkHealth();

        if (searchCount <= 1) {
            person.setHealth(-100);
            JOptionPane.showMessageDialog(null, "You begin to feel drowsy...");
            JOptionPane.showMessageDialog(null, "You find a resting place in a tree branch.");
            JOptionPane.showMessageDialog(null,
                    "You wake up to a loud SNAP. The branch broke and you fall to your demise.");
            person.checkHealth();
        } else if (searchCount > 1) {
            JOptionPane.showMessageDialog(null, "You hear shouting in the distance.");
            response = "";
            while (!response.equalsIgnoreCase("shout") && !response.equalsIgnoreCase("hide")) {
                response = JOptionPane.showInputDialog(null, "Do you shout back or hide? \n" + "-shout\n" + "-hide");
                if (!response.equalsIgnoreCase("shout") && !response.equalsIgnoreCase("hide")) {
                    JOptionPane.showMessageDialog(null, "Please enter 'shout' or 'hide'");
                }
            }
            if (response.equalsIgnoreCase("shout")) {
                JOptionPane.showMessageDialog(null, "You shout loudly for until your voice gives out.");
                if (person.health < 50) {
                    JOptionPane.showMessageDialog(null, "Your vision begins to fade and you fall to the ground.");
                    JOptionPane.showMessageDialog(null, "You fall unconcious.");
                    JOptionPane.showMessageDialog(null,
                            "You wake up 45 days later in a hospital bed, surrounded by your family.");
                    System.exit(0);
                } else {
                    JOptionPane.showMessageDialog(null, "The voices are are getting closer.");
                }
                person.setHealth(100);
                person.checkHealth();
            } else {
                JOptionPane.showMessageDialog(null, "You grab some nearby brush and hide underneath it.");
                JOptionPane.showMessageDialog(null, "The noises you heard turned out to be cannibalistic hunters.");
                JOptionPane.showMessageDialog(null, "Their dogs find you.");
                JOptionPane.showMessageDialog(null, "The cannibals capture you.");
                if (person.health < 35) {
                    JOptionPane.showMessageDialog(null, "During the travel back to the cannibal's camp, you hear \n"
                            + "the cannibals decide that they'd rather eat a salad.");
                    JOptionPane.showMessageDialog(null, "They toss you off of their caravan, leaving you for dead.");
                    JOptionPane.showMessageDialog(null,
                            "You've lived a good life, but maybe you should've eaten some quality foods.");
                    person.setHealth(100);
                    person.checkHealth();
                }
                person.setHealth(-100);
                person.checkHealth();
            }
        }
    }
}
