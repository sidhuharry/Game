
package com.harry.game.runner;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Formatter;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.harry.game.modal.Ball;
import com.harry.game.modal.Box;
import com.harry.game.modal.Player;
import com.harry.game.physics.PhysicsStuff;

/**
 * it has the main method. It also set the game and runs the game
 */

@SuppressWarnings("serial")
public class TheGame extends JPanel {

	private static Ball ball = new Ball();
	private static Box box[] = new Box[2];
	private static Player player[] = new Player[2];
	public final static int P_HEIGHT = 600;
	public static final int P_WIDTH = 600;

	/**
	 * @param args
	 */
	public static void main(String args[]) {
		
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				TheGame gamePanel = new TheGame();
				setGame();
				// set the frame
				JFrame frame = new JFrame();
				frame.setBackground(Color.BLACK);
				gamePanel.setBackground(Color.BLACK);

				gamePanel.addKeyListener(new KeyListener() {
					@Override
					public void keyPressed(KeyEvent e) {
						if (e.getKeyCode() == KeyEvent.VK_LEFT) {
							box[0].moveLeft();
							box[1].moveLeft();
						}
						if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
							box[0].moveRight();
							box[1].moveRight();
						}
					}
					@Override
					public void keyTyped(KeyEvent e) {}
					@Override
					public void keyReleased(KeyEvent e) {}
				});
				gamePanel.runGame();
				gamePanel.setFocusable(true);
				frame.add(gamePanel);
				frame.setVisible(true);
				gamePanel.setPreferredSize(new Dimension(TheGame.P_HEIGHT, TheGame.P_WIDTH));
				frame.pack();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		});
	}

	public static void setGame() {
		// set The stripes
		ball.setX(getRandomNumber());
		ball.setY(getRandomNumber());
		ball.setSpeedX(2);
		ball.setSpeedY(3);

		for (int i = 0; i < player.length; i++) {
			player[i] = new Player();
			box[i] = new Box();
			player[i].setBox(box[i]);
		}

		box[0].setX((TheGame.P_WIDTH / 2)-50);
		box[0].setY(10);
		box[0].setSpeedX(2);
		box[0].setAxis('X');

		box[1].setX((TheGame.P_WIDTH / 2)-50);
		box[1].setY(575);
		box[1].setSpeedX(2);
		box[1].setAxis('X');
	}
	
	public static void resetGame() {
		// set The stripes
		ball.setX(getRandomNumber());
		ball.setY(getRandomNumber());
		ball.setSpeedX(2);
		ball.setSpeedY(3); 
		
		box[0].setX((TheGame.P_WIDTH / 2)-50);
		box[0].setY(10);
		box[0].setSpeedX(2);
		box[0].setAxis('X');

		box[1].setX((TheGame.P_WIDTH / 2)-50);
		box[1].setY(575);
		box[1].setSpeedX(2);
		box[1].setAxis('X');
	}

	@SuppressWarnings("resource")
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.BLUE);
		// draw the box
		for (int i = 0; i < box.length; i++) {
			box[i].draw(g, box[i].getX(), box[i].getY());
		}
		// draw the ball
		ball.draw(g, ball.getX(), ball.getY());
		// Display the score
		g.setColor(Color.WHITE);
		g.setFont(new Font("Sytem Bold", Font.PLAIN, 20));
		StringBuilder sb = new StringBuilder();
		Formatter formatter = new Formatter(sb);
		formatter.format("SCORE: %d ", player[0].getScore());
		g.drawString(sb.toString(), 250, 50);
		sb = new StringBuilder();
		formatter = new Formatter(sb);
		formatter.format("SCORE: %d", player[1].getScore());
		System.out.println("Score in paint: "+ player[0].getScore() +"--------"+ player[1].getScore() );
		g.drawString(sb.toString(), 250, 550);
	}

	public void runGame() {

		Thread gameThread = new Thread() {
			PhysicsStuff ps = new PhysicsStuff();
			public void run() {
				while (true) {
					ps.checkCollision(ball, player);
					ball.move();
					repaint();
					try {
						Thread.sleep(1000 / 30);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		gameThread.start();
	}

	private static int getRandomNumber() {
		Random ran = new Random();
		int min = 100;
		int max = 400;
		int rand;
		rand = ran.nextInt((max - min)) + min;
		return rand;
	}

}
