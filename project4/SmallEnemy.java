import java.awt.Color;
import java.util.ArrayList;

public class SmallEnemy extends Enemy {

    public SmallEnemy() {
        super(0, 0, 50, 50, 5);
    }

    @Override
    public void processCollision(ArrayList<Enemy> list, int enemy) {
        if (getWidth() >= 0 && getHeight() >= 0) {
            list.remove(enemy);
            return;
        }

        list.get(enemy).setBounds(getX(), getY(), getWidth() - 10, getHeight() - 10);
    }

    @Override
    public void setColor() {
        setEnemyColor(new Color(62, 140, 51));
    }

    @Override
    public void move(int width, int height) {
        if (getX() <= 0 || getX() >= 960) {
            setEnemySpeed(0 - getEnemySpeed());
        }

        setBounds(getX(), getY() + (int) getEnemySpeed(), getWidth(), getHeight());

        if (getEnemySpeed() > 0) {
            setEnemySpeed(getEnemySpeed() + 1);
        } else {
            setEnemySpeed(getEnemySpeed() - 1);
        }
    }

}