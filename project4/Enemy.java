import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JComponent;

/**
 * @author Jack Roach
 * Date: Apr 17, 2022
 * Class: CSE 271 - E
 */
public abstract class Enemy extends JComponent {

    private double enemySpeed;
    private Color enemyColor;

    /**
     * Default constructor. Instantiates a new Enemy.
     */
    public Enemy(int enemyXCoord, int enemyYCoord, int enemyHeight,
        int enemyWidth, double enemySpeed) {

        setBounds(enemyXCoord, enemyYCoord, enemyWidth, enemyHeight);
        this.enemySpeed = enemySpeed;
    }

    /**
     * Shrinks or removes Enemies after they are hit by missiles.
     */
    public abstract void processCollision(ArrayList<Enemy> list, int enemy);

    /**
     * Sets the used to repaint Enemies.
     */
    public abstract void setColor();

    /**
     * Moves an Enemy by a factor of its current speed.
     *
     * @param width frame width
     * @param height frame height
     */
    public abstract void move(int width, int height);

    /**
     * {@inheritDoc}
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(enemyColor);
        g.fillOval(getX(), getY(), getWidth(), getHeight());

    }

    /**
     * Gets the enemySpeed.
     *
     * @return enemySpeed
     */
    public double getEnemySpeed() {
        return enemySpeed;
    }

    /**
     * Sets the enemySpeed.
     *
     * @param enemySpeed enemySpeed
     */
    public void setEnemySpeed(double enemySpeed) {
        this.enemySpeed = enemySpeed;
    }

    /**
     * Gets the enemyColor.
     *
     * @return enemyColor
     */
    public Color getEnemyColor() {
        return enemyColor;
    }

    /**
     * Sets the enemyColor.
     *
     * @param enemyColor enemyColor
     */
    public void setEnemyColor(Color enemyColor) {
        this.enemyColor = enemyColor;
    }

}