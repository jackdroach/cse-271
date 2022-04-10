import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.Timer;

/**
 * @author Jack Roach
 * Date: Apr 3, 2022
 * Class: CSE 271 - E
 */
public class Emoticon extends JFrame {

    private enum Emotes {SMILEY, SAD, SURPRISED, WINKING}
    private Emotes NEXT_EMOTE;

    /**
     * Default constructor. Instantiates a new Emoticon.
     */
    public Emoticon() {
        NEXT_EMOTE = Emotes.SMILEY;
        add(new Emote());

        Timer timer = new Timer(500, new TimeEventListener());
        timer.start();
    }

    /**
     * The main method of the program.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        Emoticon emoticon = new Emoticon();

        emoticon.setSize(900, 300);
        emoticon.setTitle("Emoticon");
        emoticon.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        emoticon.setResizable(false);
        emoticon.setVisible(true);
    }

    /**
     * Repaints emoticons after each delay.
     */
    class TimeEventListener implements ActionListener {

        /**
         * {@inheritDoc}
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            repaint();
        }

    }

    /**
     * Paints emoticons as JComponents.
     */
    class Emote extends JComponent {

        /**
         * {@inheritDoc}
         */
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            switch (NEXT_EMOTE) {
                case SMILEY:
                    paintSmiley(g);
                    NEXT_EMOTE = Emotes.SAD;
                    break;

                case SAD:
                    paintSad(g);
                    NEXT_EMOTE = Emotes.SURPRISED;
                    break;

                case SURPRISED:
                    paintSurprised(g);
                    NEXT_EMOTE = Emotes.WINKING;
                    break;

                case WINKING:
                    paintWinking(g);
                    NEXT_EMOTE = Emotes.SMILEY;
                    break;
            }
        }

        /**
         * Paints a smiley emoticon.
         */
        private void paintSmiley(Graphics g) {
            g.setColor(Color.YELLOW);
            g.fillOval(60, 60, 150, 150);
            g.setColor(Color.BLUE);
            g.fillOval(100, 95, 20, 20);
            g.fillOval(150, 95, 20, 20);
            g.setColor(Color.RED);
            g.drawArc(100, 135, 70, 45, 180, 180);
        }

        /**
         * Paints a sad emoticon.
         */
        private void paintSad(Graphics g) {
            g.setColor(Color.YELLOW);
            g.fillOval(270, 60, 150, 150);
            g.setColor(Color.BLUE);
            g.fillOval(310, 95, 20, 20);
            g.fillOval(360, 95, 20, 20);
            g.setColor(Color.RED);
            g.drawArc(310, 160, 70, 45, 0, 180);
        }

        /**
         * Paints a surprised emoticon.
         */
        private void paintSurprised(Graphics g) {
            g.setColor(Color.YELLOW);
            g.fillOval(480, 60, 150, 150);
            g.setColor(Color.BLUE);
            g.fillOval(520, 95, 20, 20);
            g.fillOval(570, 95, 20, 20);
            g.setColor(Color.RED);
            g.drawArc(540, 150, 20, 20, 0, 360);
        }

        /**
         * Paints a winking emoticon.
         */
        private void paintWinking(Graphics g) {
            g.setColor(Color.YELLOW);
            g.fillOval(690, 60, 150, 150);
            g.setColor(Color.BLUE);
            g.fillOval(730, 95, 20, 20);
            g.drawLine(780, 105, 800, 105);
            g.setColor(Color.RED);
            g.drawArc(730, 135, 70, 45, 180, 180);
        }

    }

}