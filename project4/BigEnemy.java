import java.awt.Color;
import java.util.ArrayList;

/**
 * @author Jack Roach
 * Date: Apr 17, 2022
 * Class: CSE 271 - E
 */
public class BigEnemy extends Enemy {

    /**
     * Default constructor. Instantiates a new BigEnemy.
     */
    public BigEnemy() {
        super(900 - 50 - 10, 100, 50, 50, 2);
        setColor();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void processCollision(ArrayList<Enemy> list, int enemy) {
        if (getWidth() <= 0 || getHeight() <= 0) {
            list.remove(enemy);
            return;
        }

        setBounds(getX(), getY(), getWidth() - 10, getHeight() - 10);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setColor() {
        setEnemyColor(new Color(25, 153, 74));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void move(int width, int height) {
        if (getX() <= 0 || getX() >= 900 - 50 - 10) {
            setEnemySpeed(0 - getEnemySpeed());
        }

        setBounds(getX() + (int) getEnemySpeed(), getY(), getWidth(), getHeight());
    }

}