import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import javax.swing.JComponent;

public class Turret extends JComponent {

    private Rectangle base;
    private Rectangle turret;
    private Color turrentColor;

    public Turret() {

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawRect((int) base.getX(), (int) base.getY(), (int) base.getWidth(), (int) base.getHeight());

        g.drawRect((int) turret.getX(), (int) turret.getY(), (int) turret.getWidth(), (int) turret.getHeight());
    }
}