import java.awt.Color;
import java.util.ArrayList;

/**
 * @author Jack Roach
 * Date: Apr 17, 2022
 * Class: CSE 271 - E
 */
public class SmallEnemy extends Enemy {

    /**
     * Default constructor. Instantiates a new SmallEnemy.
     */
    public SmallEnemy() {
        super(1, 300, 25, 25, 2);
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

        list.get(enemy).setBounds(getX(), getY(), getWidth() - 5, getHeight() - 5);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setColor() {
        setEnemyColor(new Color(62, 140, 51));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void move(int width, int height) {
        if (getX() <= 0 || getX() >= 900 - 25 - 10) {
            setEnemySpeed(0 - getEnemySpeed());
        }

        setBounds(getX() + (int) getEnemySpeed(), getY(), getWidth(), getHeight());

        if (getEnemySpeed() > 0) {
            setEnemySpeed(getEnemySpeed() + .01);
        } else {
            setEnemySpeed(getEnemySpeed() - .01);
        }
    }

}