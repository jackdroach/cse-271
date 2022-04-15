import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import javax.swing.JComponent;

public class Turret extends JComponent {

    private Rectangle base;
    private Rectangle turret;
    private Color turretColor;

    public Turret() {
        base = new Rectangle(400, 545, 100, 30);
        turret = new Rectangle(440, 490, 20, 60);
        turretColor = Color.BLACK;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(turretColor);

        g.fillRect((int) base.getX(), (int) base.getY(), (int) base.getWidth(), (int) base.getHeight());

        g.fillRect((int) turret.getX(), (int) turret.getY(), (int) turret.getWidth(), (int) turret.getHeight());
    }
}