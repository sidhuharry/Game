/**
 * Detects collision and give response to it.
 */

package com.harry.game;

import java.awt.geom.Ellipse2D;

public class PhysicsStuff {

	/**
	 * Check for collision with any of Danger zone i.e. The zone below the box's
	 * surface.
	 * 
	 * @param ball
	 * @param box
	 */
	public boolean collisionDangerZone(Ball ball, Player[] player) {

		boolean collision = false;
		/*
		 * There are main 2 things with which my ball can collide 1. The
		 * muthafucking box 2. The muthafucking container
		 */

		if (ball.getX() < 0) {
			//if(player[i].getBox())
	
		} else if ((ball.getX() + (2 * Ball.RADIUS)) > ThePanel.P_WIDTH) {
			//speedX = -speedX;
			ball.setX(ThePanel.P_WIDTH - (2 * Ball.RADIUS));
		}

		// check for Y
		if ((ball.getY()) < 0) {
			//speedY = -speedY;
			//setY(0);
		} else if ((ball.getY() + (2 * Ball.RADIUS)) > ThePanel.P_HEIGHT) {
			System.out.println("Inverting Y line no 77");
			//speedY = -speedY;
			ball.setY(ThePanel.P_HEIGHT - (2 * Ball.RADIUS));
		}

		/*
		 * Collision checking with box and ball
		 */
		Ellipse2D ballCircle = new Ellipse2D.Float(ball.getX(), ball.getY(), 2 * Ball.RADIUS, 2 * Ball.RADIUS);
		
		for (int i = 0; i < player.length; i++) {
			if (ballCircle.intersects(player[i].getBox().getX(), player[i].getBox().getY(), Box.WIDTH, Box.HEIGHT)) {
				if (player[i].getBox().getAxis() == 'X') {

					ball.setSpeedY((int) -ball.getSpeedY()); //reverse the speed

				} else if (player[i].getBox().getAxis() == 'Y') {

					ball.setSpeedX((int) -ball.getSpeedX()); //reverse the speed

				}
			}
		}
		return collision;
	}

}
