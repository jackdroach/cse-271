import java.awt.Color;
import java.util.ArrayList;

public class BigEnemy extends Enemy {

    public BigEnemy() {
        super(0, 0, 100, 100, 5);
    }

    @Override
    public void processCollision(ArrayList<Enemy> list, int enemy) {
        if (getWidth() >= 0 && getHeight() >= 0) {
            list.remove(enemy);
            return;
        }

        list.get(enemy).setBounds(getX(), getY(), getWidth() - 20, getHeight() - 20);
    }

    @Override
    public void setColor() {
        setEnemyColor(new Color(25, 153, 74));
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