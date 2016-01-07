package com.harry.game.modal;

import java.awt.Graphics;

//overrides Stripe
public class Ball extends Stripe {
	public Ball() {
	}

	public static final int RADIUS = 15;
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
	public void draw(Graphics g, int x, int y) {
		g.fillOval(x, y, 2 * RADIUS, 2 * RADIUS);
		System.out.println("X : " + x);
		System.out.println("Y : " + y);
	}
	
	public void move() {
		setX((int) (getX() + speedX));
		setY((int) (getY() + speedY));
	}
}
