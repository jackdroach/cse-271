import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JComponent;

public class Missile extends JComponent {

    private int missileSpeed;
    private Color missileColor;

    public Missile() {
        missileSpeed = 5;
        missileColor = new Color(228, 76, 90);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawOval(getX(), getY(), 10, 10);
    }

    public void move(int width, int height, ArrayList<Missile> list, int missile) {
        if (getX() <= 0) {
            list.remove(missile);
        }

        setBounds(getX() - missileSpeed, getY(), width, height);
    }

}