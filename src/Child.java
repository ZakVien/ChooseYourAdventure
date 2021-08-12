
import javax.swing.JOptionPane;

/**
 *
 * @author Zach
 */

public class Child extends Human {

    public void checkHealth() {
        if (health <= 0) {
            JOptionPane.showMessageDialog(null, "You were found unconcious. Better luck next time.\n", "Game Over",
                    JOptionPane.WARNING_MESSAGE);
            System.exit(0);
        } else if (health >= 100) {
            JOptionPane.showMessageDialog(null, "Your parents found you and grounded you for running away from home.",
                    "Game Over", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }
    }

    public void setHealth(int hp) {
        if (health > 90) {
            health = health + hp;
        } else {
            health = health + hp + 11;
        }
        if (health > 100) {
            health = 100;
        }
    }
}
