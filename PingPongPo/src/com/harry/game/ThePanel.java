//Contains the main method and used to run the game.

package com.harry.game;

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

@SuppressWarnings("serial")
public class ThePanel extends JPanel {

	private static Ball ball = new Ball();
	private static Box box[] = new Box[2];
	private static Player player[] = new Player[2];
	static final int P_HEIGHT = 600;
	static final int P_WIDTH = 600;

	/**
	 * @param args
	 */
	public static void main(String args[]) {

		javax.swing.SwingUtilities.invokeLater(new Runnable() {

			public void run() {
				ThePanel panel = new ThePanel();
				setGame();
				// set the frame
				JFrame frame = new JFrame();
				frame.setBackground(Color.BLACK);
				panel.setBackground(Color.BLACK);

				panel.addKeyListener(new KeyListener() {

					@Override
					public void keyTyped(KeyEvent e) {
						// Nothing
					}

					@Override
					public void keyReleased(KeyEvent e) {
						// Nothing

					}

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
				});
				panel.runGame();
				panel.setFocusable(true);
				frame.add(panel);
				frame.setVisible(true);
				panel.setPreferredSize(new Dimension(ThePanel.P_HEIGHT, ThePanel.P_WIDTH));
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

		box[0].setX((ThePanel.P_WIDTH / 2)-50);
		box[0].setY(10);
		box[0].setSpeedX(2);
		box[0].setAxis('X');

		box[1].setX((ThePanel.P_WIDTH / 2)-50);
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
		
		box[0].setX((ThePanel.P_WIDTH / 2)-50);
		box[0].setY(10);
		box[0].setSpeedX(2);
		box[0].setAxis('X');

		box[1].setX((ThePanel.P_WIDTH / 2)-50);
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

	public static int getRandomNumber() {
		Random ran = new Random();
		int min = 100;
		int max = 400;
		int rand;

		rand = ran.nextInt((max - min)) + min;
		return rand;

	}

}
