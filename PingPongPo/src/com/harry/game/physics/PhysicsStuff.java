/**
 * Detects collision and give response to it.
 */

package com.harry.game.physics;

import java.awt.geom.Ellipse2D;

import com.harry.game.modal.Ball;
import com.harry.game.modal.Box;
import com.harry.game.modal.Player;
import com.harry.game.modal.ThePanel;

public class PhysicsStuff {

	/**
	 * Check for collision with any of Danger zone i.e. The zone below the box's
	 * surface.
	 * 
	 * @param ball
	 * @param box
	 */
	public boolean checkCollision(Ball ball, Player[] player) {

		boolean collision = false;
		Ellipse2D ballCircle = new Ellipse2D.Float(ball.getX(), ball.getY(), 2 * Ball.RADIUS, 2 * Ball.RADIUS);
		/*
		 * There are main 2 things with which my ball can collide 1. The
		 * muthafucking box 2. The muthafucking container
		 */
		// -- this here, is a check for upper surface of panel my man.
		if (ballCircle.intersects(0, 0, ThePanel.P_WIDTH, 0.001)) {
			for (int i = 0; i < player.length; i++) {
				Box b = player[i].getBox();
				if (b.getY() <= 20) {
					ball.setY(b.getY()+Box.HEIGHT);
					player[i].decreaseScore();
					ThePanel.resetGame();
				}
			}
			// -- and this here, is a check for lower surface of panel
		} else if (ballCircle.intersects(0, ThePanel.P_HEIGHT, ThePanel.P_WIDTH, 0.001)) {

			for (int i = 0; i < player.length; i++) {
				Box b = player[i].getBox();
				if (b.getY() >= 40) {
					ball.setY(b.getY());
					player[i].decreaseScore();
					ThePanel.resetGame();
				}
			}
		}

		// collision with left surface of the panel
		if (ballCircle.intersects(0.0, 0.0, 0.001, ThePanel.P_HEIGHT)) {
			ball.setX(0); //
			ball.setSpeedX((int) -ball.getSpeedX());
		} else if (ballCircle.intersects(ThePanel.P_WIDTH, 0.0, 0.001, ThePanel.P_HEIGHT)) {
			ball.setX(ThePanel.P_WIDTH - 2 * Ball.RADIUS);
			ball.setSpeedX((int) -ball.getSpeedX());
		}

		/*
		 * Collision checking with box and ball
		 */

		for (int i = 0; i < player.length; i++) {
			if (ballCircle.intersects(player[i].getBox().getX(), player[i].getBox().getY(), Box.WIDTH, Box.HEIGHT)) {
				if (player[i].getBox().getAxis() == 'X') {

					ball.setSpeedY((int) -ball.getSpeedY()); // reverse the
																// speed

				} else if (player[i].getBox().getAxis() == 'Y') {

					ball.setSpeedX((int) -ball.getSpeedX()); // reverse the
																// speed

				}
			}
		}
		return collision;
	}
}
