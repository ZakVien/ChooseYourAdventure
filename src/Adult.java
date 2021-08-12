
import javax.swing.JOptionPane;

/**
 *
 * @author Zach
 */

public class Adult extends Human {

    public void checkHealth() {
        if (health <= 0) {
            JOptionPane.showMessageDialog(null, "You ran out of health. Better luck next time.\n", "Game Over",
                    JOptionPane.WARNING_MESSAGE);
            System.exit(0);
        } else if (health >= 100) {
            JOptionPane.showMessageDialog(null,
                    "After what seems like an eternity, " + "a search and \nrescue team finds you and saves you.");
            System.exit(0);
        }
    }
}
