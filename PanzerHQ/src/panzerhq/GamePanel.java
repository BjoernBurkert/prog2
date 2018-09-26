package panzerhq;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import static java.awt.event.KeyEvent.*;



public class GamePanel extends JPanel{
	
	private Missile testMissileOne;
	private Missile testMissileTwo;
	
	private Tank testTank;
	
	public static final String IMAGE_DIR = "../images/";
	
	private final Dimension prefSize = new Dimension(1180, 780);
	
	private ImageIcon backgroundImage;
	private final String[] backgroundImages = new String [] {"bg_mud.jpg",
															 "bg_snow.jpg",
															 "bg_sand.jpg"};
	
	private boolean gameOver = false;
	private int tanksDestroyedCounter = 0;
	
	private Timer t;
	
	public GamePanel() {
		setFocusable(true);
		setPreferredSize(prefSize);
		
		initGame();
		startGame();
	}
	
	public boolean isGameOver() {
		return gameOver;
	}
	
	public void setGameOver(boolean gameOver) {
		this.gameOver = gameOver;
	}
	
	private void initGame() {
		setBackgroundImage(1);
		createGameObjects();
		
		initPlayersTank();
		
		t = new Timer(20, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				doOnTick();
			}
		});
		
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
			
			switch(e.getKeyCode()) {	
				case VK_SPACE:
					if (testTank.isAbleToShoot()) {
						testMissileOne = testTank.shoot();
					}
					break;
					
				case VK_DOWN:
				case VK_UP: testTank.stopTank(); break;
				
				case VK_LEFT:
				case VK_RIGHT: testTank.stopTurningTank(); break;
				
				case VK_W:
				case VK_E: testTank.stopTurningCannon(); break;
			}
		}
		
		@Override
		public void keyPressed(KeyEvent e) {
			switch(e.getKeyCode()) {
			case VK_LEFT: testTank.turnTankLeft(); break;
			case VK_RIGHT: testTank.turnTankRight(); break;
			
			case VK_UP: testTank.accelerateTank(); break;
			case VK_DOWN: testTank.decelerateTank(); break;
			
			case VK_W: testTank.turnCannonLeft(); break;
			case VK_E: testTank.turnCannonRight(); break;
			}
		}
	});
	}
	
	private void createGameObjects() {
		// hier werden wir später die Spielobjekte erzeugen.
		testMissileOne = new Missile(new Coordinate(200, 100), 9, Math.toRadians(45), 5);
		testMissileTwo = new Missile(new Coordinate(200, 609), 9, Math.toRadians(-45), 5);
	}
	
	private void initPlayersTank() {
		// hier werden wir die Panzer des Spielers initialisieren
		
		//testTank = new Tank(new Coordinate(630, 260), 70, 45, Math.toRadians(270), 0);
		//testTank.accelerateTank();
		//testTank.turnTankLeft();
		//testTank.turnCannonRight();
		//testMissileOne = testTank.shoot();
	}
	
	public void setBackgroundImage(int imageNumber) {
		String imagePath = IMAGE_DIR + backgroundImages[imageNumber];
		URL imageURL = getClass().getResource(imagePath);
		backgroundImage = new ImageIcon(imageURL);
	}
	
	private void startGame() {
		t.start();
	}
	
	void pauseGame() {
		t.stop();
	}
	
	void continueGame() {
		if (!isGameOver()) t.start();
	}
	
	public void restartGame() {
		tanksDestroyedCounter = 0;
		setGameOver(false);
		createGameObjects();
		startGame();
	}
	
	private void endGame() {
		setGameOver(true);
		pauseGame();
	}
	
	private void doOnTick() {
		tanksDestroyedCounter++;
		if (tanksDestroyedCounter > 2015) endGame();
		
		testMissileOne.makeMove();
		testMissileTwo.makeMove();
		//if(testMissileOne.touches(testMissileTwo)) endGame();
		
		testTank.makeMove();
		if (testTank.touches(testMissileTwo)) endGame();
		//if(testTank.isAbleToShoot()) testMissileOne = testTank.shoot();
		
		if(testMissileTwo.getRange() < 1) testMissileTwo = new Missile(new Coordinate(200,609), 9, Math.toRadians(-45), 5);
		
		repaint();
	}
	
	@Override
	public void paintComponent (Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		backgroundImage.paintIcon(null, g, 0, 0);
		
		g.setFont(new Font(Font.MONOSPACED, Font.BOLD, 19));
		g.setColor(Color.BLUE);
		g.drawString("Tanks destroyed: " + tanksDestroyedCounter, 22, prefSize.height-5);
		
		if (isGameOver()) {
			g.setFont(new Font(Font.MONOSPACED, Font.BOLD, 50));
			g.setColor(Color.RED);
			g.drawString("GAME OVER! ", prefSize.width/2 - 130, prefSize.height/5);
		}
		
		testTank.paintMe(g);
		
		testMissileOne.paintMe(g);
		testMissileTwo.paintMe(g);
	}
}
