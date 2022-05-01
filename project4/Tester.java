import java.awt.BorderLayout;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * The driver class for Project 4. 
 * 
 * @author Dr. Garrett Goodman
 * @author Jack Roach
 * Date: Apr 17, 2022
 * Class: CSE 271 - E
 */
public class Tester extends JFrame {

	private static final int WINDOW_WIDTH = 900;
	private static final int WINDOW_HEIGHT = 600;
	private int score;
	private int timer;
	private int missilesFired;
	private JLabel scoreLabel;
	private JButton fireButton;
	private GamePanel panel;

	/**
	 * Default constructor to control the game.
	 */
	public Tester() {
		score = 0;
		timer = 0;
		missilesFired = 0;
		scoreLabel = new JLabel("Score: 0");
		fireButton = new JButton("Fire Missile!");
		fireButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				panel.addMissile();
				missilesFired++;
			}
		});
		panel = new GamePanel();

		constructFrame();

		panel.addEnemy();
		panel.addEnemy();
	}

	/**
	 * Constructs the Tester JFrame.
	 */
	public void constructFrame() {
		setLayout(new BorderLayout());
		add(fireButton, BorderLayout.SOUTH);
		add(scoreLabel, BorderLayout.NORTH);
		add(panel);

		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		setTitle("Ball Destruction!");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);

		centerFrame(this);
	}
	
	/**
	 * This method is called to start the video game which then
	 * calls the infinite game loop for the game.
	 */
	public void start() {
		gameLoop();
	}

	/**
	 * Method contains the game loop to move enemies, manage score,
	 * and check if the game is finished.
	 */
	public void gameLoop() {
		while(true) {
			if (missilesFired >= 10) {
				panel.setVisible(false);
				if (score >= 850) {
					scoreLabel.setText("You win!");
				} else {
					scoreLabel.setText("You lose.");
				}
			} else {
				pauseGame();
				panel.detectCollision();
				score = panel.getTotalScore();
				scoreLabel.setText("Score: " + score);
				panel.move();
				repaint();

				setTimer();
				if (timer % 100 == 0) {
					panel.addEnemy();
				}
			}
		}  
	}

	/**
	 * Pauses the thread for 30ms to control the 
	 * speed of the animations.
	 */
	public void pauseGame() {
		try {
			Thread.sleep(30);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Method centers the frame in the middle of the screen.
	 * 
	 * @param frame to center with respect to the users screen dimensions.
	 */
	public void centerFrame(JFrame frame) {    
		int width = frame.getWidth();
		int height = frame.getHeight();
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		Point center = ge.getCenterPoint();

		int xPosition = center.x - width / 2, yPosition = center.y - height / 2;
		frame.setBounds(xPosition, yPosition, width, height);
		frame.validate();
	}

	/**
	 * Randomly assign a value to determine how soon a new Enemy should
	 * be created.
	 */
	public void setTimer() {
		timer = (int)(Math.random() * 100);
	}

	/**
	 * The main method to execute the program.
	 * 
	 * @param args Any inputs to the program when it starts.
	 */
	public static void main(String[] args) {
		Tester main = new Tester();
		main.start();
	}

}
