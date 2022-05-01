import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import javax.swing.JComponent;

/**
 * @author Jack Roach
 * Date: Apr 17, 2022
 * Class: CSE 271 - E
 */
public class Turret extends JComponent {

    private Rectangle base;
    private Rectangle turret;
    private Color turretColor;

    /**
     * Default constructor. Instantiates a new Turret.
     */
    public Turret() {
        base = new Rectangle(450 - 100 / 2, 490, 100, 30);
        turret = new Rectangle(450 - 20 / 2, 435, 20, 60);
        turretColor = Color.BLACK;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(turretColor);

        g.fillRect((int) base.getX(), (int) base.getY(), (int) base.getWidth(), (int) base.getHeight());

        g.fillRect((int) turret.getX(), (int) turret.getY(), (int) turret.getWidth(), (int) turret.getHeight());
    }
}