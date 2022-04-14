import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JComponent;

public abstract class Enemy extends JComponent {

    private double enemySpeed;
    private Color enemyColor;

    public Enemy(int enemyXCoord, int enemyYCoord, int enemyHeight,
        int enemyWidth, double enemySpeed) {

        super.setBounds(enemyXCoord, enemyYCoord, enemyWidth, enemyHeight);
        this.enemySpeed = enemySpeed;
    }

    public abstract void processCollision(ArrayList<Enemy> list, int enemy);

    public abstract void setColor();

    public abstract void move(int width, int height);

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(enemyColor);
        g.drawOval(getX(), getY(), getWidth(), getHeight());
    }

    /**
     *
     * @return
     */
    public double getEnemySpeed() {
        return enemySpeed;
    }

    public void setEnemySpeed(double enemySpeed) {
        this.enemySpeed = enemySpeed;
    }

    public Color getEnemyColor() {
        return enemyColor;
    }

    public void setEnemyColor(Color enemyColor) {
        this.enemyColor = enemyColor;
    }

}