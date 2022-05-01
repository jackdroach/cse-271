import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JComponent;

/**
 * @author Jack Roach
 * Date: Apr 17, 2022
 * Class: CSE 271 - E
 */
public class Missile extends JComponent {

    private int missileSpeed;
    private Color missileColor;

    /**
     * Default constructor. Instantiates a new Missile.
     */
    public Missile() {
        missileSpeed = 10;
        missileColor = new Color(228, 76, 90);
        setBounds(450 - 15 / 2 - 1, 500, 15, 15);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(missileColor);
        g.fillOval(getX(), getY(), getWidth(), getHeight());
    }

    /**
     * Moves a Missile by a factor of its current speed.
     *
     * @param width frame width
     * @param height frame height
     * @param list missile list
     * @param missile missile index
     */
    public void move(int width, int height, ArrayList<Missile> list, int missile) {
        if (getY() == -20) {
            return;
        }

        list.get(missile).setBounds(getX(), getY() - missileSpeed, getWidth(), getHeight());
    }

}