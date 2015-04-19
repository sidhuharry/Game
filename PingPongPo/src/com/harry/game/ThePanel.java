//Contains the main method and used to run the game.

package com.harry.game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class ThePanel extends JPanel {

	private static Ball ball = new Ball();
	private static Box box = new Box();
	static final int P_HEIGHT = 600;
	static final int P_WIDTH = 600;

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		javax.swing.SwingUtilities.invokeLater(new Runnable() {

			public void run() {
				ThePanel panel = new ThePanel();
				setStripes();
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
							box.moveLeft();
						}
						if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
							box.moveRight();
						}
					}
				});
				panel.runGame();
				panel.setFocusable(true);
				frame.add(panel);
				frame.setVisible(true);
				panel.setPreferredSize(new Dimension(ThePanel.P_HEIGHT,
						ThePanel.P_WIDTH));
				frame.pack();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		});
	}

	public static void setStripes() {
		// set The stripes
		ball.setX(458);
		ball.setY(458);
		ball.setSpeedX(2);
		ball.setSpeedY(3);
		box.setX(10);
		box.setY(10);
		box.setSpeedX(2);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.BLUE);
		// draw the box
		box.draw(g, box.getX(), box.getY());
		// draw the ball
		ball.draw(g, ball.getX(), ball.getY());
	}

	public void runGame() {
		Thread gameThread = new Thread() {
			public void run() {
				while (true) {
					ball.move(box);
					repaint();
					try {
						Thread.sleep(1000/30);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		gameThread.start();
	}

}
