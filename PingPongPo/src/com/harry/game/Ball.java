package com.harry.game;

import java.awt.Graphics;
import java.awt.geom.Ellipse2D;

//overrides Stripe
public class Ball extends Stripe {
	public Ball() {
	}

	private static final int RADIUS = 15;
	private static float speedX;
	private static float speedY;

	public float getSpeedX() {
		return speedX;
	}

	public void setSpeedX(int speedX) {
		Ball.speedX = speedX;
	}

	public float getSpeedY() {
		return speedY;
	}

	public void setSpeedY(int speedY) {
		Ball.speedY = speedY;
	}

	@Override
	void draw(Graphics g, int x, int y) {
		g.fillOval(x, y, 2 * RADIUS, 2 * RADIUS);
		System.out.println("X : " + x);
		System.out.println("Y : " + y);
	}

	void move(Box box) {

		// check for the collision and move the ball
		setX((int) (getX() + speedX));
		setY((int) (getY() + speedY));

		/*
		 * There are main 2 things with which my ball can collide 1. The
		 * muthafucking box 2. The muthafucking container
		 */

		if (getX() < 0) {
			speedX = -speedX;
			setX(0); // reposition
		} else if ((getX() + (2 * RADIUS)) > ThePanel.P_WIDTH) {
			speedX = -speedX;
			setX(ThePanel.P_WIDTH - (2 * RADIUS));
		}

		// check for Y
		if ((getY()) < 0) {
			speedY = -speedY;
			setY(0);
		} else if ((getY() + (2 * RADIUS)) > ThePanel.P_HEIGHT) {
			System.out.println("Inverting Y line no 77");
			speedY = -speedY;
			setY(ThePanel.P_HEIGHT - (2 * RADIUS));
		}
		// was used for to check box and ball collision
		// if(((getY()+(2*RADIUS)) > box.getY()) && (( (getX()+(2*RADIUS)) >
		// box.getX()) && (getX() < (box.getX() + Box.WIDTH)) ) ) { // box's Y
		// and ball's bottom Y are same then
		// speedY = -speedY;
		// }

		Ellipse2D ballCircle = new Ellipse2D.Float(getX(), getY(), 2 * RADIUS, 2 * RADIUS);
		if (ballCircle.intersects(box.getX(), box.getY(), Box.WIDTH, Box.HEIGHT) ) {
			if(box.getAxis()=='X') {
				speedY = -speedY;
			}
			else if(box.getAxis()=='Y') {
				speedX = -speedX;
			}
		}
	}
}
